package org.example.surveysystem2;

public class Question {
    private int id;
    private int surveyId;
    private String questionText;

    public Question(int id, int surveyId, String questionText) {
        this.id = id;
        this.surveyId = surveyId;
        this.questionText = questionText;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
}
