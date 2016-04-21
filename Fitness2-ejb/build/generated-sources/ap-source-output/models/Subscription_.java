package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.UserFitness;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-21T21:57:02")
@StaticMetamodel(Subscription.class)
public class Subscription_ { 

    public static volatile SingularAttribute<Subscription, Integer> duration;
    public static volatile SingularAttribute<Subscription, Date> dateOfPurchase;
    public static volatile SingularAttribute<Subscription, Integer> price;
    public static volatile SingularAttribute<Subscription, String> typeTraining;
    public static volatile SingularAttribute<Subscription, UserFitness> user;
    public static volatile SingularAttribute<Subscription, Integer> idSubscription;
    public static volatile SingularAttribute<Subscription, String> status;
    public static volatile SingularAttribute<Subscription, Boolean> needGroup;

}