package scriptPrint;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScriptModel {
    String name;
    String path;
    List<String> commandList;
    List<String> methodPackagePathList;

    public ScriptModel(String name, String path) {
        this.name = name;
        this.path = path;
        commandList = new ArrayList<>();
        methodPackagePathList = new ArrayList<>();
    }

    public ScriptModel(String name) {
        this.name = name;


        commandList = new ArrayList<>();
        methodPackagePathList = new ArrayList<>();
    }

    public String cteateTempFile(String fileName) {
        File temp = null;
        String name = null;
        String suffix = null;
        if (fileName.contains(".")) {
            name = fileName.split(".")[0];
            suffix = fileName.split(".")[1];
        }
        try {
            temp = File.createTempFile(name, suffix);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("文件路径: " + temp.getAbsolutePath());
        return temp.getParentFile().getPath();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCommandList() {
        return commandList;
    }

    public void setCommandList(List<String> commandList) {
        this.commandList = commandList;
    }

    public List<String> getMethodPackagePathList() {
        return methodPackagePathList;
    }

    public void setMethodPackagePathList(List<String> methodPackagePathList) {
        this.methodPackagePathList = methodPackagePathList;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
