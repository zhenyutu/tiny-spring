package cn.tzy.tinySpring.ioc.aop;

/**
 * Created by tuzhenyu on 17-9-1.
 * @author tuzhenyu
 */
public class TargetSource {
    private Class targetClass;
    private Object target;

    public TargetSource(Class targetClass,Object target){
        this.targetClass = targetClass;
        this.target = target;
    }

    public Class getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class targetClass) {
        this.targetClass = targetClass;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
