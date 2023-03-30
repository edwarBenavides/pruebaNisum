package com.pruebaNisum.pruebaNisum.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "\"user\"")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(length = 36, nullable = false, updatable = false)
    private String id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;

    @Column
    private String token;

    @Column
    private boolean isactive;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Phone> phones;

    @PrePersist
    public void prePersist() {
        this.dateCreated = new Date();
        this.dateModified = new Date();
        this.lastLogin = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        this.dateModified = new Date();
        this.lastLogin = new Date();
    }

}
