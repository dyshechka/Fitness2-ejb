package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class UserVisits implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUserVisits;

    @ManyToOne
    @NotNull
    private UserFitness user;

    @OneToMany
    @NotNull
    private List<Visit> visits;

    //TO-DO:
    public UserVisits() {
        visits = new ArrayList<>();
    }

    public int getIdUserVisits() {
        return idUserVisits;
    }

    public void setIdUserVisits(int idUserVisits) {
        this.idUserVisits = idUserVisits;
    }

    public UserFitness getUser() {
        return user;
    }

    public void setUser(UserFitness user) {
        this.user = user;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

}
