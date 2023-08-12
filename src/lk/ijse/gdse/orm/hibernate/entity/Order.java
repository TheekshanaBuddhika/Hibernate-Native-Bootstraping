package lk.ijse.gdse.orm.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;

    @CreationTimestamp
    @Column(name = "order_date")
    private Timestamp orderDateTime;

    @Column(name = "order_description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetails = new ArrayList<>();

   /* @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    private List<Item> items = new ArrayList<>();*/



}
