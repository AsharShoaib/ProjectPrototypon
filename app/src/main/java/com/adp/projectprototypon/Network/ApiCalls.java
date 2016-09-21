package com.adp.projectprototypon.Network;

import android.support.annotation.NonNull;

import com.adp.projectprototypon.Models.Category;
import com.android.volley.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * Created by asharshoaib on 2016-09-19.
 */
public class ApiCalls {

    public static GsonGetRequest<Category> getObject
            (
                    @NonNull final Response.Listener<Category> listener,
                    @NonNull final Response.ErrorListener errorListener
            )
    {
        final String url = "https://kinactiv.mybluemix.net/api/v1/categories";

        return new GsonGetRequest<>
                (
                        url,
                        new TypeToken<Category>() {}.getType(),
                        new GsonBuilder().create(),
                        listener,
                        errorListener
                );
    }
}
