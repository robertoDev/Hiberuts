package it.blackcat.hiberuts.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: homeuser
 * Date: 18/10/13
 * Time: 16.40
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="film")
public class Film {
    private Integer filmId;

    @javax.persistence.Column(name = "film_id")
    @Id
    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    private String title;

    @javax.persistence.Column(name = "title")
    @Basic
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String description;

    @javax.persistence.Column(name = "description")
    @Basic
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private Date releaseYear;

    @javax.persistence.Column(name = "release_year")
    @Basic
    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    private Byte languageId;

    @javax.persistence.Column(name = "language_id")
    @Basic
    public Byte getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Byte languageId) {
        this.languageId = languageId;
    }

    private Byte originalLanguageId;

    @javax.persistence.Column(name = "original_language_id")
    @Basic
    public Byte getOriginalLanguageId() {
        return originalLanguageId;
    }

    public void setOriginalLanguageId(Byte originalLanguageId) {
        this.originalLanguageId = originalLanguageId;
    }

    private byte rentalDuration;

    @javax.persistence.Column(name = "rental_duration")
    @Basic
    public byte getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(byte rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    private BigDecimal rentalRate;

    @javax.persistence.Column(name = "rental_rate")
    @Basic
    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    private short length;

    @javax.persistence.Column(name = "length")
    @Basic
    public short getLength() {
        return length;
    }

    public void setLength(short length) {
        this.length = length;
    }

    private BigDecimal replacementCost;

    @javax.persistence.Column(name = "replacement_cost")
    @Basic
    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    private String rating;

    @javax.persistence.Column(name = "rating")
    @Basic
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    private String specialFeatures;

    @javax.persistence.Column(name = "special_features")
    @Basic
    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
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

        Film film = (Film) o;

        if (filmId != film.filmId) return false;
        if (length != film.length) return false;
        if (rentalDuration != film.rentalDuration) return false;
        if (description != null ? !description.equals(film.description) : film.description != null) return false;
        if (languageId != null ? !languageId.equals(film.languageId) : film.languageId != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(film.lastUpdate) : film.lastUpdate != null) return false;
        if (originalLanguageId != null ? !originalLanguageId.equals(film.originalLanguageId) : film.originalLanguageId != null)
            return false;
        if (rating != null ? !rating.equals(film.rating) : film.rating != null) return false;
        if (releaseYear != null ? !releaseYear.equals(film.releaseYear) : film.releaseYear != null) return false;
        if (rentalRate != null ? !rentalRate.equals(film.rentalRate) : film.rentalRate != null) return false;
        if (replacementCost != null ? !replacementCost.equals(film.replacementCost) : film.replacementCost != null)
            return false;
        if (specialFeatures != null ? !specialFeatures.equals(film.specialFeatures) : film.specialFeatures != null)
            return false;
        if (title != null ? !title.equals(film.title) : film.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) filmId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (releaseYear != null ? releaseYear.hashCode() : 0);
        result = 31 * result + (languageId != null ? languageId.hashCode() : 0);
        result = 31 * result + (originalLanguageId != null ? originalLanguageId.hashCode() : 0);
        result = 31 * result + (int) rentalDuration;
        result = 31 * result + (rentalRate != null ? rentalRate.hashCode() : 0);
        result = 31 * result + (int) length;
        result = 31 * result + (replacementCost != null ? replacementCost.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (specialFeatures != null ? specialFeatures.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }

//-------------------------

    private Set<Actor> actors = new HashSet<Actor>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="film_actor",
                joinColumns={@JoinColumn(name="film_id")},
                inverseJoinColumns={@JoinColumn(name="actor_id")})
    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

//-------------------------

    private Set<ExtRental> rentals= new HashSet<ExtRental>(0);

    @OneToMany(mappedBy = "film")
    public Set<ExtRental> getRentals() {
        return rentals;
    }

    public void setRentals(Set<ExtRental> rentals) {
        this.rentals = rentals;
    }
}
