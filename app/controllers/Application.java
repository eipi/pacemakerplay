package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        Result result =
                ok(main.render("Welcome to Pacemaker... Where have you been today?", null));

        return result;
    }

}
