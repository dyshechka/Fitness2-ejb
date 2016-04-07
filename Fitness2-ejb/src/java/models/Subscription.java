package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Subscription implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSubscription;

    @NotNull
    private int duration;

    @NotNull
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOfPurchase;

    @NotNull
    @Size(max = 15, min = 5)
    private String status;

    @NotNull
    @Size(max = 40, min = 7)
    private String typeTraining;

    @NotNull
    private boolean needGroup;

    @NotNull
    private int price;

    @OneToOne(mappedBy = "subscription")
    private UserFitness user;

    public int getIdSubscription() {
        return idSubscription;
    }

    public void setIdSubscription(int idSubscription) {
        this.idSubscription = idSubscription;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTypeTraining() {
        return typeTraining;
    }

    public void setTypeTraining(String typeTraining) {
        this.typeTraining = typeTraining;
    }

    public boolean isNeedGroup() {
        return needGroup;
    }

    public void setNeedGroup(boolean needGroup) {
        this.needGroup = needGroup;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public UserFitness getUser() {
        return user;
    }

    public void setUser(UserFitness user) {
        this.user = user;
    }

}
