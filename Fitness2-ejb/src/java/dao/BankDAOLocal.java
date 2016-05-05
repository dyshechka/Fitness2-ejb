package dao;

import javax.ejb.Local;
import models.BankClient;
import models.Transfer;

@Local
public interface BankDAOLocal {
    void createBankClient(BankClient bankClient);
    BankClient readBankClient(long numberCard);
    BankClient updateBankClient(BankClient bankClient);

    void createTransfer(Transfer iae);
}
