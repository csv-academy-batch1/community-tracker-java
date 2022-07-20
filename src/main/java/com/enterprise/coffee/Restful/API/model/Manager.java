package com.enterprise.coffee.Restful.API.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "communityadminandmanager")
public class Manager {
    @Id
    @Column(name = "communityadminandmanagerid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "communityadminandmanagername", nullable = false)
    private String communityMgrName;

    @Column(name = "csvemail", nullable = false)
    private String email;

    @Column(name = "passkey", nullable = false)
    private String passKey;

    @Column(name = "roletype")
    private String roleType;

    @Column(name = "isactive", nullable = false)
    private Boolean isActive;

}
