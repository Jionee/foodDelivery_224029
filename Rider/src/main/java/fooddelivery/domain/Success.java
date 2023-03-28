package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Success extends AbstractEvent {

    private Long id;

    public Success(Delivery aggregate) {
        super(aggregate);
    }

    public Success() {
        super();
    }
}
