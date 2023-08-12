/*
package lk.ijse.gdse.orm.hibernate.entity;

import lk.ijse.gdse.orm.hibernate.embeded.MobileNo;
import lk.ijse.gdse.orm.hibernate.embeded.NameIdentifier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

*/
/*@Entity(name = "customer")*//*

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private int id;

    */
/*@Column(name = "customer_name")
    private String name;*//*


    private NameIdentifier nameIdentifier;

    @ElementCollection
    @CollectionTable(name = "customer_mobile_numbers"  , joinColumns = @JoinColumn(name = "customer_id"))
    private List<MobileNo>mobileNos = new ArrayList<>();

    @Column(name = "customer_address")
    private String address;

    @Column(name = "customer_salary")
    private Double salary;

    @Transient
    private String dob;

    @CreationTimestamp
    private Timestamp datetime;

    @Column(name = "customer_age" , columnDefinition = "TinyInt")
    private int age;

}
*/
