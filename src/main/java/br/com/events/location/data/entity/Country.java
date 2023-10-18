package br.com.events.location.data.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "country")
public class Country {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "iso2")
    private String iso2;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
    private List<State> states;
}
