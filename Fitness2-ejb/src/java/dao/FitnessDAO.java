package dao;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import models.FitnessGroup;
import models.UserRole;
import models.Subscription;
import models.UserFitness;
import models.UserVisits;
import models.Visit;

@Stateless
public class FitnessDAO implements FitnessDAOLocal {

    @PersistenceContext(unitName = "Fitness2-ejbPUFitness")
    private EntityManager em;
    
    private final List<String> typeTraining;

    public FitnessDAO() {
        typeTraining = new ArrayList<>();
        typeTraining.add("Для похудения");
        typeTraining.add("Для набора веса");
        typeTraining.add("Для рельефа");
    }

    @Override
    public List<String> getTypesTraining() {
        return typeTraining;
    }

    @Override
    public void createUser(UserFitness user) {
        em.persist(user);
    }

    @Override
    public UserFitness readUser(int idUser) {
        return em.find(UserFitness.class, idUser);
    }

    @Override
    public List<UserFitness> readAllUsers() {
        Query query = em.createQuery("SELECT u "
                + "FROM UserFitness u", UserFitness.class);
        return query.getResultList();
    }

    @Override
    public List<UserFitness> readFrozenUsers() {
        Query query = em.createQuery("SELECT u "
                + "FROM UserFitness u "
                + "WHERE (u.frozen = true) "
                + "AND (u.role.nameRole = 'Клиент') "
                + "AND (u.subscription.status = 'Оплачен')", UserFitness.class);
        return query.getResultList();
    }

    @Override
    public UserFitness updateUser(UserFitness user) {
        return em.merge(user);
    }

    @Override
    public void deleteUser(UserFitness user) {
        em.remove(em.merge(user));
    }

    @Override
    public List<UserRole> readAllRoles() {
        Query query = em.createQuery("SELECT r FROM UserRole r", UserRole.class);
        return query.getResultList();
    }

    @Override
    public List<UserFitness> readTrainers() {
        Query query = em.createQuery("SELECT t "
                + "FROM UserFitness t "
                + "WHERE t.role.nameRole='Тренер'", UserFitness.class);
        return query.getResultList();
    }

    
    @Override
    public void createGroup(FitnessGroup group) {
        em.persist(group);
    }

    @Override
    public FitnessGroup readGroup(int idGroup) {
        return em.find(FitnessGroup.class, idGroup);
    }

    @Override
    public List<FitnessGroup> readAllGroups() {
        Query query = em.createQuery("SELECT g "
                + "FROM FitnessGroup g", FitnessGroup.class);
        return query.getResultList();
    }

    @Override
    public List<FitnessGroup> readGroupsByTypeTraining(String typeTraining) {
        Query query = em.createQuery("SELECT g "
                + "FROM FitnessGroup g "
                + "WHERE g.typeTraining=?1", FitnessGroup.class);
        query.setParameter(1, typeTraining);
        return query.getResultList();
    }
    
    @Override
    public FitnessGroup updateGroup(FitnessGroup group) {
        return em.merge(group);
    }

    @Override
    public void deleteGroup(FitnessGroup group) {
        em.remove(em.merge(group));
    }

    //dodelat'
    @Override
    public List<Visit> getUserVisits(int idUser) {
        Query query = em.createQuery("SELECT v "
                + "FROM UserVisits v "
                + "WHERE v.user.idUser=?1", UserVisits.class);
        query.setParameter(1, idUser);
        return ((UserVisits) query.getSingleResult()).getVisits();
    }

    @Override
    public void createSubscription(Subscription subscription) {
        em.persist(subscription);
    }

    @Override
    public Subscription readSubscription(int idSubscription) {
        return em.find(Subscription.class, idSubscription);
    }

    @Override
    public List<Subscription> readAllSubscriptions() {
        Query query = em.createQuery("SELECT s FROM Subscription s");
        return query.getResultList();
    }

    @Override
    public List<Subscription> readFramedSubscriptions() {
        Query query = em.createQuery("SELECT s "
                + "FROM Subscription s "
                + "WHERE s.status='Оформлен'", Subscription.class);
        return query.getResultList();
    }

    @Override
    public Subscription updateSubscription(Subscription subscription) {
        return em.merge(subscription);
    }

    @Override
    public void deleteSubscription(Subscription subscription) {
        em.remove(em.merge(subscription));
    }

    @Override
    public UserRole readRole(int idRole) {
        return em.find(UserRole.class, idRole);
    }

    @Override
    public UserFitness readUserByLogin(String login) {
        try {
            Query query = em.createQuery("SELECT u "
                    + "FROM UserFitness u "
                    + "WHERE u.login=?1", UserFitness.class);
            query.setParameter(1, login);
            return (UserFitness) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<UserFitness> readUsersByGroup(int idGroup) {
        Query query = em.createQuery("SELECT u "
                + "FROM UserFitness u "
                + "WHERE u.fitnessGroup.idGroup=?1", UserFitness.class);
        query.setParameter(1, idGroup);
        return query.getResultList();
    }

        @Override
    public UserRole readRoleByName(String nameRole) {
        try {
            Query query = em.createQuery("SELECT u "
                    + "FROM UserRole u "
                    + "WHERE u.nameRole=?1", UserRole.class);
            query.setParameter(1, nameRole);
            return (UserRole) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
