package org.example.surveysystem2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.surveysystem2.Question;
import org.example.surveysystem2.Survey;
import org.example.surveysystem2.SurveyDAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class HelloController {

    @FXML
    private TextField surveyTitleField;

    @FXML
    private TableView<Survey> surveyTable;

    @FXML
    private TableView<Question> questionTable;

    @FXML
    private TableColumn<Survey, Integer> surveyIdColumn;

    @FXML
    private TableColumn<Survey, String> surveyTitleColumn;

    @FXML
    private TableColumn<Question, Integer> questionIdColumn;

    @FXML
    private TableColumn<Question, String> questionTextColumn;

    @FXML
    private TextField selectedSurveyIdField;

    @FXML
    private TextField selectedSurveyTitleField;

    private SurveyDAO surveyDAO;

    private ObservableList<Survey> surveyList;

    private ObservableList<Question> questionList;

    public HelloController() {
        try {
            String url = "jdbc:postgresql://localhost:5432/surveydb";
            String user = "postgres";
            String password = "asykpaeva";
            Connection connection = DriverManager.getConnection(url, user, password);
            surveyDAO = new SurveyDAO(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        surveyIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        surveyTitleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        questionIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        questionTextColumn.setCellValueFactory(new PropertyValueFactory<>("questionText"));

        loadSurveys();
    }

    private void loadSurveys() {
        surveyList = FXCollections.observableArrayList(surveyDAO.getAllSurveys());
        surveyTable.setItems(surveyList);
    }

    private void loadQuestions(int surveyId) {
        questionList = FXCollections.observableArrayList(surveyDAO.getQuestionsBySurveyId(surveyId));
        questionTable.setItems(questionList);
    }

    @FXML
    private void handleCreateSurvey() {
        String title = surveyTitleField.getText();
        if (title.isEmpty()) {
            showAlert("Validation Error", "Survey title cannot be empty!");
            return;
        }
        surveyDAO.addSurvey(new Survey(0, title));
        loadSurveys();
        surveyTitleField.clear();
    }

    @FXML
    private void handleEditSurvey() {
        Survey selectedSurvey = surveyTable.getSelectionModel().getSelectedItem();
        if (selectedSurvey == null) {
            showAlert("No Selection", "Please select a survey to edit.");
            return;
        }
        TextInputDialog dialog = new TextInputDialog(selectedSurvey.getTitle());
        dialog.setHeaderText("Edit Survey Title");
        dialog.showAndWait().ifPresent(newTitle -> {
            selectedSurvey.setTitle(newTitle);
            surveyDAO.updateSurvey(selectedSurvey);
            loadSurveys();
        });
    }

    @FXML
    private void handleDeleteSurvey() {
        Survey selectedSurvey = surveyTable.getSelectionModel().getSelectedItem();
        if (selectedSurvey == null) {
            showAlert("No Selection", "Please select a survey to delete.");
            return;
        }
        surveyDAO.deleteSurvey(selectedSurvey.getId());
        loadSurveys();
        questionTable.getItems().clear();
    }

    @FXML
    private void handleAddQuestion() {
        Survey selectedSurvey = surveyTable.getSelectionModel().getSelectedItem();
        if (selectedSurvey == null) {
            showAlert("No Selection", "Please select a survey first.");
            return;
        }
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Enter Question Text");
        dialog.showAndWait().ifPresent(questionText -> {
            surveyDAO.addQuestion(selectedSurvey.getId(), questionText);
            loadQuestions(selectedSurvey.getId());
        });
    }

    @FXML
    private void handleEditQuestion() {
        Question selectedQuestion = questionTable.getSelectionModel().getSelectedItem();
        if (selectedQuestion == null) {
            showAlert("No Selection", "Please select a question to edit.");
            return;
        }
        TextInputDialog dialog = new TextInputDialog(selectedQuestion.getQuestionText());
        dialog.setHeaderText("Edit Question Text");
        dialog.showAndWait().ifPresent(newText -> {
            selectedQuestion.setQuestionText(newText);
            surveyDAO.updateQuestion(selectedQuestion);
            loadQuestions(selectedQuestion.getSurveyId());
        });
    }

    @FXML
    private void handleDeleteQuestion() {
        Question selectedQuestion = questionTable.getSelectionModel().getSelectedItem();
        if (selectedQuestion == null) {
            showAlert("No Selection", "Please select a question to delete.");
            return;
        }
        surveyDAO.deleteQuestion(selectedQuestion.getId());
        loadQuestions(selectedQuestion.getSurveyId());
    }

    @FXML
    private void handleViewSurvey() {
        Survey selectedSurvey = surveyTable.getSelectionModel().getSelectedItem();

        if (selectedSurvey == null) {
            showAlert("No Selection", "Please select a survey to view.");
            return;
        }

        selectedSurveyIdField.setText(String.valueOf(selectedSurvey.getId()));
        selectedSurveyTitleField.setText(selectedSurvey.getTitle());
        loadQuestions(selectedSurvey.getId());
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
