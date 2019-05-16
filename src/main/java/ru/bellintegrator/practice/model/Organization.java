package ru.bellintegrator.practice.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Организация
 */

@Entity(name = "Organization")
@Table(name="organization")
public class Organization {
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

    @Column(name = "fullName", length = 50, nullable = false)
    private String fullName;

    @Column(name = "inn", length = 50, nullable = false)
    private String inn;

    @Column(name = "kpp", length = 50, nullable = false)
    private String kpp;

    @Column(name = "address", length = 50, nullable = false)
    private String address;

    @Column(name = "phone", length = 50, nullable = false)
    private String phone;

    @Column(name = "isActive")
    private boolean isActive;

    public  Organization() {

    }

    public Organization(String name, String fullName, String inn, String kpp, String address, String phone, boolean isActive)
        {
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
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

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL,  orphanRemoval=true)
    private Set<Office>  offices;

    public void addOffice(Office office)
    {
        getOffices().add(office);
        office.setOrganization(this);

    }
    public void removeOffice(Office office)
    {
        getOffices().remove(office);
        office.setOrganization(null);
    }

    public Set<Office> getOffices() {
        if(offices == null)
        {
            offices = new HashSet<>();
        }
        return offices;
    }

    public void setOffices(Set<Office> offices) {
        this.offices = offices;
    }
}
