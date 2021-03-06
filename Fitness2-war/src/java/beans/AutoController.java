package beans;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import models.UserData;
import models.UserFitness;
import services.AutoService;

@Named
@RequestScoped
public class AutoController {

    @EJB
    private AutoService as;

    private UserData userData;

    public AutoController() {
        userData = new UserData();
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public String login() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            request.login(userData.getLogin(), userData.getPassword());
            UserFitness userFitness = as.getCurrUser();
            switch (userFitness.getRole().getNameRole()) {
                case "Администратор":
                    return "admin";
                case "Тренер":
                    return "trainer";
                case "Клиент":
                    return "client";
                default: 
                    return "index";
            }
        } catch (ServletException e) {
            showMessage("Вы пытались..");
            return "index";
        }
    }

    public String logout() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            request.logout();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
            session.invalidate();
            return "index";
        } catch (ServletException e){
            showMessage("Упс... Что-то пошло не так");
            return "index";
        }
    }

    public String register() {
        try {
            as.registerUser(userData.getFio(), userData.getDateOfBirth(), userData.getEmail(), userData.getTelephone(), userData.getLogin(), userData.getPassword());
            showMessage("Пользователь зарегистрирован в систему успешно");
            return "index";
        } catch (Exception e) {
            showMessage("Кто-то криворучка -___-");
            return "register";
        }
    }
    
    private void showMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(message));
        context.getExternalContext().getFlash().setKeepMessages(true);
    }
}
