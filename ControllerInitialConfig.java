import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControllerInitialConfig<name> extends ControllerWelcomeScreen {

    @FXML
    public ComboBox seasonBox, seedTypeBox;

    //instance variables
    private String name;
    public static int difficulty;
    public static String season;
    public static String seedType;
    public static int money;
    public static String date;

    @FXML
    private TextField nameField;

    @FXML
    private Button nextButton, easy, medium, hard;

    private Stage stage;
    private Parent root;

    @FXML
    protected void handleNextButtonAction(ActionEvent event) throws IOException {
        Window owner = nextButton.getScene().getWindow();

        name = nameField.getText();
        season = String.valueOf(seasonBox.getValue());
        seedType = String.valueOf(seedTypeBox.getValue());

        if (nameField.getText().isEmpty() || nameField.getText().isBlank() || difficulty == 0 || season == "null" || seedType == "null") {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Invalid Name Entry",
                "Please enter an alphanumeric name \nand remember to select a season, seedType, and difficulty!");
            return;
        }
        AlertHelper.showAlert(Alert.AlertType.INFORMATION, owner, "Registration Successful!",
            "Welcome " + nameField.getText() + "!");
        loadSecondFxml();
        stage.show();

    }

    //Difficulty buttons
    @FXML
    protected void easyButtonAction(ActionEvent event) throws IOException { difficulty = 3; }
    @FXML
    protected void medButtonAction(ActionEvent event) throws IOException { difficulty = 2; }
    @FXML
    protected void hardButtonAction(ActionEvent event) throws IOException { difficulty = 1; }


    public void loadSecondFxml() throws IOException {
        stage = (Stage) nextButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("InitialUI.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    public int getDifficulty() {
        return difficulty;
    }

    public String getSeason() {
        return season;
    }

    @FXML
    public void initialize() {
        List<String> seasonList = new ArrayList<String>();
        seasonList.add("Spring");
        seasonList.add("Summer");
        seasonList.add("Fall");
        seasonList.add("Winter");
        ObservableList sList = FXCollections.observableList(seasonList);
        seasonBox.getItems().clear();
        seasonBox.setItems(sList);

        List<String> stList = new ArrayList<String>();
        stList.add("Corn");
        stList.add("Wheat");
        stList.add("Apple");
        stList.add("Soy");
        ObservableList seedtypeList = FXCollections.observableList(stList);
        seedTypeBox.getItems().clear();
        seedTypeBox.setItems(seedtypeList);
    }
}
