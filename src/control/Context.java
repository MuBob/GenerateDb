package control;

import proxySubject.DynamicProxy;
import proxySubject.ProxyLawer;
import realSubject.SomeOne;
import realSubject.SomeTwo;
import subject.ILawer;

import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2017/2/16.
 */
public class Context {
    public static void main(String[] args){
        SomeOne client=new SomeOne();
        ProxyLawer lawer=new ProxyLawer(client);
        lawer.submit();
        lawer.burden();
        lawer.defind();
        lawer.finish();
        System.out.println("----------该换场休息了----------------");
        SomeTwo clientTwo=new SomeTwo();
        DynamicProxy dynamicProxy=new DynamicProxy(clientTwo);
        ClassLoader loader=clientTwo.getClass().getClassLoader();
        ILawer dynamicLawer = (ILawer)Proxy.newProxyInstance(loader, new Class[]{ILawer.class}, dynamicProxy);
        dynamicLawer.submit();
        dynamicLawer.burden();
        dynamicLawer.defind();
        dynamicLawer.finish();
        System.out.println("动态代理dynamicLawer="+dynamicLawer+", dynamicProxy="+dynamicProxy);
    }
}
