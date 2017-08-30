package cn.tzy.tinySpring;

/**
 * Created by tuzhenyu on 17-8-30.
 * @author tuzhenyu
 */
public class BeanDefinition {
    private Object bean;
    public BeanDefinition(Object bean){
        this.bean = bean;
    }

    public Object getBean(){
        return this.bean;
    }
}
