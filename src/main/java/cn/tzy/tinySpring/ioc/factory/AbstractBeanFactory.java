package cn.tzy.tinySpring.ioc.factory;

import cn.tzy.tinySpring.ioc.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by tuzhenyu on 17-8-30.
 * @author tuzhenyu
 */
public abstract class AbstractBeanFactory implements BeanFactory{
    public Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    public Object getBean(String name) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            bean = doCreate(beanDefinition);
        }
        return bean;
    }

    public void registerBeanDefinition(String beanName,BeanDefinition beanDefinition){
        Object bean = doCreate(beanDefinition);
        beanDefinition.setBean(bean);
        beanDefinitionMap.put(beanName,beanDefinition);
    }

    protected abstract Object doCreate(BeanDefinition beanDefinition);
}
