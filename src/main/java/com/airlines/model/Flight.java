package com.airlines.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "flights")
public class Flight {
    @Id
    @Column(name="flightid",length = 18)
    @GeneratedValue(generator = "flight_seq",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="flight_seq",sequenceName = "flight_seq",initialValue =401,allocationSize = 1)
    private Integer flightId;

    @Column(length = 18)
    private String name;

    @Column(length = 18)
    private String source;

    @Column(length = 18)
    private String destination;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    //this is the foreign key will be added to amenities table
    @JoinColumn(name="flightid")  //prevent creating a new junction/common table
    private List<Facilities> facilities;


    public Flight(String name, String source, String destination, List<Facilities> facilities) {
        this.name = name;
        this.source = source;
        this.destination = destination;
        this.facilities = facilities;
    }


}
