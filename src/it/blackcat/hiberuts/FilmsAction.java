package it.blackcat.hiberuts;

//import com.google.appengine.api.utils.SystemProperty;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import it.blackcat.hiberuts.model.Actor;
import it.blackcat.hiberuts.model.Film;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.ejb.HibernateEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: homeuser
 * Date: 12/10/13
 * Time: 11.21
 * To change this template use File | Settings | File Templates.
 */
public class FilmsAction implements Action {
    private List<Film> films;
    private int actorId=0;
    Actor actor;

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }



    public String execute() {

        EntityManagerFactory emfInstance = EMF.get();
        EntityManager entityManager = emfInstance.createEntityManager();

/*
        Query query;
        if(actorId==0){
            Actor actor=entityManager.find(Actor.class,actorId);

            actor.
            query = entityManager.createQuery("from Film where stockCode = :code ");
            query.setParameter("code", "7277");

        }else{

        }
*/
        if(actorId!=0){
/*
            HibernateEntityManager hem = entityManager.unwrap(HibernateEntityManager.class);
            Session session = hem.getSession();
            Criteria criteria=session.createCriteria(Film.class);
            Criteria assnCrit = criteria.createCriteria("actor");
            assnCrit.addOrder(Order.asc("title"));
*/
            actor=entityManager.find(Actor.class,actorId);
            films=  new ArrayList<Film>(actor.getFilms());
        }else{
            Query query=entityManager.createQuery("from Film");
            films = query.getResultList();
        }


        return SUCCESS;
    }
}