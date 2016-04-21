package services;

import dao.BankDAOLocal;
import dao.FitnessDAOLocal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import models.Subscription;
import models.UserFitness;

@LocalBean
@Stateless
public class ClientService {

    private static final int COEF_WITH_GROUP = 2;
    private static final int COEF_WITHOUT_GROUP = 5;
    private static final int COEF_PRICE_IN_MONTH = 500;
    
    @EJB
    private FitnessDAOLocal fitDAO;

    @EJB
    private BankDAOLocal bankDAO;

    private List<Integer> durations;
    private List<String> typeTraining;

    public boolean paySubscription(int idSub) {
        return true;
    }

    public UserFitness updateData(UserFitness user) {
        return fitDAO.updateUser(user);
    }

    public void createSubscription(UserFitness user, Subscription subscription) {
        subscription.setDateOfPurchase(new Date());
        subscription.setStatus("Оформлен");
        subscription.setPrice((subscription.isNeedGroup() ? COEF_WITH_GROUP : COEF_WITHOUT_GROUP) 
                * COEF_PRICE_IN_MONTH * subscription.getDuration());
        user.setSubscription(subscription);
        fitDAO.createSubscription(subscription);
        fitDAO.updateUser(user);
    }

    public void deleteSubscription(Subscription sub) {
        UserFitness user = sub.getUser();
        user.setSubscription(null);
        fitDAO.updateUser(user);
    }

    public List<String> getAllType() {
        return typeTraining;
    }

    public List<Integer> getAllDuration() {
        return durations;
    }

    @PostConstruct
    private void onCreate() {
        durations = new ArrayList<>();
        durations.add(1);
        durations.add(3);
        durations.add(6);
        durations.add(12);

        typeTraining = new ArrayList<>();
        typeTraining.add("Для похудения");
        typeTraining.add("Для набора веса");
        typeTraining.add("Для рельефа");
    }

}
