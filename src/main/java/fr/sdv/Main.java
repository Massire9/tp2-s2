package fr.sdv;

import fr.sdv.dao.CustomerDAO;
import fr.sdv.dao.DiscountDAO;
import fr.sdv.dao.MicroMarketDAO;
import fr.sdv.entity.Customer;
import fr.sdv.entity.Discount;
import fr.sdv.entity.MicroMarket;

public class Main {
    public static void main(String[] args) {
        CustomerDAO cdao = new CustomerDAO();
        DiscountDAO ddao = new DiscountDAO();
        MicroMarketDAO mdao = new MicroMarketDAO();
        for(Customer c: cdao.retrieveAll()) {
            System.out.println(c.getName());
        }

        Customer newCus = new Customer("Maskass", "Nlg", "Nope", "oisy-le-rand", "F", "07098888888", "0101010101", "mastoure@test.fr", 675875546);
        Discount d = ddao.retrieveById((int)'L');
        MicroMarket m = mdao.retrieveById(10095);
        newCus.setDiscountCode(d);
        newCus.setZip(m);
        cdao.create(newCus);
    }
}