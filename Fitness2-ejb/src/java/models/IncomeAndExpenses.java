package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class IncomeAndExpenses implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idIAE;

    @NotNull
    @Size(max = 30, min = 15)
    private String title;

    @NotNull
    @Size(max = 40, min = 10)
    private String fromTo;

    @NotNull
    @Size(max = 40, min = 10)
    private String toFrom;

    @NotNull
    private int summ;

    @NotNull
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOperation;

    @NotNull
    @ManyToOne
    private BankClient idBankClient;

    public int getIdIAE() {
        return idIAE;
    }

    public void setIdIAE(int idIAE) {
        this.idIAE = idIAE;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFromTo() {
        return fromTo;
    }

    public void setFromTo(String fromTo) {
        this.fromTo = fromTo;
    }

    public String getToFrom() {
        return toFrom;
    }

    public void setToFrom(String toFrom) {
        this.toFrom = toFrom;
    }

    public int getSumm() {
        return summ;
    }

    public void setSumm(int summ) {
        this.summ = summ;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public BankClient getIdBankClient() {
        return idBankClient;
    }

    public void setIdBankClient(BankClient idBankClient) {
        this.idBankClient = idBankClient;
    }

}
