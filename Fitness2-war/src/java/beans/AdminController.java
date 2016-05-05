package beans;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import models.UserFitness;
import models.UserRole;
import services.AdminService;

@Named
@SessionScoped
public class AdminController implements Serializable {

    @EJB
    private AdminService as;

    private static final long serialVersionUID = 1506177076992855056L;

    private UserFitness user;
    private int idRole;

    public UserFitness getUser() {
        return user;
    }

    public void setUser(UserFitness user) {
        this.user = user;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String createNewUser() {
        user = new UserFitness();
        return "createUser";
    }

    public String createNewUserConfirm() {
        UserRole role = as.readRole(idRole);
        user.setRole(role);
        user.setFrozen(true);
        as.createNewUser(user);
        user = new UserFitness();
        showMessage("Пользователь создан");
        return "admin";
    }

    public String deleteUser(int idUser) {
        user = as.readUser(idUser);
        return "deleteUser";
    }

    public String deleteUserConfirm() {
        as.deleteUser(user);
        showMessage("Пользователь удален");
        return "admin";
    }

    public String editRole(int idUser) {
        user = as.readUser(idUser);
        idRole = user.getRole().getIdRole();
        return "editRole";
    }

    public String editRoleConfirm() {
        as.editRole(user, idRole);
        showMessage("Роль пользователя " + user.getFullName() + " изменена");
        return "admin";
    }

    public List<UserFitness> getAllUsers() {
        return as.getAllUsers();
    }

    public List<UserRole> getAllRoles() {
        return as.getAllRoles();
    }
    
    private void showMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(message));
        context.getExternalContext().getFlash().setKeepMessages(true);
    }
}
