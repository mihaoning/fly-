package com.example.shspk.fly.util;

import android.text.TextUtils;

import com.example.shspk.fly.db.City;
import com.example.shspk.fly.db.County;
import com.example.shspk.fly.db.Province;
import com.example.shspk.fly.gson.Weather;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by shspk on 2017/5/31.
 */

public class Utility {

    public static boolean handleProvinceResponce(String responce)
    {
        if(!TextUtils.isEmpty(responce))
        {
            try {
                JSONArray allProvinces=new JSONArray(responce);
                for(int i=0;i<allProvinces.length();i++)
                {
                    JSONObject provinceObject=allProvinces.getJSONObject(i);
                    Province province=new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }

        }
        return false;
    }


    public static boolean handleCityResponce(String responce,int provinceId)
    {
        if(!TextUtils.isEmpty(responce))
        {
            try
            {
                JSONArray allCities=new JSONArray(responce);
                for(int i=0;i<allCities.length();i++)
                {
                    JSONObject cityObject=allCities.getJSONObject(i);
                    City city=new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handleCountyResponce(String responce,int cityId)
    {
        if(!TextUtils.isEmpty(responce))
        {
            try
            {
                JSONArray allCounties=new JSONArray(responce);
                for(int i=0;i<allCounties.length();i++)
                {
                    JSONObject countyObject=allCounties.getJSONObject(i);
                    County county=new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static Weather handleWeatherResponse(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent, Weather.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }







}

