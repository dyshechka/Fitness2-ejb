package beans;

import services.ClientService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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

    private Subscription subscription;
    private BankClient bankClient;
    private UserFitness user;

    public UserFitness getCurrentUser() {
        return as.getCurrUser();
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

    public UserFitness getUser() {
        return user;
    }

    public void setUser(UserFitness user) {
        this.user = user;
    }

    public String paySubscription() {
        bankClient = new BankClient();
        return "paySub";
    }

    public String paySubscriptionConfirm() {
        try {
            cs.paySubscription(as.getCurrUser(), bankClient);
            showMessage("Абонемент оплачен успешно");
        } catch (Exception e) {
            showMessage(e.getCause().getMessage());
        }
        return "client";
    }

    public String createSubsription() {
        subscription = new Subscription();
        return "createSub";
    }

    public String createSubscriptionConfirm() {
        cs.createSubscription(as.getCurrUser(), subscription);
        subscription = new Subscription();
        showMessage("Абонемент создан");
        return "client";
    }

    public String deleteSubscription() {
        return "deleteSub";
    }

    public String deleteSubscriptionConfirm() {
        cs.deleteSubscription(as.getCurrUser().getSubscription());
        showMessage("Абонемент удален");
        return "client";
    }

    public String updateYourself() {
        user = as.getCurrUser();
        return "update";
    }

    public String updateYourselfConfirm() {
        cs.updateData(user);
        showMessage("Вы изменили данные о себе");
        return "client";
    }

    public List<String> getAllType() {
        return cs.getTypesTraining();
    }

    public List<Integer> getAllDuration() {
        return cs.getAllDuration();
    }

    public void calculatePrice() {
        subscription.setPrice(cs.calculatePrice(subscription));
    }

    private void showMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(message));
        context.getExternalContext().getFlash().setKeepMessages(true);
    }
}
