package services;

import dao.FitnessDAOLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import models.UserFitness;
import models.UserRole;

@LocalBean
@Stateless
public class AdminService {

    @EJB
    private FitnessDAOLocal fitDAO;

    public void createNewUser(UserFitness user) {
        fitDAO.createUser(user);
    }

    public void deleteUser(UserFitness user) {
        fitDAO.deleteUser(user);
    }

    public UserFitness editRole(UserFitness user, int idRole) {
        UserRole role = fitDAO.readRole(idRole);
        user.setRole(role);
        return fitDAO.updateUser(user);
    }

    public UserFitness readUser(int idUser){
        return fitDAO.readUser(idUser);
    }

    public UserRole readRole(int idRole) {
        return fitDAO.readRole(idRole);
    }
    
    public List<UserFitness> getAllUsers() {
        return fitDAO.readAllUsers();
    }
    
    public List<UserRole> getAllRoles() {
        return fitDAO.readAllRoles();
    }
}
