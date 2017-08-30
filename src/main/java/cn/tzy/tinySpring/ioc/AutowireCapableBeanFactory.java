package cn.tzy.tinySpring.ioc;

import cn.tzy.tinySpring.BeanDefinition;

/**
 * Created by tuzhenyu on 17-8-30.
 * @author tuzhenyu
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    protected Object doCreate(BeanDefinition beanDefinition) {
        Object o = null;
        try {
            o = beanDefinition.getBeanClass().newInstance();
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }

        return o;
    }
}
