package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import models.BankClient;
import models.IncomeAndExpenses;
import models.OrderClient;

@Stateless
public class BankDAO implements BankDAOLocal {

    @PersistenceContext(unitName = "Fitness2-ejbPUBank")
    private EntityManager em;

    @Override
    public void createBankClient(BankClient bankClient) {
        em.persist(bankClient);
    }

    @Override
    public BankClient readBankClient(int id) {
        return em.find(BankClient.class, id);
    }

    @Override
    public List<BankClient> readAllBankClients() {
        Query query = em.createQuery("SELECT bc FROM BankClient bc");
        return query.getResultList();
    }

    @Override
    public BankClient updateBankClient(BankClient bankClient) {
        return em.merge(bankClient);
    }

    @Override
    public void deleteBankClient(BankClient bankClient) {
        em.remove(em.merge(bankClient));
    }

    @Override
    public void createOrder(OrderClient order) {
        em.persist(order);
    }

    @Override
    public OrderClient readOrder(int id) {
        return em.find(OrderClient.class, id);
    }

    @Override
    public List<OrderClient> readAllOrders() {
        Query query = em.createQuery("SELECT o FROM OrderClient o");
        return query.getResultList();
    }

    @Override
    public OrderClient updateOrder(OrderClient order) {
        return em.merge(order);
    }

    @Override
    public void deleteOrder(OrderClient order) {
        em.remove(em.merge(order));
    }

    @Override
    public void createIncomeAndExpenses(IncomeAndExpenses iae) {
        em.persist(iae);
    }

    @Override
    public IncomeAndExpenses readIncomeAndExpenses(int id) {
        return em.find(IncomeAndExpenses.class, id);
    }

    @Override
    public List<IncomeAndExpenses> readAllIncomeAndExpenses() {
        Query query = em.createQuery("SELECT iae FROM IncomeAndExpenses iae");
        return query.getResultList();
    }

    @Override
    public IncomeAndExpenses updateIncomeAndExpenses(IncomeAndExpenses iae) {
        return em.merge(iae);
    }

    @Override
    public void deleteIncomeAndExpenses(IncomeAndExpenses iae) {
        em.remove(em.merge(iae));
    }

}
