package com.testdvdrental.dvdrental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "film_actor")
public class FilmActorEntity implements Serializable {

    @EmbeddedId
    private FilmActorId id;

    @Column(name = "last_update")
    private Date lastUpdate;


}
