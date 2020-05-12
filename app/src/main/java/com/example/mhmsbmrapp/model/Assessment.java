package com.example.mhmsbmrapp.model;

public class Assessment {

    private String testedLanguage;
    private String backgroundInformation;
    private String salientBehaviouralObservation;
    private String impression;
    private String testScale;
    private String testScores;
    private String recommendation;
    private String reliability;
    private String adequacy;
    private String informant;
    private String assessorName;
    private String supervisorName;

    public String getTestedLanguage() {
        return testedLanguage;
    }

    public void setTestedLanguage(String testedLanguage) {
        this.testedLanguage = testedLanguage;
    }

    public String getBackgroundInformation() {
        return backgroundInformation;
    }

    public void setBackgroundInformation(String backgroundInformation) {
        this.backgroundInformation = backgroundInformation;
    }

    public String getSalientBehaviouralObservation() {
        return salientBehaviouralObservation;
    }

    public void setSalientBehaviouralObservation(String salientBehaviouralObservation) {
        this.salientBehaviouralObservation = salientBehaviouralObservation;
    }

    public String getImpression() {
        return impression;
    }

    public void setImpression(String impression) {
        this.impression = impression;
    }

    public String getTestScale() {
        return testScale;
    }

    public void setTestScale(String testScale) {
        this.testScale = testScale;
    }

    public String getTestScores() {
        return testScores;
    }

    public void setTestScores(String testScores) {
        this.testScores = testScores;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getReliability() {
        return reliability;
    }

    public void setReliability(String reliability) {
        this.reliability = reliability;
    }

    public String getAdequacy() {
        return adequacy;
    }

    public void setAdequacy(String adequacy) {
        this.adequacy = adequacy;
    }

    public String getInformant() {
        return informant;
    }

    public void setInformant(String informant) {
        this.informant = informant;
    }

    public String getAssessorName() {
        return assessorName;
    }

    public void setAssessorName(String assessorName) {
        this.assessorName = assessorName;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    @Override
    public String toString() {
        return "Assessment{" +
                "testedLanguage='" + testedLanguage + '\'' +
                ", backgroundInformation='" + backgroundInformation + '\'' +
                ", salientBehaviouralObservation='" + salientBehaviouralObservation + '\'' +
                ", impression='" + impression + '\'' +
                ", testScale='" + testScale + '\'' +
                ", testScores='" + testScores + '\'' +
                ", recommendation='" + recommendation + '\'' +
                ", reliability='" + reliability + '\'' +
                ", adequacy='" + adequacy + '\'' +
                ", informant='" + informant + '\'' +
                ", assessorName='" + assessorName + '\'' +
                ", supervisorName='" + supervisorName + '\'' +
                '}';
    }
}
