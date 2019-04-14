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
    @Column(name ="code")
    private Long code;

    @Column(name = "name")
    private String name;

    public Countries() {
    }

    public Countries(String name) {
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "countries", cascade = CascadeType.ALL,  orphanRemoval=true)
    private Set<Person> persons;

    public void addPerson(Person person)
    {
        person.setCountries(this);
        persons.add(person);
    }
    public void removePerson(Person person)
    {
        persons.remove(person);
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
