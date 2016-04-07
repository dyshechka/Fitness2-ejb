package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class FitnessGroup implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGroup;
    
    @NotNull
    @Size(max = 40, min = 10)
    private String nameGroup;
    
    @OneToMany
    private List<UserVisits> usersVisits;
    
    @NotNull
    @Size(max = 40, min = 7)
    private String typeTraining;
    
    @OneToMany(mappedBy = "fitnessGroup")
    private List<UserFitness> users;

    //Удалить в последующем эти три строки
    public FitnessGroup() {
        usersVisits = new ArrayList<>();
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public List<UserVisits> getUsersVisits() {
        return usersVisits;
    }

    public void setUsersVisits(List<UserVisits> usersVisits) {
        this.usersVisits = usersVisits;
    }
    
    
    public String getTypeTraining() {
        return typeTraining;
    }

    public void setTypeTraining(String typeTraining) {
        this.typeTraining = typeTraining;
    }

    public List<UserFitness> getUsers() {
        return users;
    }

    public void setUsers(List<UserFitness> users) {
        this.users = users;
    }
    
}
