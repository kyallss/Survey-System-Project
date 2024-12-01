# Survey-System-Project

Survey System
Overview
The Survey System is a JavaFX-based application that allows users to manage surveys and associated questions. Users can perform operations such as creating, editing, and deleting surveys, as well as managing questions related to each survey. The system uses a PostgreSQL database to store survey and question data. This project is designed to allow easy interaction with surveys and questions via a graphical user interface (GUI).

## Project Requirements List
1. **Survey Creation**: Users should be able to create new surveys by specifying a title and Id
2. **Survey Listing**: A table displays all created surveys with their IDs and titles.
3. **Survey Editing**: Users are able to edit the title of an existing survey.
4. **Survey Deletion**: Users can delete surveys from the system.
5. **Survey Viewing**: Users can view a selected survey.
6. **Question Management**: add, edit, and delete questions within surveys.
7. **CRUD**: CRUD operations included
8. **GUI**: User-friendly GUI
9. **View Survey Results**: Users should be able to view the results of completed surveys.
10. **Data Persistence**: All survey and question data is saved in a persistent database to maintain state across sessions.

Features
Survey Management:
Create, edit, and delete surveys.
View and select surveys from the list.
Question Management:
Add, edit, and delete questions associated with a survey.
View questions related to a selected survey.
Database Interaction:
Connect to a PostgreSQL database to perform CRUD (Create, Read, Update, Delete) operations on surveys and questions.
Technologies Used
Java: Main programming language for the backend logic.
JavaFX: Used to create the graphical user interface.
PostgreSQL: Database used for storing surveys and questions.
JDBC: Java Database Connectivity used to interact with the PostgreSQL database.


Code Structure
HelloController.java: The main controller for handling UI actions and interactions with the database.
Survey.java: A class representing a survey.
Question.java: A class representing a question linked to a survey.
SurveyDAO.java: A Data Access Object (DAO) class that interacts with the PostgreSQL database to perform CRUD operations.
Response.java: A class representing user responses to questions (if needed for future expansions).


## Team Members
- **Kyal Asykpaeva** - Lead Developer
- **Baiel Asanbekov** - Support specialist 
- **Aivar Alymkulov** - Presentatative member and Project Manager

![photo_1](https://github.com/user-attachments/assets/7fe21671-c10b-4121-a86c-e4aa5d288759)
![photo_2](https://github.com/user-attachments/assets/4ff7b7aa-771a-4624-bea1-b657dee69cb1)
![photo_3](https://github.com/user-attachments/assets/6b10a9ea-2362-4532-9622-7749848afa10)
![photo_4](https://github.com/user-attachments/assets/4b3c4056-bc67-4282-abd7-95701ed04903)
![photo_5](https://github.com/user-attachments/assets/c2f1c687-d575-498e-9f5d-b8d829bc30b4)
![photo_6](https://github.com/user-attachments/assets/046e1a24-446e-443f-bad1-83f06f002866)


Here’s the Weekly Meeting Documentation for 2 weeks:

Weekly Meeting Documentation
Week 1: Setup & Initial Development
Date: November 17, 2024
Summary:

Defined project scope: Survey Management System for creating, editing, viewing, and deleting surveys.
Roles assigned:
Kyial: UI design for the survey management page started. 
Baiel: QUestion, Response, Survey created.
Aivar: overall project plan

Week 2: Feature Development & Integration
Date: November 29, 2024
Summary:

Kyial: Forked the project, completed the UI for creating and viewing surveys. Backend setup for CRUD operations. And Controller.
Baiel: Writing documentation, minor changes to the code (Controller, and UI) and fixing errors (e.g. problems with merge, pull requests and javafx).
Aivar: began testing the code, presentation and functionality overall


UML Diagram here: 
![diagram](https://github.com/user-attachments/assets/f24a0e97-0703-49f8-9ec3-d380baa7a562)

Presentation is here:
[Survey_System_Project_Presentation.pptx](https://github.com/user-attachments/files/17969587/Survey_System_Project_Presentation.pptx)


JAR file goes as follows:
<component name="ArtifactManager">
  <artifact type="jar" name="SurveySystem2:jar">
    <output-path>$PROJECT_DIR$/out/artifacts/SurveySystem2_jar</output-path>
    <root id="archive" name="SurveySystem2.jar">
      <element id="module-output" name="SurveySystem2" />
      <element id="extracted-dir" path="$MAVEN_REPOSITORY$/org/openjfx/javafx-graphics/21/javafx-graphics-21.jar" path-in-jar="/" />
      <element id="extracted-dir" path="$MAVEN_REPOSITORY$/org/openjfx/javafx-base/21/javafx-base-21.jar" path-in-jar="/" />
      <element id="extracted-dir" path="$MAVEN_REPOSITORY$/org/openjfx/javafx-base/21/javafx-base-21-win.jar" path-in-jar="/" />
      <element id="extracted-dir" path="$MAVEN_REPOSITORY$/org/openjfx/javafx-controls/21/javafx-controls-21-win.jar" path-in-jar="/" />
      <element id="extracted-dir" path="$MAVEN_REPOSITORY$/org/openjfx/javafx-fxml/21/javafx-fxml-21.jar" path-in-jar="/" />
      <element id="extracted-dir" path="$MAVEN_REPOSITORY$/org/openjfx/javafx-controls/21/javafx-controls-21.jar" path-in-jar="/" />
      <element id="extracted-dir" path="$MAVEN_REPOSITORY$/org/openjfx/javafx-fxml/21/javafx-fxml-21-win.jar" path-in-jar="/" />
      <element id="extracted-dir" path="$MAVEN_REPOSITORY$/org/checkerframework/checker-qual/3.42.0/checker-qual-3.42.0.jar" path-in-jar="/" />
      <element id="extracted-dir" path="$MAVEN_REPOSITORY$/org/openjfx/javafx-graphics/21/javafx-graphics-21-win.jar" path-in-jar="/" />
      <element id="extracted-dir" path="$MAVEN_REPOSITORY$/org/postgresql/postgresql/42.7.4/postgresql-42.7.4.jar" path-in-jar="/" />
    </root>
  </artifact>
</component>
