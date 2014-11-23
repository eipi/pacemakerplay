package controllers;

import play.*;
import play.mvc.*;

import play.twirl.api.Html;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        Html form =  Html.apply(
                "<form>\n" +
                "<input type=\"text\">\n" +
                "<input type=\"submit\">\n" +
                "</form>");
        Result result =
                ok(main.render("Pacemaker - Where have you been today?", form));

        return result;
    }

}
