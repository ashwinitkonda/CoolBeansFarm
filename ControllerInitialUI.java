import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerInitialUI extends ControllerInitialConfig {

    @FXML
    private Label seasonInput;

    @FXML
    private Label dayVal;

    @FXML
    private Label gold;

    @FXML
    private Button goBack;

    private Stage stage;
    private Parent root;

    @FXML
    protected void handleBackButtonAction(ActionEvent event) throws IOException {
        stage=(Stage) goBack.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("InitialConfig.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    ControllerInitialConfig exp = new ControllerInitialConfig();
    @FXML
    public void initialize() {
        seasonInput.setText(exp.getSeason());
        setGold();
        dayVal.setText("Day 1");
    }

    private void setGold() {
        System.out.println(difficulty);
        gold.setText(Integer.toString(exp.getDifficulty() * 100));
    }


}
