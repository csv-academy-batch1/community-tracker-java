package com.community.Community.Management.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "community")
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "communityid", nullable = false)
    private Long communityId;

    @Column(name = "communityname", nullable = false, unique = true)
    private String communityName;

    @Column(name = "communityicon")
    private String communityIcon;

    @Column(name = "communitymgrid")
    private int communityManagerId;

    @Column(name = "communitydesc")
    private String communityDesc;

    @Column(name = "isactive", nullable = false)
    private boolean isActive = true;

}
