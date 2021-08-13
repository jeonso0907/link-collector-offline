package Controller.SceneController;

import Controller.DialogController.EditDialogController;
import Data.LinkData;
import Model.Model;
import Object.Link;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import static Controller.SceneController.ScreenController.switchScreen;

public class ListEditController {

    @FXML
    private ListView linkList;
    @FXML
    private Button addBtn;
    @FXML
    private Button editBtn;
    @FXML
    private Button deleteBtn;
    @FXML
    private Button doneBtn;

    private ObservableList<String> obsLinkList;

    public void initialize() {
        LinkData linkData = Model.getDb();
        obsLinkList = FXCollections.observableArrayList();

        for (Link link : linkData.getLinkList()) {
            obsLinkList.add(link.getTitle());
        }

        linkList.setItems(obsLinkList);

        addBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                EditDialogController.showEditDialog("Add");
            }
        });

        editBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                EditDialogController.showEditDialog("Edit");
            }
        });

        deleteBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });

        doneBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                switchScreen("View/LinkList.fxml");
            }
        });
    }

}
