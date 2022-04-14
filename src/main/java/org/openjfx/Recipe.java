package org.openjfx;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Recipe {
    public String title;
    public String url;
    public String imageUrl;

    public Recipe() throws ParseException {
        //Connecting to API to get a random recipe
        String key = "token";
        HttpResponse<String> response = Unirest.get("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/random?number=1")
                .header("X-RapidAPI-Host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
                .header("X-RapidAPI-Key", key)
                .asString();

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject)parser.parse(response.getBody());
        JSONArray array =  (JSONArray)jsonObject.get("recipes");

        // Looping through the JSON to find value of "title", "sourceUrl" and "image"
        for(int i = 0; i < array.size(); i++){
            JSONObject recipesObject = (JSONObject) array.get(i);
            this.title = (String) recipesObject.get("title");

            this.url = (String) recipesObject.get("sourceUrl");

            this.imageUrl = (String) recipesObject.get("image");
        }
    }

    public String getTitle(){
        return title;
    }

    public String getUrl(){
        return url;
    }

    public String getImageUrl(){
        return imageUrl;
    }
}
