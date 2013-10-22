package it.blackcat.hiberuts;

import com.opensymphony.xwork2.ActionSupport;
import it.blackcat.hiberuts.model.Actor;
import it.blackcat.hiberuts.model.Film;
import org.hibernate.Criteria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: homeuser
 * Date: 12/10/13
 * Time: 11.21
 * To change this template use File | Settings | File Templates.
 */
public class ActorsAction extends ActionSupport {
    private List<Actor> actors;
    private int filmId;
    private Film film;

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }



    public String execute() {

        EntityManagerFactory emfInstance = EMF.get();
        EntityManager entityManager = emfInstance.createEntityManager();

        if(filmId!=0){
            film=entityManager.find(Film.class,filmId);
            actors=  new ArrayList<Actor>(film.getActors());
        }else{
            Query query=entityManager.createQuery("from Actor order by firstName");
            actors = query.getResultList();
        }
        return SUCCESS;
    }
}