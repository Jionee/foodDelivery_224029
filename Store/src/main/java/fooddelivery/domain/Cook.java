package fooddelivery.domain;

import fooddelivery.StoreApplication;
import fooddelivery.domain.Accepted;
import fooddelivery.domain.CookEnded;
import fooddelivery.domain.CookStarted;
import fooddelivery.domain.Rejected;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Cook_table")
@Data
public class Cook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderId;

    private Long foodId;

    private String option;

    private String status;

    @PostPersist
    public void onPostPersist() {
        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();

        CookEnded cookEnded = new CookEnded(this);
        cookEnded.publishAfterCommit();

        Accepted accepted = new Accepted(this);
        accepted.publishAfterCommit();

        Rejected rejected = new Rejected(this);
        rejected.publishAfterCommit();
    }

    public static CookRepository repository() {
        CookRepository cookRepository = StoreApplication.applicationContext.getBean(
            CookRepository.class
        );
        return cookRepository;
    }

    public void decide(DecideCommand decideCommand) {}

    public void start() {}

    public static void startCook(CookStarted cookStarted) {
        /** Example 1:  new item 
        Cook cook = new Cook();
        repository().save(cook);

        CookEnded cookEnded = new CookEnded(cook);
        cookEnded.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(cookStarted.get???()).ifPresent(cook->{
            
            cook // do something
            repository().save(cook);

            CookEnded cookEnded = new CookEnded(cook);
            cookEnded.publishAfterCommit();

         });
        */

    }

    public static void endCook(CookEnded cookEnded) {
        /** Example 1:  new item 
        Cook cook = new Cook();
        repository().save(cook);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookEnded.get???()).ifPresent(cook->{
            
            cook // do something
            repository().save(cook);


         });
        */

    }

    public static void loadOrderInfo(OrderPlaced orderPlaced) {
        /** Example 1:  new item 
        Cook cook = new Cook();
        repository().save(cook);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(cook->{
            
            cook // do something
            repository().save(cook);


         });
        */

    }
}
