package cn.tzy.tinySpring.ioc.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by tuzhenyu on 17-8-30.
 * @author tuzhenyu
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
