package EntityMapping;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "LinkedPurchaseList")
@Getter
@Setter
public class LinkedPurchaseList {
    @EmbeddedId
    private LinkedPurchaseId id;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(insertable = false,
            updatable = false
    )
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(insertable = false,
            updatable = false
    )
    private Course course;

    @Column(columnDefinition = "int unsigned")
    private Integer price;

    @Column(name = "subscription_date")
    private ZonedDateTime subscriptionDate;

    public LinkedPurchaseList() {}

    LinkedPurchaseList(PurchaseList purchase) {

        setId(new LinkedPurchaseId(
                purchase.getStudent().getId(),
                purchase.getCourse().getId()));

        setPrice(purchase.getPrice());
        setSubscriptionDate(purchase.getSubscriptionDate());
    }

    public static LinkedPurchaseList doMappingObj(PurchaseList purchase) {
        return new LinkedPurchaseList(purchase);
    }
}