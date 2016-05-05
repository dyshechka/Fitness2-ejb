package beans;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import models.FitnessGroup;
import models.Subscription;
import models.UserFitness;
import services.TrainerService;

@Named
@SessionScoped
public class TrainerController implements Serializable {

    @EJB
    private TrainerService ts;

    private FitnessGroup group;
    private UserFitness user;
    private FitnessGroup currGroup;
    private int idGroup;

    public FitnessGroup getGroup() {
        return group;
    }

    public void setGroup(FitnessGroup group) {
        this.group = group;
    }

    public UserFitness getUser() {
        return user;
    }

    public void setUser(UserFitness user) {
        this.user = user;
    }

    public FitnessGroup getCurrGroup() {
        return currGroup;
    }

    public void setCurrGroup(FitnessGroup currGroup) {
        this.currGroup = currGroup;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }
    
    public List<Subscription> showFramedSubscription() {
        return ts.showFramedSubscription();
    }

    public List<UserFitness> listFrozenClient() {
        return ts.listFrozenClient();
    }

    public List<FitnessGroup> listGroups() {
        return ts.listGroups();
    }

    public String editGroup(int idGroup) {
        group = ts.readGroup(idGroup);
        return "editGroup";
    }

    public String editGroupConfirm() {
        ts.editGroup(group);
        showMessage("Группа " + group.getNameGroup() +" изменена успешно");
        group = new FitnessGroup();
        return "trainer";
    }

    public String createNewGroup() {
        group = new FitnessGroup();
        return "createGroup";
    }

    public String createNewGroupConfirm() {
        ts.createNewGroup(group);
        showMessage("Группа " + group.getNameGroup() +" создана успешно");
        group = new FitnessGroup();
        return "trainer";
    }

    public String changeGroup(int idUser) {
        user = ts.readUser(idUser);
        return "changeGroup";
    }

    public String changeGroupConfirm() {
        ts.changeGroup(ts.readGroup(idGroup), user);
        showMessage("Группа клиенту изменилась");
        return "listFrozen";
    }

    public String deleteGroup(int idGroup) {
        group = ts.readGroup(idGroup);
        return "deleteGroup";
    }

    public String deleteGroupConfirm() {
        ts.deleteGroup(group);
        showMessage("Группа удалена");
        return "trainer";
    }

    public String detailsGroup(int idGroup) {
        currGroup = ts.readGroup(idGroup);
        return "detailsGroup";
    }

    public void confirmSubscription(int idSub) {
        showMessage("Абонемент подтвержден");
        ts.confirmSubscription(idSub);
    }

    public void rejectSubscription(int idSub) {
        showMessage("Абонемент отклонен");
        ts.rejectSubscription(idSub);
    }

    public List<String> getTypesTraining() {
        return ts.getTypesTraining();
    }

    public List<FitnessGroup> readGroupsByTypeTraining() {
        return ts.readGroupsByTypeTraining(user.getSubscription().getTypeTraining());
    }

    public List<UserFitness> readUsersByGroup() {
        return ts.readUsersByGroup(currGroup.getIdGroup());
    }

    public void freezeClient(int idClient) {
        ts.freezeClient(idClient);
    }
    
    private void showMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(message));
        context.getExternalContext().getFlash().setKeepMessages(true);
    }
    
}
