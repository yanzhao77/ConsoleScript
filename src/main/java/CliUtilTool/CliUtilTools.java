package CliUtilTool;

import consoleInterFace.Imethod;
import consoleInterFace.ShellInter;
import coreFactroy.CoreFactroy;
import org.python.core.PyException;
import shell.JythonShellInter;

import java.io.File;

public class CliUtilTools {


    /**
     * 将数据添加到数组
     *
     * @param factory
     * @return
     */
    public static Object[] addShellServer(Object factory) {
        CoreFactroy coreFactroy = null;
        Imethod imethod = null;

        if (factory instanceof CoreFactroy) {
            coreFactroy = (CoreFactroy) factory;
        }
        imethod = coreFactroy.getController().getImethod();

        return new Object[]{imethod, coreFactroy};
    }

    /**
     * 将数据加载到解析器
     *
     * @param shellInter
     * @param objects
     */
    public static void ShellInterInit(ShellInter shellInter, Object[] objects) {
        if (shellInter != null) {
            shellInter.setData("imethod", objects[0]);
            shellInter.setData("coreFactroy", objects[1]);
        }
        if (shellInter instanceof JythonShellInter) {
            JythonShellInter jythonShellInter = (JythonShellInter) shellInter;
            String path = CliUtilTools.class.getClassLoader().getResource("vieWCommand.py").getFile();
            File file = new File(path);
            try {
                jythonShellInter.execFile(file);
            } catch (PyException e) {
                e.printStackTrace();
            }
        }
    }
}
