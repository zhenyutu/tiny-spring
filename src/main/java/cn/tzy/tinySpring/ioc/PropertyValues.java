package cn.tzy.tinySpring.ioc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuzhenyu on 17-8-30.
 * @author tuzhenyu
 */
public class PropertyValues {
    private final List<PropertyValue> list = new ArrayList<PropertyValue>();

    public void addPropertyValue(PropertyValue propertyValue){
        list.add(propertyValue);
    }

    public List<PropertyValue> getPropertyValues(){
        return list;
    }
}
