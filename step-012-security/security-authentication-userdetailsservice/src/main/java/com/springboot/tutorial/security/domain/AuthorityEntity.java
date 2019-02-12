package com.springboot.tutorial.security.domain;
/**
 * this entity store roles
 */

import org.hibernate.annotations.Type;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

@Entity(name = AuthorityEntity.ENTITY_NAME)
@Table(name = AuthorityEntity.TABLE_NAME, schema = "PUBLIC")
@Component
public class AuthorityEntity implements GrantedAuthority {

    public static final String TABLE_NAME = "AUTHORITY";
    public static final String ENTITY_NAME = "authorityEntity";
    public static final String UNDER_LINE = "_";
    public static final String ID_SUFFIX = UNDER_LINE + "ID";
    public static final String SEQ_SUFFIX = UNDER_LINE + "SEQ";
    public static final String GEN_SUFFIX = UNDER_LINE + "GEN";

    @Id
    @Column(name = TABLE_NAME + ID_SUFFIX, unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME + GEN_SUFFIX)
    @SequenceGenerator(name = TABLE_NAME + GEN_SUFFIX, sequenceName = TABLE_NAME + SEQ_SUFFIX)
    private Long id;

    @Column(name = "AUTHORITY", nullable = false)
    private String authority;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ENABLED")
    @Type(type = "boolean")
    private boolean enabled = true;


    @ManyToMany(mappedBy = "authorities", cascade = CascadeType.ALL)
    private List<UserEntity> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}
