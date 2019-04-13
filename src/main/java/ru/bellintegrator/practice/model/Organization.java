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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    private String name;
    private String fullName;
    private String inn;
    private String kpp;
    private String address;
    private String phone;
    private boolean isActive;

}
