package com.platform.bean.change.file;

import java.io.File;

/**
 * Created by Administrator on 2017/2/24.
 */
public class FileUtil {

    public static File openFile(String path, String name){
        if (name.endsWith(".java"))
        return openFile(path+File.separator+name);
        else
            return openFile(path+File.separator+name+".java");
    }

    public static File openFile(String fileName){
        File file=new File(fileName);
        if (!file.exists()){
            System.out.println("文件不存在, file="+fileName);
            return null;
        }
        return file;
    }

    public static void getSubFiles(String fileName){
        File parent=openFile(fileName);
        parent.list();
    }
}
