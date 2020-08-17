package controller;

import CliUtilTool.CliUtilTools;
import CliUtilTool.ViewTools;
import console.ConsoleTextAera;
import consoleInterFace.Imethod;
import coreFactroy.CoreFactroy;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.fxmisc.flowless.VirtualizedScrollPane;
import service.ModelMethodImp;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewController implements Initializable {
    public MenuItem newMenuItem;
    public MenuItem openMenuItem;


    @FXML
    AnchorPane textAreaAnchorPane;


    ConsoleTextAera textAera;
    Stage stage;
    CoreFactroy coreFactroy;
    ModelMethodImp methodImp;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addConsoleTera();

        actionInit();
    }

    /**
     * 点击事件
     */
    private void actionInit() {
        newMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                methodImp.newView();
                println("已新建");
            }
        });
        openMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String path = ViewTools.openFile(stage);
                if (path != null) {
                    methodImp.openFile(path);
                }
            }
        });
    }

    public void addConsoleTera() {
        textAera = new ConsoleTextAera();
        VirtualizedScrollPane virtualizedScrollPane = new VirtualizedScrollPane(textAera);
        textAreaAnchorPane.getChildren().add(virtualizedScrollPane);
        textAreaAnchorPane.setTopAnchor(virtualizedScrollPane, 0.0);
        textAreaAnchorPane.setBottomAnchor(virtualizedScrollPane, 0.0);
        textAreaAnchorPane.setLeftAnchor(virtualizedScrollPane, 0.0);
        textAreaAnchorPane.setRightAnchor(virtualizedScrollPane, 0.0);
    }

    public void consoleInit() {
        textAera.init(coreFactroy);
        methodImp = (ModelMethodImp) new ModelMethodImp(coreFactroy).getProxy();
        Object[] objects = CliUtilTools.addShellServer(coreFactroy);
        CliUtilTools.ShellInterInit(textAera.getShellInter(), objects);
    }


    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public CoreFactroy getCoreFactroy() {
        return coreFactroy;
    }

    public void setCoreFactroy(CoreFactroy coreFactroy) {
        this.coreFactroy = coreFactroy;
    }

    public ConsoleTextAera getTextAera() {
        return textAera;
    }

    public void setTextAera(ConsoleTextAera textAera) {
        this.textAera = textAera;
    }

    public Imethod getImethod() {
        return methodImp;
    }

    public void setImethod(Imethod imethod) {
        this.methodImp = (ModelMethodImp) imethod;
    }

    public void println(String text) {
        textAera.println(text);
    }
}
