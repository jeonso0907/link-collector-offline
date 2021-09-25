package Controller.SceneController;

import Model.Model;
import Object.Link;
import Data.LinkData;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import static Controller.SceneController.ScreenController.switchScreen;

public class LinkListController {

    @FXML
    private ListView linkList;
    @FXML
    private Button launchBtn;
    @FXML
    private Button editBtn;

    private ObservableList<Integer> selectedLinkTitleIndex;


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
                getLinkToLaunch();
                Link selectedLink = linkData.getLinkList().get(selectedLinkTitleIndex.get(0));
                int linkIndex = Model.getDb().getLinkList().indexOf(selectedLink);
                Link link = Model.getDb().getLinkList().get(linkIndex);
                //                    openWebpage(link.getLink());
                openUrlInBrowser(link.getLink());
            }
        });

        editBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                switchScreen("View/ListEdit.fxml");
            }
        });
    }

    private void getLinkToLaunch() {
        selectedLinkTitleIndex = linkList.getSelectionModel().getSelectedIndices();
    }

    private void openUrlInBrowser(String url) {
        Runtime runtime = Runtime.getRuntime();
        String[] args = { "osascript", "-e", "open location \"" + url + "\"" };
        try {
            Process process = runtime.exec(args);
        }
        catch (IOException e) {
            // do what you want with this
        }
    }

    public void openWebpage(String urlString) throws IOException {
        URL myURL = new URL(urlString);
        URLConnection myURLConnection = myURL.openConnection();
        myURLConnection.connect();
        System.out.println(myURLConnection);
    }





}
