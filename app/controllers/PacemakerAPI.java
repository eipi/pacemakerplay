package controllers;

import static parsers.JsonParser.*;
import play.mvc.*;

import java.util.*;

import models.*;


/**
 * Created by naysayer on 19/11/2014.
 */
public class PacemakerAPI extends Controller
{

    public static Result  users()
    {
        List<User> users = User.findAll();
        return ok(renderEntity(users));
    }

    public static Result user(Long id)
    {
        User user = User.findById(id);
        return user==null? notFound() : ok(renderEntity(user));
    }

    public static Result createUser()
    {
        User user = buildUser(request().body().asJson().toString());
        user.save();
        return ok(renderEntity(user));
    }

    public static Result deleteUser(Long id)
    {
        Result result = notFound();
        User user = User.findById(id);
        if (user != null)
        {
            user.delete();
            result = ok();
        }
        return result;
    }

    public static Result deleteAllUsers()
    {
        User.deleteAll();
        return ok();
    }

    public static Result updateUser(Long id)
    {
        Result result = notFound();
        User user = User.findById(id);
        if (user != null)
        {
            User updatedUser = buildUser(request().body().asJson().toString());
            user.update(updatedUser);
            user.save();
            result = ok(renderEntity(user));
        }
        return result;
    }
}
