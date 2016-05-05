package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

@Entity
public class Transfer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
//    @Column(name = "FROM_NUMBER")
    @ManyToOne
    private BankClient fromNumber;

    @NotNull
//    @Column(name = "TO_NUMBER")
    @ManyToOne
    private BankClient toNumber;

    @NotNull
    private int transferedResources;

    @NotNull
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOperation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BankClient getFromNumber() {
        return fromNumber;
    }

    public void setFromNumber(BankClient fromNumber) {
        this.fromNumber = fromNumber;
    }

    public BankClient getToNumber() {
        return toNumber;
    }

    public void setToNumber(BankClient toNumber) {
        this.toNumber = toNumber;
    }

   

    public int getTransferedResources() {
        return transferedResources;
    }

    public void setTransferedResources(int transferedResources) {
        this.transferedResources = transferedResources;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

}
