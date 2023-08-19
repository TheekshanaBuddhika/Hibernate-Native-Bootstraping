package lk.ijse.gdse.orm.hibernate.lifeCycle;

import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;

public class DetachState {
    public static void main(String[] args) {


        Session session = SessionFactoryConfig.getInstance().getSession();


        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Kamal");
        customer.setAddress("Galle");
        customer.setSalary(33433.00);
        customer.setAge(12);

        session.save(customer);
        System.out.println(isExist(session, customer));
        session.close();

        //Without detach method

        Session session1 = SessionFactoryConfig.getInstance().getSession();
        System.out.println(isExist(session1, customer));
        session1.close();

        //using detach
       /* Session session1 = SessionFactoryConfig.getInstance().getSession();
        session1.detach(customer);

        System.out.println(isExist(session1, customer));
        session1.close();*/

    }

    private static String isExist(Session session,Customer customer){
        return session.contains(customer) ? "it is persistant":"it is Detach";
    }
}
