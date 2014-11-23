package controllers;


import java.util.ArrayList;

/**
 * Created by naysayer on 18/10/2014.
 */
public class ApiResponse<T> extends ArrayList<T> {


    private Boolean success;

    private String message;

    public Boolean isSuccess() {
        return success;
    }

    public T value() {
        if (this.size() == 1) {
            return this.iterator().next();
        } else {
            return null;
        }

    }

}
