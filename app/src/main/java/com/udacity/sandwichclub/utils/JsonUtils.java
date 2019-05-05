package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * This method will use a json string as input and use  json data to build a Sandwich object
 */

public class JsonUtils {


    public static Sandwich parseSandwichJson(String json) throws JSONException {


       /* Creates a new JSONObject from the json string */
        JSONObject sandwichJson = new JSONObject(json);
        JSONObject sandwichName = sandwichJson.getJSONObject("name");

        /* Creates ArrayList to hold the alsoKnownAs Strings*/
        List<String> AlsoKnownAsList = new ArrayList<>();
        JSONArray AlsoKnownAsArray = sandwichName.getJSONArray("alsoKnownAs");
        for (int i = 0; i < AlsoKnownAsArray.length(); i++) {
            AlsoKnownAsList.add(AlsoKnownAsArray.optString(i));
        }

        /* Creates ArrayList to hold the ingredients Strings*/
        List<String> IngredientsList = new ArrayList<>();
        JSONArray IngredientsArray = sandwichJson.getJSONArray("ingredients");
        for (int i = 0; i < IngredientsArray.length(); i++) {
            IngredientsList.add(IngredientsArray.optString(i));
        }

        /* Extract Sandwich Name */
        String mainName = sandwichName.optString("mainName");
        /* Extract Sandwich's place of origin */
        String placeOfOrigin = sandwichJson.optString("placeOfOrigin");
         /* Extract Sandwich's description */
        String description = sandwichJson.optString("description");
        /* Extract Sandwich's image */
        String image = sandwichJson.optString("image");

         /* return Sandwich data */
        return new Sandwich(mainName, AlsoKnownAsList, placeOfOrigin, description, image, IngredientsList);
    }


}