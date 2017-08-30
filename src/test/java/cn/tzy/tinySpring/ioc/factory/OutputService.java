package cn.tzy.tinySpring.ioc.factory;

import org.junit.Assert;

/**
 * @author yihua.huang@dianping.com
 */
public class OutputService {

    private HelloWorldService helloWorldService;

    public void output(){
        helloWorldService.helloWorld();
    }

    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
}
