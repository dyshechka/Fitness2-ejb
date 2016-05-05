package services;

import dao.FitnessDAOLocal;
import java.util.Date;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import models.UserFitness;

@Stateless
@LocalBean
public class AutoService {

    @EJB
    private FitnessDAOLocal fitnessDAO;
    
    @Resource
    private SessionContext context;
    
    public UserFitness getCurrUser() {
        return fitnessDAO.readUserByLogin(context.getCallerPrincipal().getName());
    }
    
    public void registerUser(String fio, Date dateOfBirth, String email, int telephone, String login, String password){
        UserFitness user = new UserFitness();
        user.setFullName(fio);
        user.setDateOfBirth(dateOfBirth);
        user.setEmail(email);
        user.setTelephone(telephone);
        user.setLogin(login);
        user.setPassword(password);
        user.setFrozen(true);
        user.setRole(fitnessDAO.readRoleByName("Клиент"));
        fitnessDAO.createUser(user);
    }
}
