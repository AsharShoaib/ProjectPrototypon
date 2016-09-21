package com.adp.projectprototypon.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.adp.projectprototypon.Base.App;
import com.adp.projectprototypon.Constants;
import com.adp.projectprototypon.Models.Category;
import com.adp.projectprototypon.Network.ApiRequests;
import com.adp.projectprototypon.Network.GsonGetRequest;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asharshoaib on 2016-09-20.
 */
public class SplashActivity extends AppCompatActivity {

    private List<Category.Data> categoryItemList = new ArrayList<>();
    private ArrayList<String> sImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sImages = new ArrayList<>();
        performRequest();

    }

    private void performRequest() {
        final GsonGetRequest<Category> gsonGetRequest =
                ApiRequests.getObject
                        (
                                new Response.Listener<Category>() {
                                    @Override
                                    public void onResponse(Category Object) {
                                        // Deal with the object here
                                        onApiResponse(Object);
                                    }
                                }
                                ,
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        // Deal with the errors here
                                        onApiError();
                                    }
                                }
                        );

        App.addRequest(gsonGetRequest, Constants.TAG_Category_Download);
    }

    private void onApiResponse(final Category Object) {
        setData(Object);
    }

    private void onApiError() {

    }
    //Need to implement Database to store objects and images
    //Check if downloading needs to happen

    private void setData(@NonNull final Category dummyObject) {
        categoryItemList = dummyObject.getData();
        for (Category.Data d : categoryItemList) {
            sImages.add(d.getImage());

        }
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("images", sImages);
        startActivity(intent);
        finish();
    }
}