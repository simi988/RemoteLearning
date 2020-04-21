package w11p1.file;

public class Client implements Runnable {
    Server server=new Server();
    private String message;
    public Client(String message) {
        this.message=message;
    }
    public String getMessage() {
        return message;
    }

    @Override
    public void run() {

        try {
            server.add(getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
