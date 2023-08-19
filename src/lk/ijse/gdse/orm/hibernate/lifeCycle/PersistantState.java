package lk.ijse.gdse.orm.hibernate.lifeCycle;

import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;

public class PersistantState {

    public static void main(String[] args) {

        //Persistant State
        Session session = SessionFactoryConfig.getInstance().getSession();


        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Kamal");
        customer.setAddress("Galle");
        customer.setSalary(33433.00);
        customer.setAge(12);

        session.save(customer);

        System.out.println(isExist(session, customer));

    }

    private static String isExist(Session session,Customer customer){
        return session.contains(customer) ? "it is persistant":"it is transient";
    }

}
