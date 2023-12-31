package lk.ijse.gdse.orm.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_address")
    private String Address;

    @Column(name = "customer_age")
    private int age;

    @Column(name = "customer_salary")
    private Double salary;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER ,mappedBy = "customer")
    private List<Order> orders =new ArrayList<>();
}
