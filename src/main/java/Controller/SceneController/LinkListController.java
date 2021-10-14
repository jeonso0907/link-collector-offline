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

import java.io.IOException;
import java.net.*;

import static Controller.SceneController.ScreenController.switchScreen;

public class LinkListController {

    @FXML
    private ListView<String> linkList;
    @FXML
    private Button launchBtn;
    @FXML
    private Button editBtn;

    private ObservableList<Integer> selectedLinkTitleIndex;

    /**
     * Initialize Link List Controller
     */
    public void initialize() {

        // Get initialized link data
        LinkData linkData = Model.getDb();
        ObservableList<String> obsLinkList = FXCollections.observableArrayList();

        // Add each link data in the observable list
        for (Link link : linkData.getLinkList()) {
            obsLinkList.add(link.getTitle());
        }

        // Set observable list with list display
        linkList.setItems(obsLinkList);

        // Link List Launch button handler
        launchBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Get and set selected link's index
                getLinkToLaunch();
                Link selectedLink = linkData.getLinkList().get(selectedLinkTitleIndex.get(0));
                int linkIndex = Model.getDb().getLinkList().indexOf(selectedLink);
                Link link = Model.getDb().getLinkList().get(linkIndex);

                // Run URL based on the right OS (Window, Mac)
                try {
                    openWebpage(link.getLink());
                } catch (IOException | URISyntaxException e) {
                    e.printStackTrace();
                }
                openUrlInBrowser(link.getLink());
            }
        });

        // Link List Edit button handler
        editBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                switchScreen("View/ListEdit.fxml");
            }
        });
    }

    /**
     * Get and set selected link's index
     */
    private void getLinkToLaunch() {
        selectedLinkTitleIndex = linkList.getSelectionModel().getSelectedIndices();
    }

    /**
     * URL launcher for Window
     * @param url
     */
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

    /**
     * URL launcher for Mac
     * @param urlString
     * @throws IOException
     * @throws URISyntaxException
     */
    public void openWebpage(String urlString) throws IOException, URISyntaxException {
        Runtime.getRuntime().exec(new String[]{"cmd", "/c","start chrome " + urlString});
    }





}
