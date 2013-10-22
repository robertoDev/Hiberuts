package it.blackcat.hiberuts;

import com.opensymphony.xwork2.ActionSupport;
import it.blackcat.hiberuts.model.Actor;
import it.blackcat.hiberuts.model.Customer;
import it.blackcat.hiberuts.model.ExtRental;
import it.blackcat.hiberuts.model.Film;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: homeuser
 * Date: 12/10/13
 * Time: 11.21
 * To change this template use File | Settings | File Templates.
 */
public class RentalsAction extends ActionSupport {

    private List<ExtRental> rentals;
    private int filmId;
    private Film film;

    private int customerId;
    private Customer customer;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<ExtRental> getRentals() {
        return rentals;
    }

    public void setRentals(List<ExtRental> rentals) {
        this.rentals = rentals;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String execute() {

            EntityManagerFactory emfInstance = EMF.get();
            EntityManager entityManager = emfInstance.createEntityManager();

            if(filmId!=0){
                film=entityManager.find(Film.class,filmId);
                rentals=  new ArrayList<ExtRental>(film.getRentals());
            }else if(customerId!=0){
                customer=entityManager.find(Customer.class,customerId);
                rentals=  new ArrayList<ExtRental>(customer.getRentals());
            }else{
                Query query=entityManager.createQuery("from ExtRental");
                rentals = query.getResultList();
            }
            return SUCCESS;
        }
}