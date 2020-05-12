package com.example.mhmsbmrapp;

import com.example.mhmsbmrapp.utility.AssessmentUtility;
import com.example.mhmsbmrapp.utility.TherapyUtility;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    String loginToken = "eyJEZXZlbG9wZWQgQnkiOiJlLUhlYWx0aCBSZXNlYXJjaCBDZW50ZXIsIElJSVQgQmFuZ2Fsb3JlIiwiSG9zdCI6Ikthcm5hdGFrYSBNZW50YWwgSGVhbHRoIE1hbmFnZW1lbnQgU3lzdGVtIiwidHlwIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJwcm9mZXNzaW9uIjoiTUhNU1BzeWNoaWF0cmlzdCIsInN1YiI6Ik1ITVMgU2VjdXJpdHkgVG9rZW4iLCJsYXN0TG9naW5PcmdJZCI6ImEyMWI4ODVlLTJmM2EtNDQyNS04YjViLTBkMjc0YjQyYWYyNiIsInNlc3Npb25FbmRUaW1lIjoxNTg4NjE4NDM3LCJpc3MiOiJLTUhNUyIsInNlc3Npb25TdGFydFRpbWUiOjE1ODg1NzUyMzcsInNlc3Npb25JZCI6IjMzN2EyZDA2LTAyNTEtNDViNC1iYmE4LTM5YjcxOWE5MmU1ZCIsInVzZXJOYW1lIjoicHJhc2hhbnQiLCJvcmdVVUlEIjoiNGNjNzQyODAtZWZlNS00MDE2LWI0MWUtZjI5NDcyYTRlYzEyIiwibmJmIjoxNTg4NTc1MjM3LCJvcmdSb2xlIjoiTUhQcm9mZXNzaW9uYWwiLCJzZXNzaW9uVG9rZW4iOiJTZXNzaW9uSWQ6MTcyLjMxLjUuMTMjcHJhc2hhbnQ6NGNjNzQyODAtZWZlNS00MDE2LWI0MWUtZjI5NDcyYTRlYzEyOk1ITVM6TUhQcm9mZXNzaW9uYWwjMTU4ODU3NTIzNzIzNyMtOTc3ODk0OTE3IzM0NSIsInBlcnNvbklkIjoiOTI1ZDY3Y2QtN2QzYy00MDc4LTg5ZmItNjk2M2M0N2I0OTZhIiwidXNlclVVSUQiOiI3NzViOGMzZS02NzQyLTRiMzAtYjQ0My1jN2Q2YWE2ZWM0YWMiLCJleHAiOjE1ODg2MTEyMzcsImlhdCI6MTU4ODU3NTIzN30.Hyd0ANTF1upHwl1Zzjsxns8BLD5bE5RlzLM2WiuIiQI";
    String sessionToken = "SessionId:172.31.5.13#prashant:4cc74280-efe5-4016-b41e-f29472a4ec12:MHMS:MHProfessional#1588575237237#-977894917#345";
    String patientId = "27335c42-da70-476a-8328-327c3cf10bcd";
    String orgUUID = "4cc74280-efe5-4016-b41e-f29472a4ec12";
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test2() {
        //new TherapyUtility().saveAllData();
    }

}