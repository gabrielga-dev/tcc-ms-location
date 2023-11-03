package br.com.events.location.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "state")
public class State {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "iso2")
    private String iso2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "state")
    private List<City> cities;
}
