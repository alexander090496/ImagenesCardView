package com.i015114.imagenescardview.Parser;



import com.i015114.imagenescardview.Model.UrlDetails;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 28/09/2017.
 */

public class JsonUrl {


    public static List<UrlDetails> getData(String content) throws JSONException {
        JSONArray jsonArray = new JSONArray(content);
        List<UrlDetails> urlDetailsList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject item = jsonArray.getJSONObject(i);

            UrlDetails urlDetails = new UrlDetails();
            urlDetails.setTitle(item.getString("title"));
            urlDetails.setUrl1(item.getString("url"));
            urlDetails.setUrl2(item.getString("thumbnailUrl"));

            urlDetailsList.add(urlDetails);
        }
        return urlDetailsList;
    }

}
