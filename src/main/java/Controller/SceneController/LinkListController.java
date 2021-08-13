package Controller.SceneController;

import Model.Model;
import Object.Link;
import Data.LinkData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import static Controller.SceneController.ScreenController.switchScreen;

public class LinkListController {

    @FXML
    private ListView linkList;
    @FXML
    private Button launchBtn;
    @FXML
    private Button editBtn;


    public void initialize() {

        LinkData linkData = Model.getDb();
        ObservableList<String> obsLinkList = FXCollections.observableArrayList();

        for (Link link : linkData.getLinkList()) {
            obsLinkList.add(link.getTitle());
        }

        linkList.setItems(obsLinkList);

        launchBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });

        editBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                switchScreen("View/ListEdit.fxml");
            }
        });
    }





}
