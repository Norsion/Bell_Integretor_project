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

    public Person(String firstName, String secondName, String middleName, String position, String phone,  boolean isIdentified, Office office)
    {
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.phone = phone;
        this.isIdentified = isIdentified;
        this.office = office;
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

    public void setIdentified(boolean identified) {
        isIdentified = identified;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id", nullable = false)
    private Office office;

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "counties_id", nullable = false)
    private Countries countries;

    public Countries getCountries() {
        return countries;
    }

    public void setCountries(Countries countries) {
        this.countries = countries;
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
