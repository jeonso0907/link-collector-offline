package Controller.SceneController;

import Model.Model;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ScreenController {

    public static void switchScreen(String nextScene) {
        Parent root= null;
        try {
            root = FXMLLoader.load(ScreenController.class.getClassLoader().getResource(nextScene));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        Model m = new Model();
        Stage st = m.getStage();
        st.setScene(scene);
    }

}
