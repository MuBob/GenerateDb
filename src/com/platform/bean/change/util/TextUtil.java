package com.platform.bean.change.util;

import com.platform.bean.change.entity.CharUtil;

/**
 * Created by Administrator on 2017/2/24.
 */
public class TextUtil {
    public static boolean isEmpty(CharSequence text){
        if (text==null){
            return true;
        }
        if ("".equals(text)){
            return true;
        }
        return false;
    }

    public static String trim(String word) {
        String trim = word.trim();
        int length = trim.length();
        if (trim.endsWith(";")){
            return trim.substring(0, length-1);
        }else {
            return trim.substring(0, length);
        }
    }
    /**
     * 首字符小写
     * @param name
     * @return
     */
    public static String firstLetterLower(String name){
        if (name==null)
            return null;

        if (name.length()>1)
            return name.substring(0,1).toLowerCase() + name.substring(1,name.length());
        else
            return name.toLowerCase();

    }

    /**
     * 首字符大写
     * @param name
     * @return
     */
    public static String firstLetterUpper(String name){
        if (name==null)
            return null;

        if (name.length()>1)
            return name.substring(0,1).toUpperCase() + name.substring(1,name.length());
        else
            return name.toUpperCase();

    }
}
