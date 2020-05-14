package com.example.mhmsbmrapp;

import com.example.mhmsbmrapp.Login.GlobalVariables;
import com.example.mhmsbmrapp.model.Composition;
import com.example.mhmsbmrapp.model.ip.IPBmr;
import com.example.mhmsbmrapp.model.ip.Discharge;
import com.example.mhmsbmrapp.utility.ip.DischargeIPUtility;
import com.example.mhmsbmrapp.utility.ip.IPBmrCreateCompositionUtility;
import com.example.mhmsbmrapp.utility.ip.IPUtility;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class IPBmrCreateUtilityTest {

    private String loginToken = "eyJEZXZlbG9wZWQgQnkiOiJlLUhlYWx0aCBSZXNlYXJjaCBDZW50ZXIsIElJSVQgQmFuZ2Fsb3JlIiwiSG9zdCI6Ikthcm5hdGFrYSBNZW50YWwgSGVhbHRoIE1hbmFnZW1lbnQgU3lzdGVtIiwidHlwIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJwcm9mZXNzaW9uIjoiTUhNU1BzeWNoaWF0cmlzdCIsInN1YiI6Ik1ITVMgU2VjdXJpdHkgVG9rZW4iLCJsYXN0TG9naW5PcmdJZCI6ImEyMWI4ODVlLTJmM2EtNDQyNS04YjViLTBkMjc0YjQyYWYyNiIsInNlc3Npb25FbmRUaW1lIjoxNTg5NDcxNjc0LCJpc3MiOiJLTUhNUyIsInNlc3Npb25TdGFydFRpbWUiOjE1ODk0Mjg0NzQsInNlc3Npb25JZCI6ImZjNWRlMDYyLTI5YTYtNDEzYy1hOWVhLTY5ZTlmYTkwMTdkMSIsInVzZXJOYW1lIjoidGVzdDAwMSIsIm9yZ1VVSUQiOiI0NzQ4ZGFmYy03NDY0LTQ1MzUtOWNkMC0yOWNjNTJlZmNjMGYiLCJuYmYiOjE1ODk0Mjg0NzQsIm9yZ1JvbGUiOiJNSFJlZ2lzdHJ5UHJvZmVzc2lvbmFsIiwic2Vzc2lvblRva2VuIjoiU2Vzc2lvbklkOjE3Mi4zMS41LjEzI3Rlc3QwMDE6NDc0OGRhZmMtNzQ2NC00NTM1LTljZDAtMjljYzUyZWZjYzBmOk1ITVM6TUhSZWdpc3RyeVByb2Zlc3Npb25hbCMxNTg5NDI4NDc0NTc5Iy0xNzc5Njc2MTE0Izk3NyIsInBlcnNvbklkIjoiNmM5ODkxYjQtMDQ0ZS00MTY1LWFkOTMtMjg5ZThjODdjYmU1IiwidXNlclVVSUQiOiI5ODA3OGQxMi0zZmZhLTRlNTgtOGQyNy04MDU1OWNlZGIwODIiLCJleHAiOjE1ODk0NjQ0NzQsImlhdCI6MTU4OTQyODQ3NH0.2usoCAVg9a1vb_qPgyqOdHI7WyqHK31cfxvKEe_HCis";
    private String sessionToken = "SessionId:172.31.5.13#test001:4748dafc-7464-4535-9cd0-29cc52efcc0f:MHMS:MHRegistryProfessional#1589428474579#-1779676114#977";
    private String personId = "bda5cf6c-7562-4da1-bf0d-b17a86cdea81";
    IPBmr ip = new IPBmr();

    public void t() {
        ip.setIdentificationMarks("new identification mark oo");
        ip.setSectionOfAdmission("Section 87");
        ip.setComplaints("complaints three new oo");
        ip.setDuration("duration four new oo");
        ip.setHistoryOfIllness("history five new oo");
        ip.setSummaryOfVitals("summary of vitals six new oo");
        ip.setSummaryOfGenPhyExam("summary of general Physical Examination seven new oo");
        ip.setSummaryOfMenStatusExam("Summary Mental status Examination eight new oo");
        ip.setSummaryOfInvestigation("summary of investigation nine new oo");
        ip.setDiagnosisType("Differential Diagnosis new oo");
        ip.setIcdDescription("icd description twelve new oo");
        ip.setIcdCode("icd 13 new oo");
        ip.setCourseInHospital("course in hospital fourteen new oo");
        ip.setMedicineName("medicine fifteen new oo");
        ip.setDosage("dosage sixteen new oo");
        ip.setDosingTime("dosing time seventeen new oo");
        ip.setMedDuration("18");
        ip.setDurationType("Days");
        ip.setRemarks("remarks twenty new oo");
        ip.setPastPrescription("past prescription twenty one new oo");
    }


    @Test
    public void test() {

        JSONObject composition = new JSONObject();
        t();
        try {
            composition.put("/composer|identifier", "98078d12-3ffa-4e58-8d27-80559cedb082");
            composition.put("/composer|name", "test001");
            composition.put("/context/end_time", "2020-05-09T11:27:42.347Z");
            composition.put("/context/health_care_facility|identifier", "4748dafc-7464-4535-9cd0-29cc52efcc0f");
            composition.put("/context/health_care_facility|name", "Establishment One");
            composition.put("/context/location", "Bengaluru");
            composition.put("/context/start_time", "2020-05-09T11:27:42.347Z");
            composition.put("/language", "en");
            composition.put("/territory", "IN");
        } catch(Exception e) {e.printStackTrace();}
        String compositionUuid;
        List<Composition> list = new ArrayList<>();
        IPBmrCreateCompositionUtility utility = new IPBmrCreateCompositionUtility();
        try {
            new IPBmrCreateCompositionUtility().createCompositionWOTP(ip, loginToken, sessionToken, personId);

            compositionUuid = new JSONObject(utility.createCompositionEHRC_Mental_capacityv0(ip, composition, loginToken, sessionToken, personId).toString()).getString("compositionUid");
            list.add(new Composition("mental_capacity_matches_compositionIDs", "EHRC - Mental capacity.v0", compositionUuid));

            compositionUuid = new JSONObject(utility.createCompositionEHRC_Complaintsv0(ip, composition, loginToken, sessionToken, personId).toString()).getString("compositionUid");
            list.add(new Composition("complaints_matches_compositionIDs", "EHRC - Complaints.v0", compositionUuid));

            compositionUuid = new JSONObject(utility.createCompositionEHRC_Vitalsv0(ip, composition, loginToken, sessionToken, personId).toString()).getString("compositionUid");
            list.add(new Composition("vital_matches_compositionIDs", "EHRC - Vitals.v0", compositionUuid));

            compositionUuid = new JSONObject(utility.createCompositionEHRC_Physical_examinationv0(ip, composition, loginToken, sessionToken, personId).toString()).getString("compositionUid");
            list.add(new Composition("physical_examination_matches_compositionIDs", "EHRC - Physical examination.v0 ", compositionUuid));
            System.out.println(compositionUuid +" ---------------------"+ip.getSummaryOfGenPhyExam()+"----------------------- "+ list.toString());
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            compositionUuid = new JSONObject(utility.createCompositionEHRC_Mental_examinationv0(ip, composition, loginToken, sessionToken, personId).toString()).getString("compositionUid");
            list.add(new Composition("mental_examination_matches_compositionIDs", "EHRC - Mental examination.v0", compositionUuid));

            compositionUuid = new JSONObject(utility.createCompositionEHRC_Lab_investigationsv0(ip, composition, loginToken, sessionToken, personId).toString()).getString("compositionUid");
            list.add(new Composition("lab_investigation_matches_compositionIDs", "EHRC - Lab investigations.v0", compositionUuid));

            compositionUuid = new JSONObject(utility.createCompositionEHRC_Attachmentsv0(ip, composition, loginToken, sessionToken, personId).toString()).getString("compositionUid");
            list.add(new Composition("mental_capacity_matches_compositionIDs", "EHRC - Mental capacity.v0", compositionUuid));

            compositionUuid = new JSONObject(utility.createCompositionEHRC_Clinical_historyv0(ip, composition, loginToken, sessionToken, personId).toString()).getString("compositionUid");
            list.add(new Composition("clinical_history_matches_compositionIDs", "EHRC - Clinical history.v0", compositionUuid));

            compositionUuid = new JSONObject(utility.createComposition_EHRC_Diagnosisv0(ip, composition, loginToken, sessionToken, personId).toString()).getString("compositionUid");
            list.add(new Composition("diagnosis_matches_compositionIDs", "EHRC - Diagnosis.v0", compositionUuid));

            compositionUuid = new JSONObject(utility.createCompositionEHRC_Past_prescriptionv0(ip, composition, loginToken, sessionToken, personId).toString()).getString("compositionUid");
            list.add(new Composition("past_prescription_matches_compositionIDs", "EHRC - Past prescription.v0", compositionUuid));

            compositionUuid = new JSONObject(utility.createCompositionEHRC_Medication_orderv0(ip, composition, loginToken, sessionToken, personId).toString()).getString("compositionUid");
            list.add(new Composition("medication_order_matches_compositionIDs", "EHRC - Medication order.v0", compositionUuid));
        } catch(Exception e) {e.printStackTrace();}

        System.out.println(list.toString());

        System.out.println("\n\n\n\n\n\n"+saveAllCompositions(list, loginToken, sessionToken));
    }


    public JSONObject saveAllCompositions(List<Composition> compositionList, String loginToken, String sessionToken) {

        OkHttpClient client = new OkHttpClient();
        final String RELATIVE_PATH = "createIpVirtualFolder/";

        //String time = new Timestamp(System.currentTimeMillis()).toInstant().toString();

        final MediaType JSON
                = MediaType.parse("application/json; charset=utf-8");

        JSONObject payload = new JSONObject();

        try {

            JSONObject jsonObject = new JSONObject();

            payload.put("orgUUID", "4748dafc-7464-4535-9cd0-29cc52efcc0f");
            payload.put("patientId", personId);
            payload.put("token", sessionToken);

            JSONArray uidata = new JSONArray();
            for(int i=0;i< compositionList.size();i++) {
                JSONObject composition = new JSONObject();

                Composition object = compositionList.get(i);
                composition.put("compositionUid", object.getCompositionUid());
                composition.put("name", object.getName());
                composition.put("templateId", object.getTemplateId());
                composition.put("time", "1587358504256");
                if(object.getTemplateId().equals("EHRC - Service request.v0")) {
                    System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                    System.out.println(object.toString());
                    System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                    composition.put("serviceRequest", object.getServiceRequest());
                }
                uidata.put(i, composition);
            }

            payload.put("uidata", uidata);
            payload.put("uuid", "98078d12-3ffa-4e58-8d27-80559cedb082");

        }catch (Exception e) { e.printStackTrace(); }

        RequestBody formBody = RequestBody.create(JSON, payload.toString());

        Request request = new Request.Builder()
                .url(GlobalVariables.GLOBAL_PATH_REST+RELATIVE_PATH)
                .post(formBody)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer "+loginToken)
                .build();

        Response response = null;
        JSONObject returnObject = null;
        try {
            response = client.newCall(request).execute();
            if(response.code() != 200)
                return null;
            ResponseBody rb = response.body();
            returnObject = new JSONObject(rb.string());

        }catch(Exception e){
            e.printStackTrace();
        }
        return returnObject;

    }


    @Test
    public void diagnosis() {
        JSONObject composition = new JSONObject();
        try {
            composition.put("/composer|identifier", "98078d12-3ffa-4e58-8d27-80559cedb082");
            composition.put("/composer|name", "test001");
            composition.put("/context/end_time", "2020-05-09T11:27:42.347Z");
            composition.put("/context/health_care_facility|identifier", "4748dafc-7464-4535-9cd0-29cc52efcc0f");
            composition.put("/context/health_care_facility|name", "Establishment One");
            composition.put("/context/location", "Bengaluru");
            composition.put("/context/start_time", "2020-05-09T11:27:42.347Z");
            composition.put("/language", "en");
            composition.put("/territory", "IN");
        } catch(Exception e) {e.printStackTrace();}
        t();
        List<Composition> list = new ArrayList<>();
        list.add(new DischargeIPUtility().createCompositionEHRC_Discharge_notesv0(null, composition, loginToken, sessionToken, personId));
        list.add(new DischargeIPUtility().createCompositionEHRC_EHRC_Medication_orderv0(null, composition, loginToken, sessionToken, personId));
        list.add(new DischargeIPUtility().createCompositionEHRC_EHRC_Service_requestv0(null, composition, loginToken, sessionToken, personId));

        System.out.println(new DischargeIPUtility().saveAllCompositions(list, loginToken, sessionToken, "4748dafc-7464-4535-9cd0-29cc52efcc0f", personId, "98078d12-3ffa-4e58-8d27-80559cedb082"));

    }


    @Test
    public void admit() {
        String userUUID = "98078d12-3ffa-4e58-8d27-80559cedb082";
        String patientId = "bda5cf6c-7562-4da1-bf0d-b17a86cdea81";
        String[] values = {"ABCD", "WXYZ"};
        JSONObject mhp = new IPUtility().getUserInfo(loginToken, userUUID);
        System.out.println(mhp.toString());
        System.out.println(new IPUtility().admit(values, mhp, loginToken, patientId, userUUID));

    }


    @Test
    public void discharge() {
        JSONObject composition = new JSONObject();

        try {
            composition.put("/composer|identifier", "98078d12-3ffa-4e58-8d27-80559cedb082");
            composition.put("/composer|name", "test001");
            composition.put("/context/end_time", "2020-05-09T11:27:42.347Z");
            composition.put("/context/health_care_facility|identifier", "4748dafc-7464-4535-9cd0-29cc52efcc0f");
            composition.put("/context/health_care_facility|name", "Establishment One");
            composition.put("/context/location", "Bengaluru");
            composition.put("/context/start_time", "2020-05-09T11:27:42.347Z");
            composition.put("/language", "en");
            composition.put("/territory", "IN");
        } catch(Exception e) {e.printStackTrace();}

        Discharge discharge = new Discharge();
        discharge.setTypeOfDischarge("Discharge At Request");
        discharge.setConditionAtDischarge("Same");
        discharge.setConditionDescription("condition description three");
        discharge.setFollowUpRecommendation("follow up recommendation");
        discharge.setNameOfDoctor("Doctor One");
        discharge.setDesignation("designation one two three");
        new DischargeIPUtility().createCompositionEHRC_Discharge_notesv0(discharge, composition, loginToken, sessionToken, personId);
    }
}
