package com.platform.bean.change.generate;

import com.platform.bean.change.entity.CharUtil;
import com.platform.bean.change.entity.DBType;
import com.platform.bean.change.util.TextUtil;

/**
 * Created by Administrator on 2017/2/24.
 */
public class GenerateDB {

    public static String generateDBTable(String name, String id){
        StringBuffer text=new StringBuffer();
        text.append(CharUtil.AT);
        text.append(DBType.TITLE_TABLE);
        text.append(CharUtil.FIRS_PARENTHES_CHAR);
        text.append(DBType.NAME);
        text.append(CharUtil.EQUAL_CHAR);
        text.append(CharUtil.QUOTE_MARKS_CHAR);
        text.append(name);
        text.append(CharUtil.QUOTE_MARKS_CHAR);
        text.append(CharUtil.COMMA_CHAR);
        text.append(DBType.ID);
        text.append(CharUtil.EQUAL_CHAR);
        if (!TextUtil.isEmpty(id)) {
            text.append(CharUtil.QUOTE_MARKS_CHAR);
            text.append(id);
            text.append(CharUtil.QUOTE_MARKS_CHAR);
        }
        text.append(CharUtil.LAST_PARENTHES_CHAR);
        text.append(CharUtil.ENTER_CHAR);
        return text.toString();
    }

    public static String generateDBColumn(String name){
        StringBuffer text=new StringBuffer();
        text.append(CharUtil.AT);
        text.append(DBType.TITLE_COLUMN);
        text.append(CharUtil.FIRS_PARENTHES_CHAR);
        text.append(DBType.NAME);
        text.append(CharUtil.EQUAL_CHAR);
        text.append(CharUtil.QUOTE_MARKS_CHAR);
        text.append(name);
        text.append(CharUtil.QUOTE_MARKS_CHAR);
        text.append(CharUtil.LAST_PARENTHES_CHAR);
        text.append(CharUtil.ENTER_CHAR);
        return text.toString();
    }

    /**
     *     @ForeignModel(
     *     name = "districts",
     *     innerIndex = 1,
     *     foreignBeanClass = LocationBean.class, foreignKeys = {"cityId"}, foreignKeyTypes = {String.class})
     * @param name
     * @param innerIndex
     * @param innerBeanClass
     * @return
     */
    public static String generateDBForeignBean(String name, long innerIndex, String innerBeanClass, String[] foreignKeys, String[] foreignKeyTypes){
        StringBuffer text=new StringBuffer();
        text.append(CharUtil.AT);text.append(DBType.TITLE_FOREIGN);text.append(CharUtil.FIRS_PARENTHES_CHAR);
        text.append(DBType.NAME);text.append(CharUtil.EQUAL_CHAR);text.append(CharUtil.QUOTE_MARKS_CHAR);text.append(name);text.append(CharUtil.QUOTE_MARKS_CHAR);text.append(CharUtil.COMMA_CHAR);
        text.append(DBType.INNER_INDEX);text.append(CharUtil.EQUAL_CHAR);text.append(innerIndex);text.append(CharUtil.COMMA_CHAR);
        text.append(DBType.FOREIGN_BEAN_CLASS);text.append(CharUtil.EQUAL_CHAR);text.append(innerBeanClass);text.append(CharUtil.COMMA_CHAR);
        text.append(DBType.FOREIGN_KEYS);text.append(CharUtil.EQUAL_CHAR);text.append(generateArrayListJson(foreignKeys, true));text.append(CharUtil.COMMA_CHAR);
        text.append(DBType.FOREIGN_KEY_TYPES);text.append(CharUtil.EQUAL_CHAR);text.append(generateArrayListJson(foreignKeyTypes, false));text.append(CharUtil.COMMA_CHAR);
        text.append(CharUtil.LAST_PARENTHES_CHAR);
        text.append(CharUtil.ENTER_CHAR);
        return text.toString();
    }


    private static String generateArrayListJson(String[] array, boolean isStringJson){
        StringBuffer text=new StringBuffer();
        if (array!=null&&array.length>0){
            text.append(CharUtil.FIRS_BRACE_CHAR);
            for (int i = 0; i < array.length; i++) {
                if (i>0)
                    text.append(CharUtil.COMMA_CHAR);
                if (isStringJson)
                    text.append(CharUtil.QUOTE_MARKS_CHAR);
                text.append(array[i]);
                if (isStringJson)
                    text.append(CharUtil.QUOTE_MARKS_CHAR);
            }
            text.append(CharUtil.LAST_BRACE_CHAR);
        }
        return text.toString();
    }
}
