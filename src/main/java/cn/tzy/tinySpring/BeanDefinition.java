package cn.tzy.tinySpring;

/**
 * Created by tuzhenyu on 17-8-30.
 * @author tuzhenyu
 */
public class BeanDefinition {
    private Object bean;
    private String beanName;
    private Class beanClass;

    public BeanDefinition(Object bean){
        this.bean = bean;
    }

    public Object getBean(){
        return this.bean;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
