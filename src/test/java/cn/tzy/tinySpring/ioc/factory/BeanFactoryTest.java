package cn.tzy.tinySpring.ioc.factory;

import cn.tzy.tinySpring.BeanDefinition;
import cn.tzy.tinySpring.ioc.PropertyValue;
import cn.tzy.tinySpring.ioc.PropertyValues;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tuzhenyu on 17-8-30.
 * @author tuzhenyu
 */
public class BeanFactoryTest {
    @Test
    public void test(){
        BeanFactory factory = new AutowireCapableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("cn.tzy.tinySpring.ioc.factory.HelloWorldService");

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("text","hello,world"));
        beanDefinition.setPropertyValues(propertyValues);

        factory.registerBeanDefinition("HelloWorldService",beanDefinition);


        HelloWorldService helloWorldService = (HelloWorldService) factory.getBean("HelloWorldService");
        helloWorldService.helloWorld();
    }



}