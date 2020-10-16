package main.jksj.hyhy.number2;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 hello 方法，此文件内容是一个 Hello.class 文件所有字节(x=255-x)处理后的文件。文件群里提供。
 * <p>
 * 1. 读文件
 * 2. 转字节
 * 3. 转成class
 * 4. 调method
 */
public class CustomClassLoader extends ClassLoader {


    public static void main(String[] args) {
        try {
            Class<?> helloClass = new CustomClassLoader().findClass("Hello");
            Object newHelloClass = helloClass.newInstance();
            Method helloMethod = helloClass.getMethod("hello");
            helloMethod.invoke(newHelloClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] afterConvertStr = read("/Users/hyhy/projects/java/JAVA-000/Week_01/homework1015/src/main/jksj/hyhy/number2/Hello.xlass");
        return defineClass(name, afterConvertStr, 0, afterConvertStr.length);
    }

    private static byte[] read(String filePath) {
        File file = new File(filePath);
        InputStream in = null;

        if (file.isFile() && file.exists()) { //判断文件是否存在
            byte[] tempBytes = new byte[1024];
            int cnt = 0;
            try {
                in = new FileInputStream(file);
                while ((cnt = in.read(tempBytes)) != -1) {
                    return convert(tempBytes, cnt);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    private static byte[] convert(byte[] oriBytes, int cnt) {
        byte[] bytes = new byte[cnt];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (255 - oriBytes[i]);
        }
        return bytes;
    }


}
