package lk.ijse.gdse.orm.hibernate.repository;

import lk.ijse.gdse.orm.hibernate.entity.Customer;

import java.util.List;

public class SQLQueryEvaluator {
    public static void main(String[] args) {

        CustomerRepository customerRepository = new CustomerRepository();
        List<Customer> customers = customerRepository.getAllNative();
        for (Customer customer:customers) {
            System.out.println(customer);
        }

    }
}
