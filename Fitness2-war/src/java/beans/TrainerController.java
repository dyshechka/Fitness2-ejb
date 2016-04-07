package beans;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
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

    public List<Subscription> showFramedSubscription() {
        return ts.showFramedSubscription();
    }

    public List<UserFitness> listFrozenClient() {
        return ts.listFrozenClient();
    }
    
    public List<FitnessGroup> listGroups(){
        return ts.listGroups();
    }

    public String editGroup(int idGroup) {
        group = ts.readGroup(idGroup);
        return "editGroup";
    }

    public String editGroupConfirm() {
        ts.editGroup(group);
        group = new FitnessGroup();
        return "trainer";
    }

    public String createNewGroup() {
        group = new FitnessGroup();
        return "createGroup";
    }

    public String createNewGroupConfirm() {
        ts.createNewGroup(group);
        group = new FitnessGroup();
        return "trainer";
    }

    public String changeGroup(int idUser) {
        user = ts.fitDAO.readUser(idUser);
        return "changeGroup";
    }

    public String changeGroupConfirm() {
        ts.changeGroup(group, user);
        return "trainer";
    }

    public String deleteGroup(int idGroup) {
        group = ts.readGroup(idGroup);
        return "deleteGroup";
    }

    public String deleteGroupConfirm() {
        ts.deleteGroup(group);
        return "trainer";
    }

    public String detailsGroup(int idGroup) {
        currGroup = ts.readGroup(idGroup);
        return "detailsGroup";
    }

    public void confirmSubscription(int idSub) {
        ts.confirmSubscription(idSub);
    }

    public void rejectSubscription(int idSub) {
        ts.rejectSubscription(idSub);
    }
}
