package w1p3.main;

import w1p3.file.*;

public class Controller {
    public static void main(String[] args) {
        Customer customer = new Customer("Ion");
        Registry registry = new Registry("reg1");
        Reseller reseller = new Reseller("reseller1");
        Registrar registrar = new Registrar("registrar 1");
        Domain domain = new Domain("Ion", "www.abc.ro", "abc");
        customer.addReseller(reseller);
        reseller.addRegistrar(registrar);
        registrar.addRegistry(registry);
        System.out.println(customer.buy(domain));
        Domain domain1 = new Domain("Ion", "www.abc.ro", "abc");
         System.out.println(customer.buy(domain1));
    }
}






