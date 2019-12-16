

public class Reseller {

private Registrar registrar=new Registrar();
public Domain buyDomain(String owner,String host,String name){
    return registrar.createDomain(owner,host,name);
}
}
