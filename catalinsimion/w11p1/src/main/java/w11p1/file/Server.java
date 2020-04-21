package w11p1.file;

import java.util.PriorityQueue;

public class Server{
    private static final int MAX_SIZE = 10;
    private PriorityQueue<String> queue = new PriorityQueue<>(MAX_SIZE);
    public synchronized void add(String message) throws InterruptedException {
        if (queue.size()==MAX_SIZE){
            wait();
            remove();
        }
       else{
            queue.add(message);
            System.out.println(message);
        }
    }
public synchronized void remove(){
        queue.remove();
        notify();
}

}