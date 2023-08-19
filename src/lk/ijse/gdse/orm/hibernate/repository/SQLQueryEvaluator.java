package lk.ijse.gdse.orm.hibernate.repository;

import lk.ijse.gdse.orm.hibernate.entity.Customer;

import java.util.List;

public class SQLQueryEvaluator {
    public static void main(String[] args) {

        CustomerRepository customerRepository = new CustomerRepository();
        List<Customer> customers = customerRepository.getAllJpaql();
        for (Customer customer:customers) {
            System.out.println(customer);
        }

        CustomerRepository customerRepository1 = new CustomerRepository();
        Customer customer = customerRepository1.getbyIdJpaql(1);
        System.out.println(customer);
    }
}
