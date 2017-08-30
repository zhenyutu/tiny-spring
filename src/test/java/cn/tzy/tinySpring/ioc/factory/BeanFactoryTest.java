package cn.tzy.tinySpring.ioc.factory;

import cn.tzy.tinySpring.ioc.BeanDefinition;
import cn.tzy.tinySpring.ioc.PropertyValue;
import cn.tzy.tinySpring.ioc.PropertyValues;
import cn.tzy.tinySpring.ioc.context.ApplicationContext;
import cn.tzy.tinySpring.ioc.context.ClassPathXmlApplicationContext;
import cn.tzy.tinySpring.ioc.io.Resource;
import cn.tzy.tinySpring.ioc.io.ResourceLoader;
import cn.tzy.tinySpring.ioc.xml.XmlBeanDefinitionReader;
import org.junit.Test;

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


    @Test
    public void test2()throws Exception{
        Resource resource = new ResourceLoader().getResource("tinyioc.xml");
        AutowireCapableBeanFactory factory = new AutowireCapableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);
        System.out.println(factory.beanDefinitionMap.size());
    }

    @Test
    public void test3()throws Exception{
        Resource resource = new ResourceLoader().getResource("tinyioc.xml");
        AutowireCapableBeanFactory factory = new AutowireCapableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);
        System.out.println(factory.beanDefinitionMap.size());

        OutputService outputService = (OutputService) factory.getBean("outputService");
        outputService.output();
    }

    @Test
    public void test4()throws Exception{
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");
        OutputService outputService = (OutputService)applicationContext.getBean("outputService");
        outputService.output();
    }

}