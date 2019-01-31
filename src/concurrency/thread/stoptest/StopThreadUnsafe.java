package concurrency.thread.stoptest;

/**
 * @Author:xiepei5
 * @Decription:
 * @Dete : 14:55 2019/1/7
 * 描述：测试stop 的问题
 */
public class StopThreadUnsafe {
    public static User u = new User();
    public static class User{
        private int id;
        private String name;
        public User(){
            id = 0;
            name = "0";
        }

        public int getId () {
            return id;
        }

        public void setId ( int id ) {
            this.id = id;
        }

        public String getName () {
            return name;
        }

        public void setName ( String name ) {
            this.name = name;
        }

        @Override
        public String toString () {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static class ChangeObjectThread extends Thread{
//        /**
//         *@Author: xiepei5
//         *@Date：15:39 2019/1/7
//         *@Method:
//         *@MethodParam:
//         *@MethodReturn:
//         *@描述：停止操作，此操作只是
//         */
//        Boolean stopme = false;
//        public void stopMe(){
//            stopme = true;
//        }
        @Override
        public void run () {
            while(true){
//                if(stopme){
//                    System.out.println("exit by stop me ");
//                    break;
//                }
                synchronized (u){
                    int v = (int)(System.currentTimeMillis()/1000);
                    u.setId(v);
                    try{
                        Thread.sleep(100);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    u.setName(String.valueOf(v));
                }
                Thread.yield();
            }
        }
    }

    public static class ReadObjectThread extends Thread{
        @Override
        public void run () {
            while(true){
                synchronized (u){
                    if(u.getId() != Integer.parseInt(u.getName())){
                        System.out.println(u.toString());
                    }
                }
                Thread.yield();
            }
        }
    }

    public static void main ( String[] args ) throws InterruptedException{
        new ReadObjectThread().start();
        while(true){
            Thread t = new ChangeObjectThread();
            t.start();
            Thread.sleep(150);
            t.stop();
        }
    }
}
