package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public Result index() {
        return ok(views.html.main.render(play.twirl.api.Html.apply("html")));
    }
    public Result map() {
        return ok(views.html.main.render(play.twirl.api.Html.apply("html")));
    }
//    public Result getLocations(String lat, String lon) {
//        return "";
//    }

}
