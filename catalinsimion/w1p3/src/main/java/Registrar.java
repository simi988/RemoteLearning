
public class Registrar {

private Registry registry=new Registry();
public  Domain createDomain(String owner,String host,String name){

    return registry.createDomain(owner,host,name);
}
}
