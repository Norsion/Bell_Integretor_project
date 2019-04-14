package ru.bellintegrator.practice.model;

import javax.persistence.*;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Document")
@Table(name = "doc")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="code")
    private Long code;

    @Basic
    @Column(name="docDate")
    private Date docDate;

    @Column(name="docs_id")
    private long docs_id;

    public Document() {
    }

    public Document(Date docDate, long docs_id) {
        this.docDate = docDate;
        this.docs_id = docs_id;
    }

    public Long getCode() {
        return code;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public long getDocs_id() {
        return docs_id;
    }

    public void setDocs_id(long docs_id) {
        this.docs_id = docs_id;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="docs_id")
    private TypeOfDocument typeOfDocument;

    public TypeOfDocument getTypeOfDocument() {
        return typeOfDocument;
    }

    public void setTypeOfDocument(TypeOfDocument typeOfDocument) {
        this.typeOfDocument = typeOfDocument;
    }

    @OneToMany(mappedBy = "doc", cascade = CascadeType.ALL,  orphanRemoval=true)
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
