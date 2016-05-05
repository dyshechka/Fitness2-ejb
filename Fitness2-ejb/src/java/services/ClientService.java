package services;

import dao.BankDAOLocal;
import dao.FitnessDAOLocal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import models.BankClient;
import models.Subscription;
import models.Transfer;
import models.UserFitness;

@LocalBean
@Stateless
public class ClientService {

    private static final int COEF_WITH_GROUP = 2;
    private static final int COEF_WITHOUT_GROUP = 5;
    private static final int COEF_PRICE_IN_MONTH = 500;

    private static final long NUMBER_CARD_OF_FITNESS_CENTER = 1234123412341234L;

    @EJB
    private FitnessDAOLocal fitDAO;

    @EJB
    private BankDAOLocal bankDAO;

    private List<Integer> durations;

    public void paySubscription(UserFitness user, BankClient bankClient) {
        BankClient checkClient = bankDAO.readBankClient(bankClient.getNumberCard());
        if (checkClient != null) {
            if (checkClient.checkRightData(bankClient)) {
                Subscription subscription = user.getSubscription();
                if (checkClient.getAvaliableResource() >= subscription.getPrice()) {
                    BankClient fitnessClient = bankDAO.readBankClient(NUMBER_CARD_OF_FITNESS_CENTER);
                    checkClient.setAvaliableResource(checkClient.getAvaliableResource() - subscription.getPrice());
                    fitnessClient.setAvaliableResource(fitnessClient.getAvaliableResource() + subscription.getPrice());

                    Transfer transferFromClient = new Transfer();
                    transferFromClient.setDateOperation(new Date());
                    transferFromClient.setFromNumber(checkClient);
                    transferFromClient.setToNumber(fitnessClient);
                    transferFromClient.setTransferedResources(subscription.getPrice());

                    subscription.setStatus("Оплачен");
                    subscription.setDateOfPurchase(new Date());

                    bankDAO.createTransfer(transferFromClient);
                    fitDAO.updateSubscription(subscription);
                } else {
                    throw new EJBException("Что-то пошло не так..");
                }
            } else {
                throw new EJBException("Неверные данные");
            }
        } else {
            throw new EJBException("Неверный номер карты");
        }
        //правильно ли заполнен банковский клиент
        //проверить наличие средств у клиента
        //если все так, то вытаскиваем номер фитнес центра
        //списать с клиента деньги
        //добавить к фитнес центру деньги
        //изменить дату абонементу
        //статус абонемента оплачен
    }

    public UserFitness updateData(UserFitness user) {
        return fitDAO.updateUser(user);
    }

    public void createSubscription(UserFitness user, Subscription subscription) {
        subscription.setDateOfPurchase(new Date());
        subscription.setStatus("Оформлен");
        subscription.setPrice(calculatePrice(subscription));
        subscription.setUser(user);
        user.setSubscription(subscription);
        fitDAO.createSubscription(subscription);
        fitDAO.updateUser(user);
    }

    public int calculatePrice(Subscription subscription) {
        return (subscription.isNeedGroup()
                ? COEF_WITH_GROUP
                : COEF_WITHOUT_GROUP)
                * COEF_PRICE_IN_MONTH
                * subscription.getDuration();
    }

    public void deleteSubscription(Subscription sub) {
        UserFitness user = sub.getUser();
        user.setSubscription(null);
        fitDAO.updateUser(user);
    }

    public List<String> getTypesTraining() {
        return fitDAO.getTypesTraining();
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
    }

}
