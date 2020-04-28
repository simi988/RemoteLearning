package w11p1.file;

import java.util.List;

public class Client implements Runnable {
    private static final int MAX_SIZE = 10;
    private String message;
    private List<String> messages;

    public Client(String message, List<String> messages) {
        this.message = message;
        this.messages = messages;
    }


    @Override
    public void run() {
        while (true) {
            synchronized (messages) {
                if (messages.size() >= MAX_SIZE) {
                    try {
                        messages.wait();
                        System.out.println(Thread.currentThread().getId() + " is waiting");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Adding thread " + message);
                messages.add(message);
                messages.notify();

            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
