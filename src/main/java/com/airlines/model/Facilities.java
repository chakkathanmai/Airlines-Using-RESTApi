package com.airlines.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Facilities {

    @Id
    @GeneratedValue(generator = "facilities_seq",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "facilities_seq",sequenceName = "facilities_sequence",initialValue = 301,allocationSize = 1)
    @Column(length = 20,name = "facilityid")
    private  Integer facilityId;

    @Column(name = "facilityname")
    @Enumerated(EnumType.STRING)
    private FlightFacility facilityName;
    private  String description;

    public Facilities(FlightFacility facilityName, String description) {
        this.facilityName = facilityName;
        this.description = description;
    }
}
