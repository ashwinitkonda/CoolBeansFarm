import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerWelcomeScreen {

    @FXML
    private Button startGame, resumeGame, currentStats;

    private Stage stage;
    private Parent root;

    @FXML
    protected void handleStartGameAction(ActionEvent event) throws IOException {
        stage=(Stage) startGame.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("InitialConfig.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
