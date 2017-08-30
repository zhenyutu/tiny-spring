package cn.tzy.tinySpring.ioc.factory;

import cn.tzy.tinySpring.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by tuzhenyu on 17-8-30.
 * @author tuzhenyu
 */
public abstract class AbstractBeanFactory implements BeanFactory{
    private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    public Object getBean(String beanName){
        return beanDefinitionMap.get(beanName).getBean();
    }

    public void registerBeanDefinition(String beanName,BeanDefinition beanDefinition){
        Object bean = doCreate(beanDefinition);
        beanDefinition.setBean(bean);
        beanDefinitionMap.put(beanName,beanDefinition);
    }

    protected abstract Object doCreate(BeanDefinition beanDefinition);
}
