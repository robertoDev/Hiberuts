package it.blackcat.hiberuts.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: homeuser
 * Date: 19/10/13
 * Time: 11.02
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="ext_rental")
public class ExtRental {
    private Integer rentalId;

    @Id
    @javax.persistence.Column(name = "rental_id")
    @Basic
    public Integer getRentalId() {
        return rentalId;
    }

    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }

    private Timestamp rentalDate;

    @javax.persistence.Column(name = "rental_date")
    @Basic
    public Timestamp getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Timestamp rentalDate) {
        this.rentalDate = rentalDate;
    }
/*
    private Short customerId;

    @javax.persistence.Column(name = "customer_id")
    @Basic
    public Short getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Short customerId) {
        this.customerId = customerId;
    }

    private Short filmId;

    @javax.persistence.Column(name = "film_id")
    @Basic
    public Short getFilmId() {
        return filmId;
    }

    public void setFilmId(Short filmId) {
        this.filmId = filmId;
    }
*/
    private Byte storeId;

    @javax.persistence.Column(name = "store_id")
    @Basic
    public Byte getStoreId() {
        return storeId;
    }

    public void setStoreId(Byte storeId) {
        this.storeId = storeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExtRental extRental = (ExtRental) o;

        //if (customerId != null ? !customerId.equals(extRental.customerId) : extRental.customerId != null) return false;
        //if (filmId != null ? !filmId.equals(extRental.filmId) : extRental.filmId != null) return false;
        if (rentalDate != null ? !rentalDate.equals(extRental.rentalDate) : extRental.rentalDate != null) return false;
        if (rentalId != null ? !rentalId.equals(extRental.rentalId) : extRental.rentalId != null) return false;
        if (storeId != null ? !storeId.equals(extRental.storeId) : extRental.storeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rentalId != null ? rentalId.hashCode() : 0;
        result = 31 * result + (rentalDate != null ? rentalDate.hashCode() : 0);
        //result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        //result = 31 * result + (filmId != null ? filmId.hashCode() : 0);
        result = 31 * result + (storeId != null ? storeId.hashCode() : 0);
        return result;
    }

    private Film film;

    @ManyToOne
    @JoinColumn(name="film_id")
    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    private Customer customer;

    @ManyToOne
    @JoinColumn(name="customer_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
