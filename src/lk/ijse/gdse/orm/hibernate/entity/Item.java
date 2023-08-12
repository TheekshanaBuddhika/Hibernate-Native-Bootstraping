package lk.ijse.gdse.orm.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int id;

    @Column(name = "item_quantity")
    private int quantity;

    @Column(name = "item_price")
    private Double price;

    @Column(name = "item_description")
    private String description;

    @ManyToMany(mappedBy = "item", targetEntity = Order.class)
    private Order order;

}
