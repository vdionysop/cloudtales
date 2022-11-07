package gr.vodafone.fmmts;

import java.io.InputStream;

public class ReadFileUtils {


    public static InputStream getFileFromResourceAsStream(String fileName) {
        ClassLoader classLoader = ReadFileUtils.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }
}