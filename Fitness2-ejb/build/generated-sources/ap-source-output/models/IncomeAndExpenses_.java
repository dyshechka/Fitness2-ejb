package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.BankClient;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-07T21:34:19")
@StaticMetamodel(IncomeAndExpenses.class)
public class IncomeAndExpenses_ { 

    public static volatile SingularAttribute<IncomeAndExpenses, BankClient> idBankClient;
    public static volatile SingularAttribute<IncomeAndExpenses, Integer> idIAE;
    public static volatile SingularAttribute<IncomeAndExpenses, Integer> summ;
    public static volatile SingularAttribute<IncomeAndExpenses, String> toFrom;
    public static volatile SingularAttribute<IncomeAndExpenses, String> title;
    public static volatile SingularAttribute<IncomeAndExpenses, Date> dateOperation;
    public static volatile SingularAttribute<IncomeAndExpenses, String> fromTo;

}