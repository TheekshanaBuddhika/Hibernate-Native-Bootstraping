package lk.ijse.gdse.orm.hibernate;

import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;

public class GetVsLoad {

    public static void main(String[] args) {

        int cust_id = getCustomer().getId();

        Session session2 = SessionFactoryConfig.getInstance().getSession();
        session2.save(getCustomer());
        session2.close();


        /*1.Get*/
        Session session = SessionFactoryConfig.getInstance().getSession();
        Customer customer = session.get(Customer.class,cust_id);
        System.out.println(" Get " + customer.getId());
        System.out.println(" Get " + customer.getName());
        session.close();

       /* 2.Load*/
        Session session1 = SessionFactoryConfig.getInstance().getSession();
        Customer customer1 = session1.load(Customer.class,cust_id);
        System.out.println(" Load " + customer1.getId());
        System.out.println(" Load " + customer1.getName());
        session1.close();

    }
    public static Customer getCustomer(){
        Customer customer = new Customer();
        customer.setId(1);
       /* NameIdentifier nameIdentifier = new NameIdentifier();
        nameIdentifier.setFirst("Kmal");
        nameIdentifier.setSecond("mk");
        nameIdentifier.setThird("mmmm");*/
        customer.setName("Kamal");
        customer.setAddress("Galle");
        customer.setSalary(33433.00);
        customer.setAge(12);
        return customer;
    }

}
