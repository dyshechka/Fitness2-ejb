package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.UserFitness;
import models.Visit;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-06T00:41:49")
@StaticMetamodel(UserVisits.class)
public class UserVisits_ { 

    public static volatile SingularAttribute<UserVisits, Integer> idUserVisits;
    public static volatile ListAttribute<UserVisits, Visit> visits;
    public static volatile SingularAttribute<UserVisits, UserFitness> user;

}