package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import models.BankClient;
import models.Transfer;

@Stateless
public class BankDAO implements BankDAOLocal {

    @PersistenceContext(unitName = "Fitness2-ejbPUBank")
    private EntityManager em;

    @Override
    public void createBankClient(BankClient bankClient) {
        em.persist(bankClient);
    }

    @Override
    public BankClient readBankClient(long numberCard) {
        try {
            Query query = em.createQuery("SELECT b FROM BankClient b WHERE b.numberCard=?1", BankClient.class);
            query.setParameter(1, numberCard);
            return (BankClient) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public BankClient updateBankClient(BankClient bankClient) {
        return em.merge(bankClient);
    }

    @Override
    public void createTransfer(Transfer transfer) {
        em.persist(transfer);
    }
}
