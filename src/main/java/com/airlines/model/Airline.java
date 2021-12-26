package com.airlines.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@Table(name = "airlines")

public class Airline {
     @Id
     @Column(name="airlineid")
     @GeneratedValue(generator = "airline_seq",strategy = GenerationType.AUTO)
     @SequenceGenerator(name="airline_seq",sequenceName = "airline_seq",initialValue =1,allocationSize = 1)
     private Integer airlineId;

     @Column(length=18)
     private String name;

     @Enumerated(EnumType.STRING)
     private Category category;

     @OneToOne(cascade = CascadeType.ALL)
     @JoinColumn(name="details_id")  //(one Ailines one details)
     private Details details;

     @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
     @JoinColumn(name="airlineid")
     private Set<Flight> flight;

     @ManyToMany(fetch = FetchType.EAGER)
     //@JsonIgnore
     @JoinTable(name = "airlines_packages",
             joinColumns = @JoinColumn(name = "airlineid"),
             inverseJoinColumns = @JoinColumn(name = "packageid"))
     private Set<TourPackages> packages;

     /**
      *
      * @param name
      * @param category
      * @param details
      * @param flight
      * @param packages
      */
     public Airline(String name, Category category, Details details, Set<Flight> flight, Set<TourPackages> packages) {
          this.name = name;
          this.category = category;
          this.details = details;
          this.flight = flight;
          this.packages = packages;
     }

}