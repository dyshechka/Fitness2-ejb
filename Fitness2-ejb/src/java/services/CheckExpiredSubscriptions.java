package services;

import dao.FitnessDAOLocal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.enterprise.context.ApplicationScoped;
import models.Subscription;

@Singleton
@LocalBean
@ApplicationScoped
public class CheckExpiredSubscriptions {

    @EJB
    private FitnessDAOLocal fitDAO;

    @Schedule
    public void check() {
        List<Subscription> subscriptions = fitDAO.readAllSubscriptions();
        subscriptions.stream().filter(sub -> "Оплачен".equals(sub.getStatus())).forEach(sub -> {
            LocalDate purchaseDate = LocalDateTime.ofInstant(sub.getDateOfPurchase().toInstant(), ZoneId.systemDefault()).toLocalDate();
            LocalDate now = LocalDate.now();
            long months = Period.between(purchaseDate, now).toTotalMonths();
            if (months >= sub.getDuration()){
                sub.setStatus("Просрочен");
            }
        });
    }
}
