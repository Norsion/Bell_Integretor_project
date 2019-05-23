package ru.bellintegrator.practice.model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Countries")
@Table(name="countries")
public class Countries
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @Column(name ="code")
    private Long code;

    @Column(name = "name")
    private String name;

    public Countries() {
    }

    public Countries(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "countriesId", cascade = CascadeType.ALL,  orphanRemoval=true)
    private Set<Person> persons;

    public void addPerson(Person person)
    {
        getPersons().add(person);
        person.setCountries(this);

    }
    public void removePerson(Person person)
    {
        getPersons().remove(person);
        person.setCountries(null);
    }

    public Set<Person> getPersons() {
        if(persons == null)
        {
            persons = new HashSet<>();
        }
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

}
