package parsers;

import models.User;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

/**
 * Created by naysayer on 19/11/2014.
 */
public class JsonParser
{
    private static JSONSerializer  userSerializer     = new JSONSerializer();

    public static User buildUser(String json)
    {
        return new JSONDeserializer<User>().deserialize(json, User.class);
    }

    public static String renderEntity(Object obj)
    {
        return userSerializer.serialize(obj);
    }
}