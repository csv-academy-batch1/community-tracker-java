package com.enterprise.coffee.Restful.API.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "community")
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "communityid", nullable = false)
    private Long communityId;

    @Column(name = "communityname", nullable = false)
    private String communityName;

    @Column(name = "communityicon", nullable = true)
    private String communityIcon;

    @Column(name = "communitymgrid", nullable = true)
    private Long communityMgrId;

    @Column(name = "communitydesc", nullable = true)
    private String communityDesc;

    @Column(name = "isactive")
    private boolean status = true;

}
