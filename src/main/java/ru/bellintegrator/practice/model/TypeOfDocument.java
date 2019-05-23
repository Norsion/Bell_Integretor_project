package ru.bellintegrator.practice.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "TypeOfDocument")
@Table(name="typeofdocument")
public class TypeOfDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @Column(name ="code")
    private Long code;

    @Column(name = "name")
    private String name;

    public TypeOfDocument() {
    }

    public TypeOfDocument(Long code, String name) {
        this.code = code;
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

    @OneToMany(mappedBy = "typeOfDocument", cascade = CascadeType.ALL,  orphanRemoval=true)
    private Set<Document> document;

    public void addDocument(Document document)
    {
        getDocument().add(document);
        document.setTypeOfDocument(this);

    }
    public void removeDocument(Document document)
    {
        getDocument().remove(document);
        document.setTypeOfDocument(null);
    }

    public Set<Document> getDocument() {
        return document;
    }

    public void setDocument(Set<Document> document) {
        this.document = document;
    }
}
