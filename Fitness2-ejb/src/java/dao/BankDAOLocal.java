package dao;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import models.BankClient;
import models.IncomeAndExpenses;
import models.OrderClient;

@Local
public interface BankDAOLocal {

    void createBankClient(BankClient bankClient);
    BankClient readBankClient(int id);
    List<BankClient> readAllBankClients();
    BankClient updateBankClient(BankClient bankClient);
    void deleteBankClient(BankClient bankClient);

    void createOrder(OrderClient order);
    OrderClient readOrder(int id);
    List<OrderClient> readAllOrders();
    OrderClient updateOrder(OrderClient order);
    void deleteOrder(OrderClient order);

    void createIncomeAndExpenses(IncomeAndExpenses iae);
    IncomeAndExpenses readIncomeAndExpenses(int id);
    List<IncomeAndExpenses> readAllIncomeAndExpenses();
    IncomeAndExpenses updateIncomeAndExpenses(IncomeAndExpenses iae);
    void deleteIncomeAndExpenses(IncomeAndExpenses iae);
}
