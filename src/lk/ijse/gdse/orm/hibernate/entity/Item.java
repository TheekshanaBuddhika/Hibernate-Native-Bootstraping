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
@Table(name = "Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int id;

    @Column(name = "item_description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "item")
    private List<OrderDetail> orderDetails = new ArrayList<>();

/*    @ManyToMany(mappedBy = "items")
    private List<Order> orders = new ArrayList<>();*/

}
