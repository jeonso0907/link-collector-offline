package Model;

import Data.LinkData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Model extends Application {

    private static LinkData linkData;
    private static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        LinkData linkData = new LinkData();
        Model.linkData = linkData;

        Parent root= FXMLLoader.load(getClass().getClassLoader().getResource("View/LinkList.fxml"));
        Scene scene = new Scene(root);
        setStage(stage);

        // Set window resizeable to false
        stage.setResizable(false);
        stage.setScene(scene);

        // Hide the title bar
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    public static LinkData getDb() {
        return Model.linkData;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
