public class Registry {

  public   Domain createDomain(String owner,String host,String name){
        return new Domain(owner,host,name);
    }
}
