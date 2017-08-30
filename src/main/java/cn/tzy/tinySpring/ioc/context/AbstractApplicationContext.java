package cn.tzy.tinySpring.ioc.context;


import cn.tzy.tinySpring.ioc.factory.AbstractBeanFactory;
import cn.tzy.tinySpring.ioc.factory.AutowireCapableBeanFactory;


public abstract class AbstractApplicationContext implements ApplicationContext {
    protected AutowireCapableBeanFactory beanFactory;

    public AbstractApplicationContext(AutowireCapableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void refresh() throws Exception{
    }

}
