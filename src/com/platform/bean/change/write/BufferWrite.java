package com.platform.bean.change.write;

/**
 * Created by Administrator on 2017/2/24.
 */
public class BufferWrite {
    private StringBuffer mBuffer;
    private boolean isEmpty;
    public BufferWrite(){
        mBuffer=new StringBuffer();
        isEmpty=true;
    }

    public void write(String msg){
        mBuffer.append(msg);
        isEmpty=false;
    }

    public boolean isEmpty(){
        return isEmpty;
    }

    @Override
    public String toString() {
        return mBuffer.toString();
    }

    public void print(){
        System.out.println("-----------");
        System.out.println(mBuffer);
        System.out.println("++++++++++++++++");
    }

    public void clear(){
        int length = mBuffer.length();
        mBuffer.delete(0, length-1);
        isEmpty=true;
    }
}
