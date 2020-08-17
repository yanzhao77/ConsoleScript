package com.example.demo;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class dd {
    @Test
    public void cteateTempFile() {
        String fileName = "aa.py";
        File temp = null;
        String name = "a111a";
        String suffix = ".py";

        try {
            temp = File.createTempFile(name, suffix);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("文件路径: " + temp.getAbsolutePath());
        String path = temp.getParentFile().getPath();
    }
}
