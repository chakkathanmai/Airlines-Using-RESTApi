package com.airlines.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name ="packages")
public class TourPackages {
    @Id
    @GeneratedValue(generator = "package_seq",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="package_seq",sequenceName = "package_seq",initialValue =501,allocationSize = 1)
    @Column(name="packageid",length = 20)
    private Integer packageId;

    @Column(name = "packagename",length = 20)
    private String packageName;

    @Column(length = 20)
    private int cost;

    @Column(length = 20)
    private String source;

    @Column(length = 20)
    private  String destination;


    @ManyToMany(mappedBy = "packages")
    @JsonIgnore
    private Set<Airline> airlines;

    /**
     *
     * @param packageName
     * @param cost
     * @param source
     * @param destination
     */

    public TourPackages(String packageName, int cost, String source, String destination) {
        this.packageName = packageName;
        this.cost = cost;
        this.source = source;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "TourPackages{" +
                "packageName='" + packageName + '\'' +
                ", cost=" + cost +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
