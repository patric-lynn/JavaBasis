package interview.alibaba;

/**
 * Description
 *
 * @author Lynn-zd
 * @date Created on 2020/4/14 23:56
 */
public class MultiThread {
    volatile static int flag=0;
    public static class Thread1 implements Runnable{
        public synchronized void run() {
            int i=0;
            while(i<=99){
                if(flag==0)
                {
                    System.out.println("t1="+i+"flag="+flag);
                    i+=2;
                    flag=1;
                }
            }
        }

    }
    public static class Thread2 implements Runnable{
        public void run() {
            int i=1;
            while(i<=99){
                if(flag==1)
                {
                    System.out.println("t2="+i+"flag="+flag);
                    i+=2;
                    flag=0;
                }
            }
        }

    }
    public static void main(String[] args) throws InterruptedException{
        Thread t1=new Thread(new Thread1());
        Thread t2=new Thread(new Thread2());
        t1.start();
        t2.start();
    }
}
