package sample;

import controller.ViewControl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample.fxml"));
//        Scene scene = new Scene(root, 800, 450);
//        scene.getStylesheets().add(getClass().getResource("/css/Style.css").toExternalForm());
//        primaryStage.setTitle("cmdTest");
//        primaryStage.setScene(scene);
//        primaryStage.show();
        ViewControl viewControl = new ViewControl();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
