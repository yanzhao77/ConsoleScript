package CliUtilTool;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ViewTools {
    static String filePath = null;

    public static String openFile(Stage stage) {
        List<FileChooser.ExtensionFilter> list = new ArrayList<>();
        list.add(new FileChooser.ExtensionFilter("All Files", "*.*"));
        String fielPath = null;
        fielPath = openFileForFile(stage, "", list);
        return fielPath;
    }

    public static String openFileForFile(Stage stage, String title, List<FileChooser.ExtensionFilter> list) {
        FileChooser fileChooser = new FileChooser();
        if (filePath != null) {
            fileChooser.initialDirectoryProperty().set(new File(filePath));//记录上次位置
        }
        fileChooser.setTitle(title);
        fileChooser.getExtensionFilters().addAll(list);
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            filePath = file.getPath().substring(0, file.getPath().lastIndexOf("\\"));
            return file.getPath();
        }
        return null;
    }
}
