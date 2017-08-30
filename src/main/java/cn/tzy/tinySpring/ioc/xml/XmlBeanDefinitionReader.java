package cn.tzy.tinySpring.ioc.xml;

import cn.tzy.tinySpring.ioc.*;
import cn.tzy.tinySpring.ioc.factory.AbstractBeanFactory;
import cn.tzy.tinySpring.ioc.factory.AutowireCapableBeanFactory;
import cn.tzy.tinySpring.ioc.io.Resource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * Created by tuzhenyu on 17-8-30.
 * @author tuzhenyu
 */
public class XmlBeanDefinitionReader implements BeanDefinitionReader{
    private AbstractBeanFactory beanFactory;

    public XmlBeanDefinitionReader(AutowireCapableBeanFactory beanFactory){
        this.beanFactory = beanFactory;
    }

    public void loadBeanDefinitions(Resource resource) throws Exception {
        InputStream inputStream = resource.getInputStream();
        doLoadBeanDefinitions(inputStream);
    }

    private void doLoadBeanDefinitions(InputStream inputStream) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        Document doc = docBuilder.parse(inputStream);
        // 解析bean
        registerBeanDefinitions(doc);
        inputStream.close();
    }


    private void registerBeanDefinitions(Document doc) {
        Element root = doc.getDocumentElement();

        parseBeanDefinitions(root);
    }

    protected void parseBeanDefinitions(Element root) {
        NodeList nl = root.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            Node node = nl.item(i);
            if (node instanceof Element) {
                Element ele = (Element) node;
                processBeanDefinition(ele);
            }
        }
    }

    protected void processBeanDefinition(Element ele) {
        String name = ele.getAttribute("name");
        String className = ele.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        processProperty(ele,beanDefinition);
        beanDefinition.setBeanClassName(className);
        beanFactory.beanDefinitionMap.put(name, beanDefinition);
    }

    private void processProperty(Element ele,BeanDefinition beanDefinition) {
        NodeList propertyNode = ele.getElementsByTagName("property");
        for (int i = 0; i < propertyNode.getLength(); i++) {
            Node node = propertyNode.item(i);
            if (node instanceof Element) {
                Element propertyEle = (Element) node;
                String name = propertyEle.getAttribute("name");
                String value = propertyEle.getAttribute("value");
                if(value!=null&&value.length()>0)
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name,value));
                else {
                    String ref = propertyEle.getAttribute("ref");
                    if (ref!=null&&ref.length()>0){
                        beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name,new BeanReference(ref)));
                    }
                }
            }
        }
    }

}
