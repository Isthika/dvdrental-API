package com.testdvdrental.dvdrental.entity;


import com.testdvdrental.dvdrental.converter.EnumTypePostgreSql;
import com.testdvdrental.dvdrental.converter.YearConvert;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Year;
import java.util.Date;


@Entity
@Table(name = "film")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Integer filmId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "release_year", columnDefinition = "Year")
    @Convert(converter = YearConvert.class)
    private Year releaseYear;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private LanguageEntity languageId;

    @Column(name = "rental_duration")
    private Integer rentalDuration;

    @Column(name = "rental_rate")
    private Double rentalRate;

    @Column(name = "length")
    private Integer length;

    @Column(name = "replacement_cost")
    private Double replacementCost;

    @Column(name = "rating", columnDefinition = "mpaa_rating")
    @Convert(converter = EnumTypePostgreSql.class)
    private Rating rating;

    @Column(name = "last_update")
    private Date lastUpdate;

    @Column(name = "special_features", columnDefinition = "text[]")
    @Type(type = "com.testdvdrental.dvdrental.converter.PostgreSqlStringArrayType")
    private String[] specialFeature;

    @Column(name = "fulltext", columnDefinition = "tsvector")
    private String fullText;
}