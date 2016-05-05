package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-06T00:41:49")
@StaticMetamodel(BankClient.class)
public class BankClient_ { 

    public static volatile SingularAttribute<BankClient, Integer> idBankClient;
    public static volatile SingularAttribute<BankClient, Integer> cvv;
    public static volatile SingularAttribute<BankClient, String> nameBankClient;
    public static volatile SingularAttribute<BankClient, Integer> avaliableResource;
    public static volatile SingularAttribute<BankClient, Date> dateOfCard;
    public static volatile SingularAttribute<BankClient, Long> numberCard;

}