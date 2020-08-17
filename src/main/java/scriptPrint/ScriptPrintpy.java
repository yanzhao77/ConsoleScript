package scriptPrint;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ScriptPrintpy {


    public void print(Method method, Object... values) {
        System.out.println(method.getName() + "\t" + Arrays.toString(values));
    }
}
