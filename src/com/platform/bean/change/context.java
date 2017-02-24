package com.platform.bean.change;

import com.platform.bean.change.entity.CharUtil;
import com.platform.bean.change.entity.PrimType;
import com.platform.bean.change.file.FileUtil;
import com.platform.bean.change.generate.GenerateConfig;
import com.platform.bean.change.generate.GenerateDB;
import com.platform.bean.change.generate.GenerateStr;
import com.platform.bean.change.read.WordReader;
import com.platform.bean.change.write.BufferWrite;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/2/24.
 */
public class context {
    public static void main(String[] args){
        String projectPath="E:\\svn\\ZonetryPlatform\\app\\src\\main\\java\\com\\zonetry\\platform\\bean";
        String fileName="DatadictRegionListItemBean";
        File file = FileUtil.openFile(projectPath, fileName);
        GenerateStr generateStr=new GenerateStr(new GenerateConfig());
        generateStr.execute(file);
        System.out.println("生成结束");
    }
}
