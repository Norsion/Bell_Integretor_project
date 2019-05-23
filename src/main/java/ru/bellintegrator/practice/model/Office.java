package ru.bellintegrator.practice.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    public Office(@NotEmpty Long organizationId, @Size(max = 50) @NotEmpty(message = "name cannot be null") String name, @Size(max = 50) @NotEmpty(message = "address cannot be null") String address, @Size(max = 50) @NotNull(message = "phone cannot be null") String phone, @NotNull(message = "isActive cannot be null") boolean isActive) {
    }

    public Office(Organization organizationId, String name, String address, String phone, boolean isActive)
    {
        this.organizationId = organizationId;
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
    private Organization organizationId;

    public Organization getOrganization() {
        return organizationId;
    }

    public void setOrganization(Organization organizationId) {
        this.organizationId = organizationId;
    }

    @OneToMany(mappedBy = "officeId", cascade = CascadeType.ALL,  orphanRemoval=true)
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
