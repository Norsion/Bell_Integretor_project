package ru.bellintegrator.practice.model;

import javax.persistence.*;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Document")
@Table(name = "document")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @Column(name ="code")
    private Long code;

    @Basic
    @Column(name="docDate")
    private Date docDate;


    public Document() {
    }

    public Document(Date docDate) {
        this.docDate = docDate;
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

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="docs_id", nullable = false)
    private TypeOfDocument typeOfDocument;

    public TypeOfDocument getTypeOfDocument() {
        return typeOfDocument;
    }

    public void setTypeOfDocument(TypeOfDocument typeOfDocument) {
        this.typeOfDocument = typeOfDocument;
    }

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL,  orphanRemoval=true)
    private Set<Person> persons;

    public void addPerson(Person person)
    {
        person.setDocument(this);
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
