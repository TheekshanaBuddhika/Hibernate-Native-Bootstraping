package lk.ijse.gdse.orm.hibernate.entity;

import lk.ijse.gdse.orm.hibernate.embeded.MobileNo;
import lk.ijse.gdse.orm.hibernate.embeded.NameIdentifier;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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

    public Customer(int id, NameIdentifier nameIdentifier, List<MobileNo> mobileNos, String address, Double salary, String dob, Timestamp datetime) {
        this.id = id;
        this.nameIdentifier = nameIdentifier;
        this.mobileNos = mobileNos;
        this.address = address;
        this.salary = salary;
        this.dob = dob;
        this.datetime = datetime;
    }

    public Customer() {
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
                ", mobileNos=" + mobileNos +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", dob='" + dob + '\'' +
                ", datetime=" + datetime +
                '}';
    }

    public List<MobileNo> getMobileNos() {
        return mobileNos;
    }

    public void setMobileNos(List<MobileNo> mobileNos) {
        this.mobileNos = mobileNos;
    }
}
