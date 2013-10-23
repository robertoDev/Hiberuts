package it.blackcat.hiberuts.model;

import org.hibernate.Criteria;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: homeuser
 * Date: 10/10/13
 * Time: 20.00
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="actor")
public class Actor {
    private Integer actorId;

    @javax.persistence.Column(name = "actor_id")
    @Id
    @GeneratedValue
    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    private String firstName;

    @javax.persistence.Column(name = "first_name")
    @Basic
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String lastName;

    @javax.persistence.Column(name = "last_name")
    @Basic
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private Timestamp lastUpdate;

    @javax.persistence.Column(name = "last_update")
    @Basic
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Actor actor = (Actor) o;

        if (actorId != actor.actorId) return false;
        if (firstName != null ? !firstName.equals(actor.firstName) : actor.firstName != null) return false;
        if (lastName != null ? !lastName.equals(actor.lastName) : actor.lastName != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(actor.lastUpdate) : actor.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) actorId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }



    private Set<Film> films = new HashSet<Film>();

    @ManyToMany(mappedBy="actors")
    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

}
