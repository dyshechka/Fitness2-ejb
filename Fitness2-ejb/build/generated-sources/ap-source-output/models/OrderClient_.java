package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.BankClient;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-07T21:34:19")
@StaticMetamodel(OrderClient.class)
public class OrderClient_ { 

    public static volatile SingularAttribute<OrderClient, BankClient> idBankClient;
    public static volatile SingularAttribute<OrderClient, Integer> idOrder;
    public static volatile SingularAttribute<OrderClient, Integer> cost;
    public static volatile SingularAttribute<OrderClient, Date> dateOfCreation;

}