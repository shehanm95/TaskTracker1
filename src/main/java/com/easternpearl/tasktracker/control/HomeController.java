package com.easternpearl.tasktracker.control;


import com.easternpearl.tasktracker.Db.Database;
import com.easternpearl.tasktracker.medel.ToDo;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private AnchorPane todoCards;

    @FXML
    private VBox cardPane;


    @FXML
    private TextArea mainToDoDescriptionText;

    @FXML
    private Label mainTodoTitleText;

    @FXML
    private Label endDateTxt;

    @FXML
    private Label startDateTxt;

    @FXML
    private JFXComboBox<String> comboCategory;

    @FXML
    private Button addSubTodoButton;

    @FXML
    private VBox subTodoPane;

    @FXML
    private Button deleteButton;

    @FXML
    private Button editButton,markFinishButton;



    private Stage addToDoStage = new Stage();
    private ToDo currentToDo;
    private Database database;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        database = Database.getDataBase();
        this.reloadWindow();
    }

    private void reloadWindow() {
        cardPane.getChildren().clear();
        try {
            ArrayList<ToDo> todos = database.GetToDoAll();

            for (int i = 0; i < todos.size(); i++) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../../view/todo_card.fxml"));
                HBox card = loader.load();

                ToDo currentToDo = todos.get(i);
                // Get the controller associated with the Card.fxml
                CardController cardController = loader.getController();
                cardController.setTitle(currentToDo.getTitle());
                cardController.setDescription(currentToDo.getDescription());
                cardController.setHomeDetails(this, currentToDo);
                cardPane.getChildren().add(card);
            }
            if(!todos.isEmpty()){
                displayDetails(todos.get(0));
                enableFunctionButtons();
            }else {
                loadDefaultFiller();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadDefaultFiller() {
        this.mainToDoDescriptionText.setText("Here will display the ToDo Desctioption you entered when you created the todo Item, \n" +
                "If you need you can edit this by clicking Edit To Do Button,\n" +
                "or you can add new todos by using \"Add new todo\" button;");
        this.mainTodoTitleText.setText("Add new To Do To Check Details...");
        this.startDateTxt.setText("ToDo assigned date will display here,");
        this.endDateTxt.setText("If todo is finished end date will display here.");
        this.disableFunctionButtons();
    }


    private void disableFunctionButtons() {
        addSubTodoButton.setDisable(true);
        deleteButton.setDisable(true);
        editButton.setDisable(true);
        markFinishButton.setDisable(true);
    }
    private void enableFunctionButtons() {
        addSubTodoButton.setDisable(false);
        deleteButton.setDisable(false);
        editButton.setDisable(false);
        markFinishButton.setDisable(false);
    }

    public void addToDoAction(ActionEvent actionEvent) {
        ControlManager.loardScene(addToDoStage,"../../../../view/add_to_do.fxml");
    }

    public void displayDetails(ToDo currentToDo){
        this.currentToDo = currentToDo;
         this.mainToDoDescriptionText.setText(currentToDo.getDescription());
         this.mainTodoTitleText.setText(currentToDo.getTitle());
         this.startDateTxt.setText(currentToDo.getStartDate().toString());
         if(currentToDo.getEndDate() != null){
             this.endDateTxt.setText(currentToDo.getEndDate().toString());
         }else{
             this.endDateTxt.setText("This ToDO Is Still No Process..");
         }

    }


    @FXML
    void deleteMainTodoAction(ActionEvent event) {
            if(currentToDo != null){
                database.deleteTodo(currentToDo);
                currentToDo = null;
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"ToDo Deleted Sucssessfully...",ButtonType.OK);
                reloadWindow();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR,"No Selected Todos to Delete", ButtonType.OK);
                alert.show();

            }
    }

    @FXML
    void displayActiveTodosAction(ActionEvent event) {

    }

    @FXML
    void displayAllTotosAction(ActionEvent event) {

    }

    @FXML
    void displayFinishedTodosAction(ActionEvent event) {

    }

    @FXML
    void editMainTodoAction(ActionEvent event) {

    }

    @FXML
    void markFullToDoAsFinishedAction(ActionEvent event) {

    }
}


