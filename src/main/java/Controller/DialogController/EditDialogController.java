package Controller.DialogController;

import Object.Link;
import javafx.scene.control.Dialog;
import javafx.util.Pair;

public class EditDialogController {

    public static Link showEditDialog(String dialogType) {
        Dialog<Pair<String,String>> dialog = new Dialog<>();
        dialog.setTitle("Edit Link");
        dialog.setHeaderText("Edit Link");

        if (dialogType.equals("Add")) {

        } else {

        }

        dialog.showAndWait();
        return null;
    }

}
