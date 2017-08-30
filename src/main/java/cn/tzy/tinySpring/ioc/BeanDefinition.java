package cn.tzy.tinySpring.ioc;

import cn.tzy.tinySpring.ioc.PropertyValue;
import cn.tzy.tinySpring.ioc.PropertyValues;

/**
 * Created by tuzhenyu on 17-8-30.
 * @author tuzhenyu
 */
public class BeanDefinition {
    private Object bean;
    private String beanClassName;
    private Class beanClass;
    private PropertyValues propertyValues = new PropertyValues();


    public Object getBean(){
        return this.bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanName) {
        this.beanClassName = beanName;
        try {
            this.beanClass = Class.forName(beanClassName);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
