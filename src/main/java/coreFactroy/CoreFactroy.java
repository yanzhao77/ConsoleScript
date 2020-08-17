package coreFactroy;

import controller.ViewController;
import scriptPrint.ScriptPrintpy;

/**
 * 视图工厂
 */
public class CoreFactroy implements CoreImp {
    ViewController controller;
    ScriptPrintpy scriptPrintpy;//脚本写出

    public CoreFactroy() {
        scriptPrintpy = new ScriptPrintpy();
    }

    public ViewController getController() {
        return controller;
    }

    public ScriptPrintpy getScriptPrintpy() {
        return scriptPrintpy;
    }

    public void setScriptPrintpy(ScriptPrintpy scriptPrintpy) {
        this.scriptPrintpy = scriptPrintpy;
    }

    public void setController(ViewController controller) {
        this.controller = controller;
    }
}
