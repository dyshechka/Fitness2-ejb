package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.UserFitness;
import models.UserVisits;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-07T21:34:19")
@StaticMetamodel(FitnessGroup.class)
public class FitnessGroup_ { 

    public static volatile SingularAttribute<FitnessGroup, Integer> idGroup;
    public static volatile ListAttribute<FitnessGroup, UserVisits> usersVisits;
    public static volatile SingularAttribute<FitnessGroup, String> typeTraining;
    public static volatile SingularAttribute<FitnessGroup, String> nameGroup;
    public static volatile ListAttribute<FitnessGroup, UserFitness> users;

}