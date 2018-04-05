package com.learncamel.file;

import javax.xml.transform.Source;
import java.io.*;

public class CopyFilesWithoutCamel {
    public static void main(String[] args) throws IOException {
        File inputDirectory = new File("data/input");
        File outputDirectory = new File("data/output");

        File[] files = inputDirectory.listFiles();

        for(File source : files) {
            if(source.isFile()) {
                File dest = new File(outputDirectory.getPath()+File.separator+source.getName());

                OutputStream outputStream =  new FileOutputStream(dest);
                byte[] buffer = new byte[(int)source.length()];
                FileInputStream inputStream = new FileInputStream(source);
                inputStream.read(buffer);
                try {

                    outputStream.write(buffer);
                } finally {
                    outputStream.close();
                    inputStream.close();
                }

            }
        }
    }
}
