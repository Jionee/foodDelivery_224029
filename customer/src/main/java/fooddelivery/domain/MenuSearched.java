package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class MenuSearched extends AbstractEvent {

    private Long id;

    public MenuSearched(Order aggregate) {
        super(aggregate);
    }

    public MenuSearched() {
        super();
    }
}
