package controllers;

import com.avaje.ebean.Ebean;
import models.Locations;
import models.SwagZone;
import play.*;
import play.mvc.*;

import views.html.*;

import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {

    public Result index() {
        return ok(views.html.main.render(play.twirl.api.Html.apply("html")));
    }
    public Result map() {
        return ok(views.html.main.render(play.twirl.api.Html.apply("html")));
    }
    public Result getLocations(String location) {
        String[] coordinates = location.split("_");

        System.out.println(coordinates.length);

        Double lat = Double.parseDouble(coordinates[0].substring(0,coordinates[0].indexOf(".") + 3));
        Double lon = Double.parseDouble(coordinates[1].substring(0, coordinates[1].indexOf(".") + 3));

        char ns = 'N';
        char ew = 'E';

        if (lat < 0)
        {
            lat = Math.abs(lat);
            ns = 'S';
        }
        if (lon < 0)
        {
            lon = Math.abs(lon);
            ew = 'W';
        }

        List<SwagZone> zoneList = Ebean.find(SwagZone.class)
                .where()
                .eq("latitude",lat)
                .eq("longitude", lon)
                .findList();

        if (zoneList.size() == 0)
        {
            System.out.println("None Found");

            // TODO : add these coordinates to the database, find locations from yelp
            // in a 5 mi radius and add those to db
        }

        // "Name,Address,City,State,ZipCode,CountryCode,URL,Phone,Rating,Latitude,Longitude"

        // intelliJ is gollum, apparently
        List<Locations> locationses = new ArrayList<>();
        Locations easterEgg = new Locations();
        easterEgg.setName("Easter Island");
        easterEgg.setYelp_url("http://www.tipsyhour.space");
        easterEgg.setPhone("(555) 555-5555");
        easterEgg.setRating(5);
        easterEgg.setLatitude(27.1167);
        easterEgg.setN_s('S');
        easterEgg.setLongitude(109.3667);
        easterEgg.setE_w('W');

        locationses.add(easterEgg);

        locationses.addAll(Ebean.find(Locations.class)
                                .where()
                                .gt("latitude", lat - 0.2)
                                .lt("latitude", lat + 0.2)
                                .gt("longitude", lon - 0.2)
                                .lt("longitude", lon + 0.2)
                                .findList());

        StringBuilder toReturn = new StringBuilder();
        for (Locations l : locationses)
        {
            toReturn.append(l + "\n");
        }
        location = "The Famous,154 S Brand Blvd,Glendale,CA,91204,US,http://www.yelp.com/biz/the-famous-glendale,8182412888,4.5,34.1447983682156,-118.254895359278";
        System.out.println(toReturn);
        return ok(toReturn.toString());
    }

}
