package w11p1.file;

import java.util.List;

public class Server implements Runnable {
    private static final int MAX_SIZE = 10;
    private List<String> messages;

    public Server(List<String> messages) {
        this.messages = messages;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (messages) {
                if (messages.isEmpty()) {
                    try {
                        messages.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String consumedMessage = messages.remove(0);
                System.out.println(consumedMessage + " has been consumed");
                messages.notifyAll();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}