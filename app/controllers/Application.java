package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public Result index() {
        return ok(views.html.main.render("Test",play.twirl.api.Html.apply("html")));
    }



}
