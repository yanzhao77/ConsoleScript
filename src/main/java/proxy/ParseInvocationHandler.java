package proxy;

import coreFactroy.CoreFactroy;

import java.lang.reflect.Method;

public class ParseInvocationHandler extends Interceptor {
    Object obj;
    CoreFactroy coreFactory;

    public ParseInvocationHandler(Object obj, Object coreFactory) {
        this.obj = obj;
        this.coreFactory = (CoreFactroy) coreFactory;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        Object res = method.invoke(obj, args);
        //这里是脚本记录的地方
        coreFactory.getScriptPrintpy().print(method, args);
        return res;
    }
}
