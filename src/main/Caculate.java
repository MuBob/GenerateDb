package main;

/**
 * Created by Administrator on 2017/2/17.
 */
public class Caculate {
    public static void main(String[] args){
        int a=5;
        int b=4;
        int[] bei=getSmallNumber(a, b);
        if (bei[1]>=0) {
            int result1 = b * bei[0];
            int result2=b*bei[1];
            System.out.print("距离"+a+"最近的"+b+"的倍数结果有两个，一个是"+result1+"，是"+bei[0]+"倍； 另一个是"+result2+", 是"+bei[1]+"倍！距离都是"+Math.abs(result1-a));
        }else if (bei[0]<0){
            System.out.print("距离"+a+"最近的"+b+"的倍数结果获取失败!");
        }else {
            int result = b * bei[0];
            System.out.print("距离"+a+"最近的"+b+"的倍数结果是"+result+"，是"+bei[0]+"倍！距离是"+Math.abs(result-a));
        }
    }

    /**
     * 获取距离a最近的n的倍数
     * @param a
     * @param n
     * @return
     */
    public static int[] getSmallNumber(int a, int n){
        int[] results=new int[]{-1,-1};
        if (n==0)
            return results;
        int x=a/n;
        int y=a%n;
        System.out.println("x="+x+", y="+y);

        if (y==0) {
            //刚好倍数
            results[0] = x;
//            results[1] = x;
        }else {
            //有余数，则取中
            int center = n / 2;
            if (y > center) {
                //余数大
                results[0] = x + 1;
            } else if (y < center) {
                //余数小
                results[0] = x;
            } else {
                //余数居中
                results[0] = x;
                results[1] = x + 1;
            }
        }
        return results;
    }
}
