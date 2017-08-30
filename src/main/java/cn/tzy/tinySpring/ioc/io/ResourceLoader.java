package cn.tzy.tinySpring.ioc.io;

import java.net.URL;

/**
 * Created by tuzhenyu on 17-8-30.
 * @author tuzhenyu
 */
public class ResourceLoader {
    public Resource getResource(String path){
        URL resource = this.getClass().getClassLoader().getResource(path);
        return new UrlResource(resource);
    }
}
