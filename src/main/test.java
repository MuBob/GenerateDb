package main;

import java.lang.reflect.Field;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/24.
 */
public class test {
    public static void main(String[] args){
        Class<TestBean> testBeanClass = TestBean.class;
        try {
        Field field = testBeanClass.getDeclaredField("list");
        Class type= field.getType();
        boolean isList = isList(type);
        System.out.println("type="+type+", isList="+isList);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static boolean isList(Class<?> type){
        return /*isSubclassOf(type, AbstractList.class)||*/isSubclassOf(type, List.class);
    }

    public static boolean isSubclassOf(Class<?> type, Class<?> superClass) {
        System.out.println("type="+type);


        if (type != null) {
            Class<?>[] interfaces = type.getInterfaces();
            System.out.println("type.superClass="+type.getSuperclass()+", superClass="+superClass);
            if (type.equals(superClass)) {
                return true;
            }else if (interfaces!=null&&interfaces.length>0){
                for (int i = 0; i < interfaces.length; i++) {
                    System.out.println("interface["+i+"]="+interfaces[i]);
                    if (interfaces[i].equals(superClass)){
                        return true;
                    }
                }
            }

            return isSubclassOf(type.getSuperclass(), superClass);
        }
        return false;
    }
}
