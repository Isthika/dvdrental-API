package com.testdvdrental.dvdrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class FilmActorId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "actor_id", referencedColumnName = "actor_id")
    private ActorEntity actorId;

    @ManyToOne
    @JoinColumn(name = "film_id", referencedColumnName = "film_id")
    private FilmEntity filmId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FilmActorId)) return false;
        FilmActorId that = (FilmActorId) o;
        return Objects.equals(getActorId(), that.getActorId()) &&
                Objects.equals(getFilmId(), that.getFilmId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActorId(), getFilmId());
    }


}
