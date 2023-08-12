package lk.ijse.gdse.orm.hibernate.entity;

import lk.ijse.gdse.orm.hibernate.embeded.OrderDetailPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "`order_details`")
public class OrderDetail {

    @Column(name = "order_quantity")
    private int quantity;

    @Column(name = "item_price")
    private Double price;

    @EmbeddedId
    private OrderDetailPK orderDetailPK;

    @ManyToOne
    @JoinColumn(name = "order_id" , referencedColumnName = "order_id" , insertable = false , updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "item_id" , referencedColumnName = "item_id" ,insertable = false , updatable = false)
    private Item item;
}
