package com.community.Community.Management.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "communityadminandmanager")
public class CommunityManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "communityadminandmanagerid", nullable = false)
    private int communityManagerId;

    @Column(name = "communityadminandmanagername")
    private String communityManagerName;

    @Column(name = "csvemail",nullable = false)
    private String csvEmail;

    @Column(name = "passkey")
    private String passKey;

    @Column(name = "roletype", nullable = false)
    private String roleType;

    @Column(name = "isactive")
    private Boolean isActive = true;


}
