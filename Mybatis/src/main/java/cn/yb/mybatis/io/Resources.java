package cn.yb.mybatis.io;

import java.io.InputStream;

/**
 * 使用类加载器读取配置文件的类
 */
public class Resources {
    /**
     * 根据传入参数，获取一个字节输入流
     *
     * @param fileName
     * @return
     */
    public static InputStream getResourceAsStream(String fileName) {
        return Resources.class.getClassLoader().getResourceAsStream(fileName);
    }
}
