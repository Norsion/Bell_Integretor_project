package ru.bellintegrator.practice.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Office")
@Table(name="office")
public class Office {
    /**
     * поле индификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "address", length = 50, nullable = false)
    private String address;

    @Column(name = "phone", length = 50, nullable = false)
    private String phone;

    @Column(name = "isActive")
    private boolean isActive;

    public Office() {
    }

    public Office(String name, String address, String phone, boolean isActive)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @OneToMany(mappedBy = "office", cascade = CascadeType.ALL,  orphanRemoval=true)
    private Set<Person> persons;

    public void addPerson(Person person)
    {
        getPersons().add(person);
        person.setOffice(this);

    }
    public void removePerson(Person person)
    {
       getPersons().remove(person);
       person.setOffice(null);
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
