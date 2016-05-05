package services;

import dao.FitnessDAOLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import models.FitnessGroup;
import models.Subscription;
import models.UserFitness;

@LocalBean
@Stateless
public class TrainerService {

    @EJB
    private FitnessDAOLocal fitDAO;

    public List<Subscription> showFramedSubscription() {
        return fitDAO.readFramedSubscriptions();
    }

    public List<UserFitness> listFrozenClient() {
        return fitDAO.readFrozenUsers();
    }

    public List<FitnessGroup> listGroups() {
        return fitDAO.readAllGroups();
    }

    public FitnessGroup editGroup(FitnessGroup group) {
        return fitDAO.updateGroup(group);
    }

    public void createNewGroup(FitnessGroup group) {
        fitDAO.createGroup(group);
    }

    public void changeGroup(FitnessGroup group, UserFitness user) {
        if (user.getFitnessGroup() != null) {
            FitnessGroup oldGroup = fitDAO.readGroup(user.getFitnessGroup().getIdGroup());
            oldGroup.getUsers().remove(user);
        }
        user.setFitnessGroup(group);
        group.getUsers().add(user);
        user.setFrozen(false);
        fitDAO.updateGroup(group);
        fitDAO.updateUser(user);
    }

    public void deleteGroup(FitnessGroup group) {
        fitDAO.deleteGroup(group);
    }

    public void confirmSubscription(int idSub) {
        Subscription sub = fitDAO.readSubscription(idSub);
        sub.setStatus("Подтвержден");
    }

    public void rejectSubscription(int idSub) {
        Subscription sub = fitDAO.readSubscription(idSub);
        UserFitness user = sub.getUser();
        user.setSubscription(null);
        sub.setUser(null);
        fitDAO.deleteSubscription(sub);
        fitDAO.updateUser(user);
    }

    public FitnessGroup readGroup(int idGroup) {
        return fitDAO.readGroup(idGroup);
    }

    public UserFitness readUser(int idUser) {
        return fitDAO.readUser(idUser);
    }

    public List<String> getTypesTraining() {
        return fitDAO.getTypesTraining();
    }

    public List<FitnessGroup> readGroupsByTypeTraining(String typeTraining) {
        return fitDAO.readGroupsByTypeTraining(typeTraining);
    }

    public List<UserFitness> readUsersByGroup(int idGroup) {
        return fitDAO.readUsersByGroup(idGroup);
    }

    public void freezeClient(int idClient){
        UserFitness userFitness = fitDAO.readUser(idClient);
        userFitness.setFrozen(true);
        userFitness.setFitnessGroup(null);
    }
}
