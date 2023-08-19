package lk.ijse.gdse.orm.hibernate.repository;

import lk.ijse.gdse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.gdse.orm.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerRepository {

    private final Session session;

    public CustomerRepository() {

     session =   SessionFactoryConfig
                .getInstance()
                .getSession();

    }

    public Customer getCustomer(int id){
        try {
            Customer customer =session.get(Customer.class,id);
            session.close();
            return customer;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public int saveCustomer(Customer customer){
        Transaction transaction = session.beginTransaction();
        try {
            int customerId = (int) session.save(customer);
            transaction.commit();
            session.close();
            return customerId;
        }catch (Exception e){
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return -1;
        }
    }

    public boolean updateCustomer(Customer customer){
        Transaction transaction = session.beginTransaction();
        try {
            session.update(customer);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
    }

    public boolean deleteCustomer(Customer customer){
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(customer);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
    }

    //using native query
   /* public List<Customer> getAllNative(){
        String sql = "SELECT * FROM customer";
        NativeQuery query = session.createNativeQuery(sql);
        List list = query.list();
        session.close();
        return list;
    }*/


    //using JPQL query
    public List<Customer> getAllJpaql(){
        String sql = "SELECT C FROM Customer AS C";
        Query query = session.createQuery(sql);
        List list = query.list();
        session.close();
        return list;
    }

    public Customer getbyIdJpaql(int id){
        String sql = "SELECT C FROM Customer AS C where C.id=:cus_id";
        Query query = session.createQuery(sql);
        query.setParameter("cus_id",id);
        Customer customer = (Customer) query.getSingleResult();
        session.close();
        return customer;
    }

    //using HQl query
    public List<Customer> getAllHql(){
        String sql = "FROM Customer";
        Query query = session.createQuery(sql);
        List list = query.list();
        session.close();
        return list;
    }


}
