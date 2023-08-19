package lk.ijse.gdse.orm.hibernate;

import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.embeded.MobileNo;
import lk.ijse.gdse.orm.hibernate.embeded.NameIdentifier;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import lk.ijse.gdse.orm.hibernate.repository.CustomerRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.transaction.internal.TransactionImpl;

import java.util.ArrayList;
import java.util.List;

public class AppInitializer {

    public static void main(String[] args) {

        //Save using save method
  Session session = SessionFactoryConfig.getInstance().getSession();

        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Kamal");
        customer.setAddress("Galle");
        customer.setSalary(25000.00);

        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();

        session.close();


        //Update using save method
  Session session1 = SessionFactoryConfig.getInstance().getSession();

        Transaction transaction = session1.beginTransaction();
        Customer customer1 = session1.get(Customer.class, 1);
        customer1.setAddress("Matara");
        customer1.setName("Nimal");
        session1.save(customer1);

        transaction.commit();
        session1.close();



        //Update using update method
  Session session2 = SessionFactoryConfig.getInstance().getSession();

        Transaction transaction = session2.beginTransaction();
        Customer customer2 = session2.get(Customer.class, 1);
        customer2.setAddress("Hambantota");
        customer2.setName("Amara");
        session2.update(customer2);

        transaction.commit();
        session2.close();


        //Delete using delete method
  Session session3 = SessionFactoryConfig.getInstance().getSession();

        Transaction transaction = session3.beginTransaction();
        Customer customer3 = session3.get(Customer.class, 1);
        session3.delete(customer3);

        transaction.commit();
        session3.close();

        Customer customer = getCustomer() ;

        CustomerRepository customerRepository = new CustomerRepository();
        int cust = customerRepository.saveCustomer(customer);
        System.out.println("Saved Cust id: "+cust);

 CustomerRepository repository = new CustomerRepository();
        System.out.println(repository.getCustomer(cust));

        repository = new CustomerRepository();
        customer.setName("kamal");
        customer.setAddress("Matara");
        repository.updateCustomer(customer);
        System.out.println(customer);

        repository = new CustomerRepository();
        System.out.println(repository.deleteCustomer(customer));



    }


    public static Customer getCustomer(){
        Customer customer = new Customer();
        customer.setId(1);
 NameIdentifier nameIdentifier = new NameIdentifier();
        nameIdentifier.setFirst("Kmal");
        nameIdentifier.setSecond("mk");
        nameIdentifier.setThird("mmmm");

        customer.setName("Kamal");
        customer.setAddress("Galle");
        customer.setSalary(33433.00);
        customer.setAge(12);
   List<MobileNo>mobile = new ArrayList<>();
        MobileNo mobile1 = new MobileNo();
        mobile1.setType("Home");
        mobile1.setMobileNo("098653567");
        mobile.add(mobile1);

        MobileNo mobile2 = new MobileNo();
        mobile2.setType("personal");
        mobile2.setMobileNo("234567890-");
        mobile.add(mobile2);

        customer.setMobileNos(mobile);

        return customer;
    }

}
