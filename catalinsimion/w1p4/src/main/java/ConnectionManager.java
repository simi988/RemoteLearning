public class ConnectionManager {
  private   Connection[] connections=new Connection[5];
public ConnectionManager(){
    Connection p=new Connection();
    connections[0]=p;
    connections[1]=new Connection();
    connections[2]=new Connection();
    connections[3]=new Connection();
    connections[4]=new Connection();
}
   public Connection getConnection( ){
        for(int i=0;i<connections.length;i++){
            if(connections[i]!=null){
                Connection c=new Connection();
               c= connections[i];
                connections[i]=null;
                return c;

            }


        }
        return null;
    }
}
