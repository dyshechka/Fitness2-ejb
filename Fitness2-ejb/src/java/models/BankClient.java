package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class BankClient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBankClient;

    @NotNull
    @Size(max = 40, min = 10)
    private String nameBankClient;
    
    @NotNull
    private long numberCard;
    
    @NotNull
    private int cvv;
    
    @NotNull
    private int fund;
    
    @NotNull
    @Size(max = 50, min = 10)
    private String adress;
    
    @NotNull
    @Size(max = 11, min = 11)
    private String telephone;
    
    @NotNull
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOfCard;

    public int getIdBankClient() {
        return idBankClient;
    }

    public void setIdBankClient(int idBankClient) {
        this.idBankClient = idBankClient;
    }

    public String getNameBankClient() {
        return nameBankClient;
    }

    public void setNameBankClient(String nameBankClient) {
        this.nameBankClient = nameBankClient;
    }

    public long getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(long numberCard) {
        this.numberCard = numberCard;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getFund() {
        return fund;
    }

    public void setFund(int fund) {
        this.fund = fund;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getDateOfCard() {
        return dateOfCard;
    }

    public void setDateOfCard(Date dateOfCard) {
        this.dateOfCard = dateOfCard;
    }

}
