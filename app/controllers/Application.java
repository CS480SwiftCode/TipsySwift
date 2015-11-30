package controllers;

import com.avaje.ebean.Ebean;
import models.Locations;
import models.SwagZone;
import play.mvc.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application extends Controller
{

    public Result index() {
        return ok(views.html.main.render(play.twirl.api.Html.apply("html")));
    }
    public Result map() {
        return ok(views.html.main.render(play.twirl.api.Html.apply("html")));
    }
    public Result getLocations(String location) {
        String[] coordinates = location.split("_");

        Double lat = Double.parseDouble(coordinates[0].substring(0,coordinates[0].indexOf(".") + 5));
        Double lon = Double.parseDouble(coordinates[1].substring(0, coordinates[1].indexOf(".") + 5));

        List<SwagZone> zoneList = Ebean.find(SwagZone.class)
                .where()
                .eq("coordinates",coordinates[0] + "," + coordinates[1])
                .findList();

        StringBuilder toReturn = new StringBuilder();
        List<Locations> locationses = new ArrayList<>();

        if (zoneList.size() == 0)
        {
            YelpAPI yelp = new YelpAPI();

            System.out.println("None Found");

            SwagZone newZone = new SwagZone(coordinates[0] + "," + coordinates[1]);
            newZone.save();

            Business[] businesses = null;

            try
            {
                businesses = yelp.returnEverythingWithinRadius(yelp,Double.parseDouble(coordinates[0])
                                                                          ,Double.parseDouble(coordinates[1])
                                                                          ,20,8046);
            } catch (IOException e)
            {
                e.printStackTrace();
            }


            Locations easterEgg = new Locations();
            easterEgg.setName("Easter Island");
            easterEgg.setYelp_url("http://www.tipsyhour.space");
            easterEgg.setPhone("(555) 555-5555");
            easterEgg.setRating(5);
            easterEgg.setLatitude(-27.1167);
            easterEgg.setLongitude(-109.3667);

            locationses.add(easterEgg);

            for (Business b : businesses)
            {
                if (b.getHappyHour() == null || b.getHappyHour().equals("Undetermined., Undetermined."))
                    continue;
                Locations temp = new Locations(b);
                try
                {
                    temp.save();
                }
                catch (Exception e)
                {
                    System.out.println("duplicate entry, reloading");
                    temp.delete();
                    temp.save();
                    continue;
                }
            }
        }

        locationses.addAll(Ebean.find(Locations.class)
                                .where()
                                .gt("latitude", Double.parseDouble(coordinates[0]) - 0.05)
                                .lt("latitude", Double.parseDouble(coordinates[0]) + 0.05)
                                .gt("longitude", Double.parseDouble(coordinates[1]) - 0.05)
                                .lt("longitude", Double.parseDouble(coordinates[1]) + 0.05)
                                .findList());

        for (Locations l : locationses)
        {
            toReturn.append(l + "\n");
        }

        System.out.println(toReturn);
        return ok(toReturn.toString());
    }

}
