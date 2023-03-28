package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookEnded extends AbstractEvent {

    private Long id;

    public CookEnded(Cook aggregate) {
        super(aggregate);
    }

    public CookEnded() {
        super();
    }
}
