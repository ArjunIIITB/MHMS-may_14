package com.example.mhmsbmrapp.utility.ip;

import com.example.mhmsbmrapp.Login.GlobalVariables;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class IPUtility {
    OkHttpClient client = new OkHttpClient();

    public JSONObject getUserInfo(String loginToken, String userUUID) {

        final String RELATIVE_PATH = "userinfo/"+userUUID;

        final MediaType JSON
                = MediaType.parse("application/json; charset=utf-8");

        JSONObject jsonObject = new JSONObject();


        RequestBody formBody = RequestBody.create(JSON, jsonObject.toString());

        Request request = new Request.Builder()
                .url(GlobalVariables.GLOBAL_PATH_REST+RELATIVE_PATH)
                .get()
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer "+loginToken)
                .build();

        Response response = null;
        JSONObject returnObject = null;
        try {
            response = client.newCall(request).execute();
            ResponseBody rb = response.body();
            returnObject = new JSONObject(rb.string());

        }catch(Exception e){
            e.printStackTrace();
        }
        return returnObject;
    } //getUserInfo (GET)

    public JSONObject getDoctorPatients(String loginToken, String orgUUID, String userUUID, String admissionStatus) {

        final String RELATIVE_PATH = "getDoctorPatients/";

        Request request = new Request.Builder()
                .url(GlobalVariables.GLOBAL_PATH_REST+RELATIVE_PATH+orgUUID+"/"+userUUID+"/"+admissionStatus)
                .get()
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer "+loginToken)
                .build();

        Response response = null;
        JSONObject returnObject = null;
        try {
            response = client.newCall(request).execute();
            if(response.code() != 200){
                System.out.println(response.code());
                return null;
            }
            ResponseBody rb = response.body();
            returnObject = new JSONObject(rb.string());

        }catch(Exception e){
            e.printStackTrace();
        }
        return returnObject;
    } //getDoctorPatients (GET)

    public JSONArray getorgpatientReferredToIP(String loginToken, String orgUUID) {

        final String RELATIVE_PATH = "getorgpatientReferredToIP/"+orgUUID;

        Request request = new Request.Builder()
                .url(GlobalVariables.GLOBAL_PATH_REST+RELATIVE_PATH)
                .get()
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer "+loginToken)
                .build();

        Response response = null;
        JSONArray returnObject = null;
        try {
            response = client.newCall(request).execute();
            if(response.code() != 200){
                System.out.println(response.code());
                return null;
            }
            ResponseBody rb = response.body();
            returnObject = new JSONArray(rb.string());

        }catch(Exception e){
            e.printStackTrace();
        }
        return returnObject;
    } //getorgpatientReferredToIP (GET)

}
