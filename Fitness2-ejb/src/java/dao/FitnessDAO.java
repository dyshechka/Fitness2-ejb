package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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
        Query query = em.createQuery("SELECT u FROM UserFitness u");
        return query.getResultList();
    }

    @Override
    public List<UserFitness> readFrozenUsers() {
        Query query;
        query = em.createQuery("SELECT u FROM UserFitness u WHERE (u.frozen=TRUE) AND (u.role.nameRole='Клиент') AND (u.subscription <> NULL)");
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
        Query query = em.createQuery("SELECT r FROM UserRole r");
        return query.getResultList();
    }

    @Override
    public List<UserFitness> readTrainers() {
        Query query = em.createQuery("SELECT t FROM UserFitness t WHERE t.role.nameRole=?1", UserFitness.class);
        query.setParameter(1, "тренер");
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
        Query query = em.createQuery("SELECT g FROM FitnessGroup g", FitnessGroup.class);
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
        Query query = em.createQuery("SELECT v FROM UserVisits v WHERE v.user.idUser=?1", UserVisits.class);
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
        Query query = em.createQuery("SELECT s FROM Subscription s WHERE s.status=?1", Subscription.class);
        query.setParameter(1, "Оформлен");
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
}
