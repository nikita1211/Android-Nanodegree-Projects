package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.ArrayList;

public class JsonUtils {
    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        try {
            JSONObject object = new JSONObject(json);

            JSONObject name = object.getJSONObject("name");
            String mainName = name.optString("mainName");
            JSONArray alsoKnownAsArray = name.optJSONArray("alsoKnownAs");
            List<String> alsoKnownAs = arrayToList(alsoKnownAsArray);
            String placeOfOrigin = object.optString("placeOfOrigin");
            String description = object.optString("description");
            JSONArray ingredientsArray = object.optJSONArray("ingredients");
            List<String> ingredients = arrayToList(ingredientsArray);
            String image = object.optString("image");

            sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        return sandwich;
    }

    private static List<String> arrayToList(JSONArray jsonArray) {
        List<String> stringList = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.length(); i++) {
                stringList.add(jsonArray.optString(i));
            }
        }
        return stringList;
    }
}
