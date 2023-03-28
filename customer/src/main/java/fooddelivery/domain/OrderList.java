package fooddelivery.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "OrderList_table")
@Data
public class OrderList {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
}
