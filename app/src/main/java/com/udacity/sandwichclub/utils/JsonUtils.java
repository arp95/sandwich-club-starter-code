package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        JSONObject sandwichJson = new JSONObject();
        Sandwich sandwich = new Sandwich();
        try {
            //get sandwich json
            sandwichJson = new JSONObject(json);

            //get main name
            sandwich.setMainName(sandwichJson.getJSONObject("name").getString("mainName"));

            //get image
            sandwich.setImage(sandwichJson.getString("image"));

            //get place of origin
            sandwich.setPlaceOfOrigin(sandwichJson.getString("placeOfOrigin"));

            //get description
            sandwich.setDescription(sandwichJson.getString("description"));

            Log.d("sandwich", "" + sandwichJson);
            //get alsoKnownAs string array
            JSONArray jsonArray1  = sandwichJson.getJSONObject("name").getJSONArray("alsoKnownAs");
            List<String> alsoKnownAs = new ArrayList<String>();
            for(int i=0; i<jsonArray1.length(); i++) {
                String str = (String) jsonArray1.get(i);
                alsoKnownAs.add(str);
            }

            //get ingredients string array
            JSONArray jsonArray2  = sandwichJson.getJSONArray("ingredients");
            List<String> ingredients = new ArrayList<String>();
            for(int i=0; i<jsonArray2.length(); i++) {
                String str = (String) jsonArray2.get(i);
                ingredients.add(str);
            }
            sandwich.setAlsoKnownAs(alsoKnownAs);
            sandwich.setIngredients(ingredients);
        } catch (JSONException E) {

        }
        return sandwich;
    }
}
