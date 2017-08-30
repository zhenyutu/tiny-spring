package cn.tzy.tinySpring.ioc.factory;

import cn.tzy.tinySpring.ioc.BeanDefinition;
import cn.tzy.tinySpring.ioc.BeanReference;
import cn.tzy.tinySpring.ioc.PropertyValue;

import java.lang.reflect.Field;

/**
 * Created by tuzhenyu on 17-8-30.
 * @author tuzhenyu
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    protected Object doCreate(BeanDefinition beanDefinition){
        Object bean = null;
        try{
            bean = createBeanInstance(beanDefinition);
            applyPropertyValues(bean,beanDefinition);
        }catch (Exception e){
            e.printStackTrace();
        }
        return bean;
    }

    private Object createBeanInstance(BeanDefinition beanDefinition)throws Exception{
        return beanDefinition.getBeanClass().newInstance();
    }

    private void applyPropertyValues(Object bean,BeanDefinition beanDefinition)throws Exception{
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()){
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }
            declaredField.set(bean, value);
        }
    }
}
