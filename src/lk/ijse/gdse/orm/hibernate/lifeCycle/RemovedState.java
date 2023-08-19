package lk.ijse.gdse.orm.hibernate.lifeCycle;

import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;

public class RemovedState {
    public static void main(String[] args) {

        Session session = SessionFactoryConfig.getInstance().getSession();
        Customer customer = session.get(Customer.class, 1);
        System.out.println(isExist(session, customer));
        session.detach(customer);
        System.out.println(isExist(session, customer));
        session.close();


    }
    private static String isExist(Session session,Customer customer){
        return session.contains(customer) ? "it is persistant":"it is Detach";
    }
}
