package dao;

import java.util.List;
import javax.ejb.Local;
import models.FitnessGroup;
import models.UserRole;
import models.Subscription;
import models.UserFitness;
import models.Visit;

@Local
public interface FitnessDAOLocal {

    void createUser(UserFitness user);
    UserFitness readUser(int idUser);
    List<UserFitness> readAllUsers();
    List<UserFitness> readFrozenUsers();
    UserFitness updateUser(UserFitness user);
    void deleteUser(UserFitness user);
    UserFitness readUserByLogin(String login);
    List<UserFitness> readUsersByGroup(int idGroup);
    
    UserRole readRole(int idRole);
    UserRole readRoleByName (String nameRole);
    List<UserRole> readAllRoles();
    List<UserFitness> readTrainers();

    void createGroup(FitnessGroup group);
    FitnessGroup readGroup(int idGroup);
    List<FitnessGroup> readAllGroups();
    List<FitnessGroup> readGroupsByTypeTraining(String typeTraining);
    FitnessGroup updateGroup(FitnessGroup group);
    void deleteGroup(FitnessGroup group);
    List<Visit> getUserVisits(int idUser);

    void createSubscription(Subscription subscription);
    Subscription readSubscription(int idSubscription);
    List<Subscription> readAllSubscriptions();
    List<Subscription> readFramedSubscriptions();
    Subscription updateSubscription(Subscription subscription);
    void deleteSubscription(Subscription subscription);
    
    List<String> getTypesTraining();

}
