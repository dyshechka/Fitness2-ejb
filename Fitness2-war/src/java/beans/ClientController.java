package beans;

import services.ClientService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import models.BankClient;
import models.Subscription;
import models.UserFitness;
import services.AutoService;

@Named
@SessionScoped
public class ClientController implements Serializable {

    @EJB
    private ClientService cs;
    
    @EJB
    private AutoService as;

    private UserFitness currentUser;
    private Subscription subscription;
    private BankClient bankClient;

    @PostConstruct
    private void onCreate(){
        currentUser = as.getCurrUser();
        int a=5;
    }
    
    public UserFitness getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserFitness currentUser) {
        this.currentUser = currentUser;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public BankClient getBankClient() {
        return bankClient;
    }

    public void setBankClient(BankClient bankClient) {
        this.bankClient = bankClient;
    }
    
    public String paySubscription() {
        return "paySub";
    }

    public String paySubscriptionConfirm() {
        //здесь будет транзакция... когда-нибудь.. в следующей жизни
        return "client";
    }

    public String createSubsription() {
        subscription = new Subscription();
        return "createSub";
    }

    public String createSubscriptionConfirm() {
        cs.createSubscription(currentUser, subscription);
        currentUser = as.getCurrUser();
        subscription = new Subscription();
        return "client";
    }

    public String deleteSubscription() {
        return "deleteSub";
    }

    public String deleteSubscriptionConfirm() {
        cs.deleteSubscription(currentUser.getSubscription());
        return "client";
    }

    public String updateYourself(){
        return "update";
    } 
    
    public String updateYourselfConfirm(){
        cs.updateData(currentUser);
        return "client";
    } 
    
    public List<String> getAllType() {
        return cs.getAllType();
    }
    
    public List<Integer> getAllDuration() {
        return cs.getAllDuration();
    }
}
