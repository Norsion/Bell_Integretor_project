package ru.bellintegrator.practice.model;

import javax.persistence.*;

@Entity(name = "TypeOfDocument")
@Table(name="docs")
public class TypeOfDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="code")
    private Long code;

    @Column(name = "name")
    private String name;

    public TypeOfDocument() {
    }

    public TypeOfDocument(String name) {
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

    @OneToOne(mappedBy = "docs")
    private Document document;

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
