package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.FitnessGroup;
import models.Subscription;
import models.UserRole;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-07T21:34:19")
@StaticMetamodel(UserFitness.class)
public class UserFitness_ { 

    public static volatile SingularAttribute<UserFitness, Integer> idUser;
    public static volatile SingularAttribute<UserFitness, String> password;
    public static volatile SingularAttribute<UserFitness, UserRole> role;
    public static volatile SingularAttribute<UserFitness, FitnessGroup> fitnessGroup;
    public static volatile SingularAttribute<UserFitness, String> fullName;
    public static volatile SingularAttribute<UserFitness, Boolean> frozen;
    public static volatile SingularAttribute<UserFitness, Date> dateOfBirth;
    public static volatile SingularAttribute<UserFitness, Integer> telephone;
    public static volatile SingularAttribute<UserFitness, Subscription> subscription;
    public static volatile SingularAttribute<UserFitness, String> login;
    public static volatile SingularAttribute<UserFitness, String> email;

}