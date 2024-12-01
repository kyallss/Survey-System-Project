package org.example.surveysystem2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SurveyDAO {
    private Connection connection;

    public SurveyDAO(Connection connection) {
        this.connection = connection;
    }

    // Add a new survey
    public void addSurvey(Survey survey) {
        try {
            String query = "INSERT INTO Surveys (title) VALUES (?) RETURNING id";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, survey.getTitle());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                survey.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update an existing survey
    public void updateSurvey(Survey survey) {
        try {
            String query = "UPDATE Surveys SET title = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, survey.getTitle());
            stmt.setInt(2, survey.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a survey
    public void deleteSurvey(int surveyId) {
        try {
            String query = "DELETE FROM Surveys WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, surveyId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve all surveys
    public List<Survey> getAllSurveys() {
        List<Survey> surveys = new ArrayList<>();
        try {
            String query = "SELECT * FROM Surveys";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                surveys.add(new Survey(rs.getInt("id"), rs.getString("title")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return surveys;
    }

    // Add a question to a survey
    public void addQuestion(int surveyId, String questionText) {
        try {
            String query = "INSERT INTO Questions (survey_id, question_text) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, surveyId);
            stmt.setString(2, questionText);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update a question
    public void updateQuestion(Question question) {
        try {
            String query = "UPDATE Questions SET question_text = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, question.getQuestionText());
            stmt.setInt(2, question.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a question
    public void deleteQuestion(int questionId) {
        try {
            String query = "DELETE FROM Questions WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, questionId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve questions by survey ID
    public List<Question> getQuestionsBySurveyId(int surveyId) {
        List<Question> questions = new ArrayList<>();
        try {
            String query = "SELECT * FROM Questions WHERE survey_id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, surveyId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                questions.add(new Question(rs.getInt("id"), rs.getInt("survey_id"), rs.getString("question_text")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }
}
