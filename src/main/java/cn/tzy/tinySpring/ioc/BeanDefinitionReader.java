package cn.tzy.tinySpring.ioc;

import cn.tzy.tinySpring.ioc.io.Resource;

/**
@author tuzhenyu
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(Resource resource) throws Exception;
}
