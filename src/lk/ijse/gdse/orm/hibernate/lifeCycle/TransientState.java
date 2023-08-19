package lk.ijse.gdse.orm.hibernate.lifeCycle;

import lk.ijse.gdse.orm.hibernate.entity.Customer;

public class TransientState {

    public static void main(String[] args) {

        //Transient State
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Kamal");
        customer.setAddress("Galle");
        customer.setSalary(33433.00);
        customer.setAge(12);

    }

}
