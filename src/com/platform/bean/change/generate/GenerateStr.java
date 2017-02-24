package com.platform.bean.change.generate;

import com.platform.bean.change.entity.CharUtil;
import com.platform.bean.change.entity.PrimType;
import com.platform.bean.change.read.WordReader;
import com.platform.bean.change.util.TextUtil;
import com.platform.bean.change.write.BufferWrite;
import com.platform.bean.change.write.Controller;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/2/24.
 */
public class GenerateStr {
    private GenerateConfig config;
    public GenerateStr(GenerateConfig config){
        this.config=config;
    }
    public void execute(File file){
        WordReader wordReader=null;
        try {
            wordReader=new WordReader(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (wordReader!=null){
            try {
                String word=null;
//                int writeCur=-1;
                boolean isWriteTable=false, isWriteColumn=false, isReadPublic=false, isReadPrivate=false;
                BufferWrite writeBuffer=new BufferWrite();
                BufferWrite all=new BufferWrite();

                do {
                    int cur = wordReader.getCur();
                    word = wordReader.readWord(cur);
                    if (word==null) {
                        writeBuffer.clear();
                        break;
                    }
//                    System.out.println("word="+word+", isWriteTable="+isWriteTable);
                    if (isWriteTable){
                        all.write(GenerateDB.generateDBTable(TextUtil.trim(word), ""));
                        all.write(writeBuffer.toString());
                        writeBuffer.clear();
                        isWriteTable=false;
                    }else if (isWriteColumn){
                        all.write(GenerateDB.generateDBColumn(TextUtil.trim(word)));
                        all.write(writeBuffer.toString());
                        writeBuffer.clear();
                        isWriteColumn=false;
                    }
                    if (CharUtil.PUBLIC_CHAR.equals(TextUtil.trim(word))) {
                        //读到public，停止写all，写入缓存
//                        writeCur=cur;
                        writeBuffer.write(word);
                        isReadPublic = true;
                    }else if (isReadPublic){
                        if (CharUtil.CLASS_CHAR.equals(TextUtil.trim(word))) {
                            //读到public class，下一次可以写all的table了
                            writeBuffer.write(word);
                            isWriteTable = true;
                        }else {
                            if (PrimType.TYPE_BOOLEAN.equals(TextUtil.trim(word))||TextUtil.firstLetterUpper(PrimType.TYPE_BOOLEAN).equals(TextUtil.trim(word))){
                                writeBuffer.write(TextUtil.firstLetterLower(word));
                            }else {
                                writeBuffer.write(word);
                            }
                            //读到public 方法本次直接处理
                            all.write(writeBuffer.toString());
                            writeBuffer.clear();
                        }
                        isReadPublic=false;
                    }else if (CharUtil.PRIVATE_CHAR.equals(TextUtil.trim(word))) {
                        //读到private，停止写all，写入缓存，这一行是私有属性
//                        writeCur = cur;
                        writeBuffer.write(word);
                        isReadPrivate=true;
                    }else if (PrimType.TYPE_STRING.equals(TextUtil.trim(word))) {
                        //读到String，先写入缓存
                        writeBuffer.write(word);
                        if (isReadPrivate){
                            //之前读到private，必然是属性，下一次写all的column
                            isWriteColumn = true;
                            isReadPrivate=false;
                        }else {
                            //之前读到的是public，不是private，读到的是方法，缓存写入总数据，并清空缓存
                            all.write(writeBuffer.toString());
                            writeBuffer.clear();
                        }
                    }else if (PrimType.TYPE_BOOLEAN.equals(TextUtil.trim(word))||TextUtil.firstLetterUpper(PrimType.TYPE_BOOLEAN).equals(TextUtil.trim(word))) {
                        Controller.outln("读到boolean=" + word);
                        //读到Boolean，先写入缓存
                        writeBuffer.write(TextUtil.firstLetterLower(word));
                        if (isReadPrivate) {
                            //缓存中有数据，而且读到String，写入缓存，下一次写all的column
                            isWriteColumn = true;
                            isReadPrivate = false;
                        }else {
                            //之前读到的是public，不是private，读到的是方法，缓存写入总数据，并清空缓存
                            all.write(writeBuffer.toString());
                            writeBuffer.clear();
                        }
                    }else if (CharUtil.STATIC_CHAR.equals(TextUtil.trim(word))){
                        writeBuffer.write(TextUtil.firstLetterLower(word));
                        if (isReadPrivate) {
                            //缓存中有数据，而且读到String，写入缓存，下一次写all的column
                            isReadPrivate = false;
                            //之前读到的是public，不是private，读到的是方法，缓存写入总数据，并清空缓存
                            all.write(writeBuffer.toString());
                            writeBuffer.clear();
                        }
                    }else {
                        all.write(word);
                    }


                }while (word!=null);
                all.write(writeBuffer.toString());
                System.out.println("！！！！！！！！！！！！！！！！！！！！！结束！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
                all.print();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
