package lk.ijse.gdse.orm.hibernate.entity;

import lk.ijse.gdse.orm.hibernate.embeded.NameIdentifier;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/*@Entity(name = "customer")*/

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private int id;

    /*@Column(name = "customer_name")
    private String name;*/

    private NameIdentifier nameIdentifier;

    @Column(name = "customer_address")
    private String address;

    @Column(name = "customer_salary")
    private Double salary;

    @Transient
    private String dob;

    @CreationTimestamp
    private Timestamp datetime;

    public Customer() {
    }

    public Customer(int id, NameIdentifier nameIdentifier, String address, Double salary, String dob, Timestamp datetime) {
        this.id = id;
        this.nameIdentifier = nameIdentifier;
        this.address = address;
        this.salary = salary;
        this.dob = dob;
        this.datetime = datetime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NameIdentifier getNameIdentifier() {
        return nameIdentifier;
    }

    public void setNameIdentifier(NameIdentifier nameIdentifier) {
        this.nameIdentifier = nameIdentifier;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", nameIdentifier=" + nameIdentifier +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", dob='" + dob + '\'' +
                ", datetime=" + datetime +
                '}';
    }
}
