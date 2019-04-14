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
    @Column(name = "version", nullable = false)
    private Integer version;

    @Column(name = "officeId", nullable = false)
    private Long officeId;

    @Column(name = "firstName", length = 50, nullable = false)
    private String firstName;

    @Column(name = "secondName", length = 50, nullable = false)
    private String secondName;

    @Column(name = "middleName", length = 50, nullable = false)
    private String middletName;

    @Column(name = "position", length = 50, nullable = false)
    private String position;

    @Column(name = "phone", length = 50, nullable = false)
    private String phone;

    @Column(name = "docNumber", nullable = false)
    private Long docNumber;

    @Column(name = "counties_id", nullable = false)
    private Long counties_id;

    @Column(name = "isIdentified")
    private boolean isIdentified;

    public Person() {
    }

    public Person(Integer version, Long officeId, String firstName, String secondName, String middletName, String position, String phone, Long docNumber, Long counties_id, boolean isIdentified, Office office)
    {
        this.version = version;
        this.officeId = officeId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middletName = middletName;
        this.position = position;
        this.phone = phone;
        this.docNumber = docNumber;
        this.counties_id = counties_id;
        this.isIdentified = isIdentified;
        this.office = office;
    }

    public Long getId() {
        return id;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
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
        return middletName;
    }

    public void setMiddletName(String middletName) {
        this.middletName = middletName;
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

    public Long getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(Long docNumber) {
        this.docNumber = docNumber;
    }

    public Long getCounties_id() {
        return counties_id;
    }

    public void setCounties_id(Long counties_id) {
        this.counties_id = counties_id;
    }

    public boolean isIdentified() {
        return isIdentified;
    }

    public void setIdentified(boolean identified) {
        isIdentified = identified;
    }

    @ManyToOne
    @JoinColumn(name = "officeId", nullable = false)
    private Office office;

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    @ManyToOne
    @JoinColumn(name = "counties_id", nullable = false)
    private Countries countries;

    public Countries getCountries() {
        return countries;
    }

    public void setCountries(Countries countries) {
        this.countries = countries;
    }

    @ManyToOne
    @JoinColumn(name = "docNumber", nullable = false)
    private Document document;

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
