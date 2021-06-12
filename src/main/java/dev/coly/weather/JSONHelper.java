package dev.coly.weather;

import org.json.JSONObject;

/**
 * Created by Gregyyy on 19.04.2018.
 */
public class JSONHelper{

    public static String getString(JSONObject json, String object, String key){
        if(!json.has(object)) return null;
        if(!json.getJSONObject(object).has(key)) return null;
        return json.getJSONObject(object).getString(key);
    }

    public static int getInt(JSONObject json, String object, String key){
        if(!json.has(object)) return -1;
        if(!json.getJSONObject(object).has(key)) return -1;
        return json.getJSONObject(object).getInt(key);
    }

    public static double getDouble(JSONObject json, String object, String key){
        if(!json.has(object)) return -1;
        if(!json.getJSONObject(object).has(key)) return -1;
        return json.getJSONObject(object).getDouble(key);
    }

    public static long getLong(JSONObject json, String object, String key){
        if(!json.has(object)) return -1;
        if(!json.getJSONObject(object).has(key)) return -1;
        return json.getJSONObject(object).getLong(key);
    }

    public static String getString(JSONObject json, String array, int index, String key){
        if(!json.has(array)) return null;
        if(json.getJSONArray(array).length() <= index) return null;
        if(!json.getJSONArray(array).getJSONObject(index).has(key)) return null;
        return json.getJSONArray(array).getJSONObject(index).getString(key);
    }

    public static int getInt(JSONObject json, String array, int index, String key){
        if(!json.has(array)) return -1;
        if(json.getJSONArray(array).length() >= index) return -1;
        if(!json.getJSONArray(array).getJSONObject(index).has(key)) return -1;
        return json.getJSONArray(array).getJSONObject(index).getInt(key);
    }

    public static double getDouble(JSONObject json, String array, int index, String key){
        if(!json.has(array)) return -1;
        if(json.getJSONArray(array).length() <= index) return -1;
        if(!json.getJSONArray(array).getJSONObject(index).has(key)) return -1;
        return json.getJSONArray(array).getJSONObject(index).getDouble(key);
    }

}
