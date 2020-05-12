package com.example.mhmsbmrapp.utility;

import android.util.Log;

import com.example.mhmsbmrapp.Login.GlobalVariables;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class PatientUtility {
    private OkHttpClient client = new OkHttpClient();

    public JSONObject getPatient(String loginToken, String patientId, String sessionToken){

        final String RELATIVE_PATH = "getpatient/";
        final MediaType JSON
                = MediaType.parse("application/json; charset=utf-8");

        JSONObject jsonObjectResult = null;

        JSONObject jsonObject = new JSONObject();
        try{
            jsonObject.put("patientId", patientId);
            jsonObject.put("token", sessionToken);
        }catch (Exception e){
            e.printStackTrace();
        }

        RequestBody formBody = RequestBody.create(JSON, jsonObject.toString());

        Request request = new Request.Builder()
                .url(GlobalVariables.GLOBAL_PATH_REST+RELATIVE_PATH)
                .post(formBody)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer "+loginToken)
                .build();

        Response response = null;

        try {
            response = client.newCall(request).execute();
            ResponseBody rb = response.body();
            if(response.code() != 200)
                return null;
            Log.e("why is it null", "");
            jsonObjectResult = new JSONObject(rb.string());

        }catch(Exception e){
            e.printStackTrace();
        }
        return jsonObjectResult;

    }//getPatient

    public String[] getPatientByMHMSID(String mhmsid) {

        final String RELATIVE_PATH = "mhmsIdSearch/";
        String returnString = null;
        final MediaType JSON
                = MediaType.parse("application/json; charset=utf-8");

        JSONArray jsonArrayResult = null;

        String[] information = new String[6];

        JSONObject jsonObject = new JSONObject();
        JSONObject item = new JSONObject();
        try {
            item.put("idproof.idNumber", mhmsid);
            jsonObject.put("mhmsid", item);
        } catch(Exception e){}
        RequestBody formBody = RequestBody.create(JSON, jsonObject.toString());

        Request request = new Request.Builder()
                .url(GlobalVariables.GLOBAL_PATH_REST+RELATIVE_PATH)
                .post(formBody)
                .addHeader("Content-Type", "application/json")
                .build();

        Response response = null;

        try {
            response = client.newCall(request).execute();
            ResponseBody rb = response.body();
            Log.e("why is it null", "");
            jsonArrayResult = new JSONArray(rb.string());
            JSONObject patient = jsonArrayResult.getJSONObject(0);

            information[0] = patient.getString("givenName");
            information[1] = patient.getString("middleName");
            information[2] = patient.getString("phoneNumber");
            information[3] = patient.getString("dateOfBirth");
            information[4] = patient.getJSONArray("address").getJSONObject(0).getString("city");
            information[5] = patient.getJSONObject("personIdentifiers").getString("identifier");

            for(String string : information){
                System.out.print(string+"     ");
            }

        }catch(Exception e){
            e.printStackTrace();
        }

     return information;

    } //getPatientByMHMSID

    public String[] searchPatientUnderOrg(String loginToken, String session, String orgUuid, String key) {

        final String RELATIVE_PATH = "searchPatientUnderOrg/";

        final MediaType JSON
                = MediaType.parse("application/json; charset=utf-8");

        JSONArray jsonArrayResult = null;

        String[] information = new String[6];

        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("token", session);
            jsonObject.put("orgId", orgUuid);
            jsonObject.put("searchString", key);
        } catch(Exception e){}
        RequestBody formBody = RequestBody.create(JSON, jsonObject.toString());

        Request request = new Request.Builder()
                .url(GlobalVariables.GLOBAL_PATH_REST+RELATIVE_PATH)
                .post(formBody)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer "+loginToken)
                .build();

        Response response = null;

        try {
            response = client.newCall(request).execute();
            ResponseBody rb = response.body();
            Log.e("why is it null", "");
            //System.out.println(rb.string());
            jsonArrayResult = new JSONArray(rb.string());


            JSONObject patient = jsonArrayResult.getJSONObject(0);

            information[0] = patient.getString("givenName");
            information[1] = patient.getString("middleName");
            information[2] = patient.getString("phoneNumber");
            information[3] = patient.getString("dateOfBirth");
            information[4] = patient.getJSONArray("address").getJSONObject(0).getString("city");
            information[5] = patient.getJSONObject("personIdentifiers").getString("identifier");

            for(String string : information){
                System.out.print(string+"     ");
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return information;
    } //searchPatientUnderOrg

    public JSONObject getLastVisitData(String patientId, String orgUUID, String loginToken){


        final String RELATIVE_PATH = "getLastVisitData/";
        //patientId = "c55dd6c4-c571-41b1-a9af-ee634d9ebefe/";
        //orgUUID = "4cc74280-efe5-4016-b41e-f29472a4ec12";
        System.out.println(patientId);
        System.out.println(orgUUID);
        System.out.println(loginToken);

        final MediaType JSON
                = MediaType.parse("application/json; charset=utf-8");

        Request request = new Request.Builder()
                .url(GlobalVariables.GLOBAL_PATH_REST+RELATIVE_PATH+patientId+"/"+orgUUID)
                .get()
                .addHeader("Authorization", "Bearer "+loginToken)
                .addHeader("Content-Type", "application/json")
                .build();

        Response response = null;
        JSONObject lastVisit = null;
        try {
            response = client.newCall(request).execute();
            ResponseBody rb = response.body();
            if(response.code() != 200){
                System.out.println("inside fail "+response.code());
                Log.e("lastVisit link failed", "error code is "+response.code());
                return null;
            }
            lastVisit = new JSONObject(rb.string());
            Log.e("last visit data", lastVisit.toString());

        }catch(Exception e){
            e.printStackTrace();
        }
        return lastVisit;

    }// getLastVisitData

}
