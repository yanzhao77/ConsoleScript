package scriptPrint;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ScriptPrinter implements State {
    //静态常量
    public static final int STOP_RECORD = 0;
    public static final int START_RECORD = 1;

    private int state;
    private int objNum;//对象计数器
    Map<String, ScriptModel> modelMap;//key为脚本名称，

    public ScriptPrinter() {
        this.state = STOP_RECORD;
        modelMap = new HashMap<>();
    }

    public ScriptPrinter(ScriptModel scriptModel) {
        this.state = state;
        modelMap = new HashMap<>();
        modelMap.put(scriptModel.getName(), scriptModel);
    }

    @Override
    public void setScriptPrinterState(int state, String scriptName) throws IOException {
        if (this.state == 0 && state == 1) {
            openScriptFile(scriptName);
            this.state = state;
        } else if (this.state == 1 && state == 0) {
            closeScriptFile(scriptName);
            this.state = state;
        }
    }

    void openScriptFile(String scriptName) {
        ScriptModel scriptModel = modelMap.get(scriptName);
        File path = new File(scriptName);
        if (!path.getParentFile().exists()) {
            path.getParentFile().mkdirs();
        }
    }

    void closeScriptFile(String scriptName) {
    }


}
