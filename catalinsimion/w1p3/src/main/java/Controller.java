public class Controller {

    public void main() {
        Customer customer = new Customer("Ion");
        Registry registry = new Registry("reg1");
        Reseller reseller = new Reseller("reseller1");
        Registrar registrar = new Registrar("registrar 1");
        Domain domain = new Domain("Ion", "www.abc.ro", "abc");
        customer.addReseller(reseller);
        reseller.addRegistrar(registrar);
        registrar.addRegistry(registry);
        customer.buy(domain);
    }

}


