package ru.bellintegrator.practice.model;


import javax.persistence.*;

@Entity(name = "Person")
@Table(name="person")
public class Person {
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

    @Column(name = "firstName", length = 50, nullable = false)
    private String firstName;

    @Column(name = "secondName", length = 50, nullable = false)
    private String secondName;

    @Column(name = "middleName", length = 50, nullable = false)
    private String middleName;

    @Column(name = "position", length = 50, nullable = false)
    private String position;

    @Column(name = "phone", length = 50, nullable = false)
    private String phone;

    @Column(name = "isIdentified")
    private boolean isIdentified;

    public Person() {
    }

    public Person(Office officeId, String firstName, String secondName, String middleName, String position, String phone,  boolean isIdentified)
    {
        this.officeId = officeId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.phone = phone;
        this.isIdentified = isIdentified;

    }

    public Long getId() {
        return id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddletName() {
        return middleName;
    }

    public void setMiddletName(String middletName) {
        this.middleName = middletName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isIdentified() {
        return isIdentified;
    }

    public void setIdentified(boolean isIdentified) {
        this.isIdentified = isIdentified;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id", nullable = false)
    private Office officeId;

    public Office getOffice() {
        return officeId;
    }

    public void setOffice(Office officeId) {
        this.officeId = officeId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "counties_id", nullable = false)
    private Countries countriesId;

    public Countries getCountries() {
        return countriesId;
    }

    public void setCountries(Countries countriesId) {
        this.countriesId = countriesId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "docNumber", nullable = false)
    private Document document;

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
