package cn.tzy.tinySpring.ioc;

import java.security.Permission;

/**
 * Created by tuzhenyu on 17-8-30.
 * @author tuzhenyu
 */
public class PropertyValue {
    private String name;

    private Object value;

    public PropertyValue(String name,Object value){
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
