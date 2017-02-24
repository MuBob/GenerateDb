package com.platform.bean.change.read;

import com.platform.bean.change.entity.CharUtil;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Created by Administrator on 2017/2/24.
 */
public class WordReader{
    private FileReader mFileReader;

    public WordReader(File file) throws Exception{
        mFileReader=new FileReader(file);
    }
    private int mCur;


    public String readWord(int start) throws IOException{
        return read(start, CharUtil.SPACE_CHAR);
    }

    public String readLine(int start) throws IOException{
        return read(start, CharUtil.ENTER_CHAR);
    }

    public String read(int start, char stopChar) throws IOException {
        StringBuffer result=new StringBuffer();
        int length=1;
        char[] cbuf=new char[length];
        int readLength=start;
        do{
//            System.out.println("readStrat="+readLength+", readLength="+length);
            readLength=mFileReader.read(cbuf,0,length);
//            System.out.println("---------read="+cbuf[0]);
            if (readLength!=-1)
                result.append(cbuf);
            else
                return null;
        }while (readLength!=-1&&cbuf[length-1]!= stopChar&&cbuf[length-1]!= CharUtil.ENTER_CHAR);
        mCur=readLength;
        return result.toString();
    }

    public int getCur(){
        return mCur;
    }

    public void close() throws IOException {
        if (mFileReader!=null)
            mFileReader.close();
    }

}
