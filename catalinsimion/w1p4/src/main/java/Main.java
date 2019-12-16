public class Main {
    public static void main(String[] args){
        ConnectionManager client=new ConnectionManager();

        for(int i=1;i<10;i++){

            System.out.println(client.getConnection() );
        }
    }
}
