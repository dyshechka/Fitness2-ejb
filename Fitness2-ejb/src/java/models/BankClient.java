package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
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
    //@Pattern(regexp = "[0-9]{13,16}")
    @Column(unique = true)
    private long numberCard;
    
    @NotNull
    //@Pattern(regexp = "\\d{3}")
    private int cvv;
    
    @NotNull
    private int avaliableResource;
    
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

    public int getAvaliableResource() {
        return avaliableResource;
    }

    public void setAvaliableResource(int avaliableResource) {
        this.avaliableResource = avaliableResource;
    }

    public Date getDateOfCard() {
        return dateOfCard;
    }

    public void setDateOfCard(Date dateOfCard) {
        this.dateOfCard = dateOfCard;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idBankClient;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BankClient other = (BankClient) obj;
        return this.idBankClient == other.idBankClient;
    }
    
    public boolean checkRightData(BankClient bankClient){
        return (this.cvv == bankClient.getCvv() && 
                this.dateOfCard.equals(bankClient.getDateOfCard()) && 
                this.nameBankClient.equals(bankClient.getNameBankClient()));
        
    }
    
    

}
