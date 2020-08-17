package service;

import consoleInterFace.Imethod;
import coreFactroy.CoreFactroy;
import proxy.Interceptor;
import proxy.ProxyFactory;

public class ModelMethodImp implements Imethod {

    CoreFactroy coreFactroy;

    public ModelMethodImp(CoreFactroy coreFactroy) {
        this.coreFactroy = coreFactroy;
    }

    public Imethod getProxy() {
        return getProxy(Interceptor.PARSE_INVOCATIONHANDLER);
    }

    public Imethod getProxy(String... interceptors) {
        Imethod proxy = (Imethod) ProxyFactory.getProxy(this, coreFactroy);
        return proxy;
    }

    @Override
    public boolean runScript(String filePath) {
        return false;
    }

    /**
     * 打开文件
     *
     * @param filePath
     * @return
     */
    public boolean openFile(String filePath) {
        System.out.println("打开文件");
        coreFactroy.getController().println(coreFactroy.getController().getClass().getName());
        return false;
    }

    public void newView() {
    }
}
