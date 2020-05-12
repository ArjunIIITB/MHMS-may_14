package com.example.mhmsbmrapp;

import com.example.mhmsbmrapp.model.Composition;
import com.example.mhmsbmrapp.utility.AssessmentUtility;
import com.example.mhmsbmrapp.utility.RestraintMonitoringUtility;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RestraintMonitoringUtilityTest {


    private String loginToken = " eyJEZXZlbG9wZWQgQnkiOiJlLUhlYWx0aCBSZXNlYXJjaCBDZW50ZXIsIElJSVQgQmFuZ2Fsb3JlIiwiSG9zdCI6Ikthcm5hdGFrYSBNZW50YWwgSGVhbHRoIE1hbmFnZW1lbnQgU3lzdGVtIiwidHlwIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJwcm9mZXNzaW9uIjoiTUhNU1BzeWNoaWF0cmlzdCIsInN1YiI6Ik1ITVMgU2VjdXJpdHkgVG9rZW4iLCJsYXN0TG9naW5PcmdJZCI6ImEyMWI4ODVlLTJmM2EtNDQyNS04YjViLTBkMjc0YjQyYWYyNiIsInNlc3Npb25FbmRUaW1lIjoxNTg5MzM5Mzg1LCJpc3MiOiJLTUhNUyIsInNlc3Npb25TdGFydFRpbWUiOjE1ODkyOTYxODUsInNlc3Npb25JZCI6IjRjOTU1MzJiLTRhMzYtNGE4Mi04ODhjLWI1YTY5MzZkMTg1NSIsInVzZXJOYW1lIjoidGVzdDAwMSIsIm9yZ1VVSUQiOiI0NzQ4ZGFmYy03NDY0LTQ1MzUtOWNkMC0yOWNjNTJlZmNjMGYiLCJuYmYiOjE1ODkyOTYxODUsIm9yZ1JvbGUiOiJNSFJlZ2lzdHJ5UHJvZmVzc2lvbmFsIiwic2Vzc2lvblRva2VuIjoiU2Vzc2lvbklkOjE3Mi4zMS41LjEzI3Rlc3QwMDE6NDc0OGRhZmMtNzQ2NC00NTM1LTljZDAtMjljYzUyZWZjYzBmOk1ITVM6TUhSZWdpc3RyeVByb2Zlc3Npb25hbCMxNTg5Mjk2MTg0NjUwIy05NDM2MjYwNzUjOTI0IiwicGVyc29uSWQiOiI2Yzk4OTFiNC0wNDRlLTQxNjUtYWQ5My0yODllOGM4N2NiZTUiLCJ1c2VyVVVJRCI6Ijk4MDc4ZDEyLTNmZmEtNGU1OC04ZDI3LTgwNTU5Y2VkYjA4MiIsImV4cCI6MTU4OTMzMjE4NSwiaWF0IjoxNTg5Mjk2MTg1fQ.bqVaYhkPnUFblYRREeBXABTgnWlR-L-Aq6M8cPJ6b1c";
    private String sessionToken = "SessionId:172.31.5.13#test001:4748dafc-7464-4535-9cd0-29cc52efcc0f:MHMS:MHRegistryProfessional#1589296184650#-943626075#924";
    private String userUUID = "98078d12-3ffa-4e58-8d27-80559cedb082";
    private String orgUUID = "4748dafc-7464-4535-9cd0-29cc52efcc0f";
    private String patientId = "359f9da6-32ac-47c4-b556-e49cc5fdc016";
    String mheName = "Establishment One";





    private String nominatedRepresentative = "nominatedRepresentativeName ONE";
    //private String nameOfMHP = "psm321op";
    private String inChargePsychiatrist = "inChargePsychiatrist";
    private String settings = "Out Patient";
    private String informedToNR = "true";
    private String psychiatricDiagnosis = "psychiatricDiagnosis";
    private String duration = "13";
    private String durationType = "Months";
    private String startDate = "startDate";
    private String startTime = "startTime";
    private String endDate = "endDate";
    private String endTime = "endTime";
    private String reasons = "reasons";
    private String injuries = "Yes";
    private String limbIschaemia = "Yes";
    private String others = "others";
    private String monitoringDate = "17/04/2020";
    private String pulse = "18";
    private String temperature = "19";
    private String respiratoryRate = "20";
    private String rmInjuries = "rmInjuries";
    private String bloodSupplyToLimb = "bloodSupplyToLimb";
    private String breathingProblem = "breathingProblem";

    String monitoringV3[] = {breathingProblem, rmInjuries, bloodSupplyToLimb, pulse, respiratoryRate, temperature, monitoringDate};
    String valuesV3[] = {injuries, limbIschaemia, others, reasons, duration, durationType, nominatedRepresentative, informedToNR, inChargePsychiatrist, settings};
    String valuesDiag[] = {psychiatricDiagnosis};




    @Test
    public void test() {
        //new RestraintMonitoringUtility().rMonitoringTemplate(loginToken);
    }

    @Test
    public void test1() {
        List<Composition> list = new ArrayList<>();
        list.add(new RestraintMonitoringUtility().createEHRC_Proceduresv3(valuesV3, loginToken, sessionToken, userUUID, orgUUID, mheName, patientId));
        list.add(new RestraintMonitoringUtility().createDiagnosisTemplate(valuesDiag, loginToken, sessionToken,userUUID, orgUUID, mheName, patientId));
        list.add(new RestraintMonitoringUtility().createCompositionEHRC_Restraint_monitoringv3(monitoringV3, loginToken, sessionToken, userUUID, orgUUID, mheName, patientId));
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n" + (new RestraintMonitoringUtility().saveAllAssessmentCompositions(list, loginToken, sessionToken, orgUUID, patientId, userUUID)));
    }

    @Test
    public void individualTest() {
        System.out.println(new RestraintMonitoringUtility().createEHRC_Proceduresv3(valuesV3, loginToken, sessionToken, userUUID, orgUUID, mheName, patientId));
    }

    @Test
    public void test123() throws JSONException {
        String a = "a";
        String b = "b";
        String c = "" ;


        String values[] = {a,b,c};
        for(String s : values)
            System.out.println(s);
        System.out.println(c.isEmpty());

        JSONObject ob = new JSONObject();
        ob.put("empty", c);

        System.out.println(ob.toString());
    }


    @Test
    public void getHistoryTest() {
        new RestraintMonitoringUtility().getHistory(loginToken, sessionToken, patientId, orgUUID);
    }

    @Test
    public void testAssesment() {

        String mhpName = "Doctor One";
        String mheName = "psm321op";

         String education1 = "education1";
         String occupation1 = "occupation1";
         String referredBy = "referredBy";
         String reasonForReferral = "IQ Assessment";
         String referralNote = "referralNote";
         String languageTestedIn = "Kannada";
         String backgroundInformation = "backgroundInformation";
         String informant = "informant";
         String informantRelationship = "informantRelationship";
         String salientBehavioralObservation = "salientBehavioralObservation";
         String impression = "impression";
         String testScale = "testScale";
         String testScore = "testScore";
         String recommendation = "recommendation";
         String reliability = "reliability";
         String adequacy = "adequacy";
         String assessorFullName = "assessorFullName";
         String assessorQualification = "assessorQualification";
         String supervisorFullName1 = "supervisorFullName1";
         String getSupervisorQualification1 = "getSupervisorQualification1";








        String values1[] = {mhpName, salientBehavioralObservation, backgroundInformation, testScale, testScore, impression, recommendation, languageTestedIn, informant, informantRelationship, reliability, adequacy, assessorFullName, assessorQualification, supervisorFullName1, getSupervisorQualification1, mheName};
        String values12[] = {mhpName, reasonForReferral, referralNote, referredBy, mheName};
        System.out.println(values1.length);




        List<Composition> list = new ArrayList<Composition>();

        list.add(new AssessmentUtility().createCompositionEHRC_Psychological_assessmentv0(values1, loginToken, sessionToken, userUUID, orgUUID, patientId));
        list.add(new AssessmentUtility().createCompositionEHRC_Service_requestv0(values12, loginToken, sessionToken, userUUID, orgUUID, patientId));

        for(int i=0;i<list.size();i++) {
            System.out.println(list.get(i).toString());
        }

        JSONObject object = new AssessmentUtility().saveAllAssessmentCompositions(list,loginToken, sessionToken, orgUUID, patientId, userUUID);
        System.out.println("\n\n\n\n\n----------------------------------------------------------------");
        System.out.println(object.toString());
    }


}
