package 스레드종료;
// 스레드 안전한 종료 : 원래는 stop() 메소드가 존재했지만 현재는 사용중지 되었음
// 대체방법으로는 stop 플래그를 사용하는 방식, interrupt() 메소드를 사용하는 방식

public class ThreadStopEx {
    public static void main(String[] args) throws InterruptedException {
//        RunThread runThread = new RunThread();
//        runThread.start();
//        Thread.sleep(1000); // main thread가 sleep 상태가 됨
//        runThread.setStop(true);
        InterruptThread interruptThread = new InterruptThread();
        interruptThread.start();
        Thread.sleep(1000);
        interruptThread.interrupt();
    }
}

// stop 플래그를 사용하는 방식
class RunThread extends Thread{
    private boolean stop;   // stop 플래그 설정

    public void setStop(boolean stop) {
        this.stop = stop;
    }
    @Override
    public void run() {
        while(!stop){
            System.out.println("Thread is running......");
        }
        System.out.println("자원 정리");
        System.out.println("실행 종료");
    }
}

class InterruptThread extends Thread{
    @Override
    public void run() {
        try{
            while(true){
                System.out.println("Thread is running......");
                Thread.sleep(1);    // 인터럽트를 걸려면 반드시 슬립을 해주어 실행대기상태로 만들어야한다
            }

        } catch (InterruptedException e){
            System.out.println(e + "예외 발생 !!!");
        }
        System.out.println("자원 정리");
        System.out.println("실행 종료");
    }
}