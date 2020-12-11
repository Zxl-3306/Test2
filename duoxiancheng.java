import java.util.Scanner;
//SDK使用java14以上版本
public class duoxiancheng{

    public static void main(String[] args) {
        long starttime=System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入x的值：");
        int x = scanner.nextInt();
        newThread t1=new newThread(0,200000000,x,1);
        newThread t2=new newThread(200000001,400000000,x,2);
        newThread t3=new newThread(400000001,600000000,x,3);
        newThread t4=new newThread(600000001,800000000,x,4);
        newThread t5=new newThread(800000001,1000000000,x,5);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        while(!(t1.isInterrupted()&&t2.isInterrupted()&&t3.isInterrupted()&&t4.isInterrupted()&&t5.isInterrupted())){
        }

        long endtime=System.currentTimeMillis();
        System.out.println("五线程总耗时："+(endtime-starttime)+"ms");
        System.out.println("五线程计算结果："+(result1+result2+result3+result4+result5));
    }

    private static boolean contain(long num, int x) {
        return String.valueOf(num).contains(String.valueOf(x)); }

    static long result1;
    static long result2;
    static long result3;
    static long result4;
    static long result5;
    static class newThread extends Thread{
        private int startnumber;
        private int endnumber;
        private int time;
        private int x;
        @Override
        public void run() {
            long ans = 0;
            for ( int i = startnumber;i <= endnumber; i++) {
                if (contain(i,x)){ ans += i;}
            }

            if(time==1) result1=ans;
            else if(time==2) result2=ans;
            else if(time==3) result3=ans;
            else if(time==4) result4=ans;
            else if(time==5) result5=ans;
            this.interrupt();

        }

        public newThread(int startnumber,int endnumber,int x,int time){
            this.startnumber=startnumber;
            this.endnumber=endnumber;
            this.x=x;
            this.time=time;
        }
    }

}
    /*public static void main(String[] args) {
        long ans = 0;
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        for (long i = 1; i < 1000000000; i++) {
            if (contain(i, x)) ans += i; }
        System.out.println(ans); }
    private static boolean contain(long num, int x) {
        return String.valueOf(num).contains(String.valueOf(x)); }
}*/
