package org.example.surveysystem2;

public class Response {
    private int id;
    private int questionId;
    private String responseText;

    public Response(int id, int questionId, String responseText) {
        this.id = id;
        this.questionId = questionId;
        this.responseText = responseText;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }
}
