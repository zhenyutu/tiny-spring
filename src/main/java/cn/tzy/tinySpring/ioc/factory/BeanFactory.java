package cn.tzy.tinySpring.ioc.factory;

import cn.tzy.tinySpring.ioc.BeanDefinition;

/**
 * Created by tuzhenyu on 17-8-30.
 * @author tuzhenyu
 */
public interface BeanFactory {

    Object getBean(String beanName);

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
