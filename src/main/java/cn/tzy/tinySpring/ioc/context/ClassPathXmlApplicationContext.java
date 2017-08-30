package cn.tzy.tinySpring.ioc.context;


import cn.tzy.tinySpring.ioc.BeanDefinition;
import cn.tzy.tinySpring.ioc.factory.AutowireCapableBeanFactory;
import cn.tzy.tinySpring.ioc.io.Resource;
import cn.tzy.tinySpring.ioc.io.ResourceLoader;
import cn.tzy.tinySpring.ioc.xml.XmlBeanDefinitionReader;

import java.util.Map;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

	private String configLocation;
	private DefaultSingletonBeanRegistry registry = new DefaultSingletonBeanRegistry();

	public ClassPathXmlApplicationContext(String configLocation) throws Exception {
		this(configLocation, new AutowireCapableBeanFactory());
	}

	public ClassPathXmlApplicationContext(String configLocation, AutowireCapableBeanFactory beanFactory) throws Exception {
		super(beanFactory);
		this.configLocation = configLocation;
		refresh();
	}

	@Override
	public void refresh() throws Exception {
		Resource resource = new ResourceLoader().getResource(configLocation);
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
		reader.loadBeanDefinitions(resource);
		System.out.println(beanFactory.beanDefinitionMap.size());
		for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : beanFactory.beanDefinitionMap.entrySet()) {
			Object bean = beanFactory.doCreate(beanDefinitionEntry.getValue());
			registry.put(beanDefinitionEntry.getKey(),bean);
		}
	}

	public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {

	}

	public Object getBean(String name) {
		return registry.getBean(name);
	}
}
