package realSubject;

import subject.ILawer;

/**
 * Created by Administrator on 2017/2/16.
 */
public class SomeTwo implements ILawer{
    @Override
    public void submit() {
        System.out.print("我是2号，");
        System.out.println("提交申请");
    }

    @Override
    public void burden() {
        System.out.print("我是2号，");
        System.out.println("进行举证");
    }

    @Override
    public void defind() {
        System.out.print("我是2号，");
        System.out.println("开始辩护");
    }

    @Override
    public void finish() {
        System.out.print("我是2号，");
        System.out.println("诉讼完成");
    }
}
