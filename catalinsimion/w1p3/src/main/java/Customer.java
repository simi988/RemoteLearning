
public class Customer  {

private Domain domain;
private Reseller sell=new Reseller();
public void buy(String owner,String host,String name){
    domain=sell.buyDomain(owner,host,name);
}
}
