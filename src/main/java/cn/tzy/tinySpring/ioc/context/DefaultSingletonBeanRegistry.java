package cn.tzy.tinySpring.ioc.context;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by tuzhenyu on 17-8-30.
 * @author tuzhenyu
 */
public class DefaultSingletonBeanRegistry {
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap(64);

    public void put(String beanName,Object bean){
        singletonObjects.put(beanName,bean);
    }

    public Object getBean(String beanName){
        return singletonObjects.get(beanName);
    }
}
