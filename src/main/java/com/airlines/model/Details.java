package com.airlines.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Details {
    @Id
    @Column(name = "detailsid",length = 18)
    @GeneratedValue(generator = "details_seq",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "details_seq",sequenceName = "details_sequence",initialValue = 201,allocationSize = 1)
    private Integer detailsId;

    @Column(length = 18)
    private double ranking;

    @Column(length = 18)
    private String owner;

    @Column(length = 20,name = "yearoforigin")
    private int yearOfOrigin;

    @Column(length = 18)
    private String country;

    public Details(double ranking, String owner, int yearOfOrigin, String country) {
        this.ranking = ranking;
        this.owner = owner;
        this.yearOfOrigin = yearOfOrigin;
        this.country = country;
    }
}
