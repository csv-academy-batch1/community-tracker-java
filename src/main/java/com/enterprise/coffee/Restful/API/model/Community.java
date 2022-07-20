package com.enterprise.coffee.Restful.API.model;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@Entity
@Table(name = "community")
@NoArgsConstructor
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "communityid", nullable = false)
    private Long communityId;

    @Column(name = "communityname", nullable = false)
    private String communityName;

    @Column(name = "communityicon")
    private String communityIcon;

    @Column(name = "communitymgrid")
    private Long communityMgrid;

    @Column(name = "communitydesc")
    private String communityDesc;

    @Column(name = "isactive")
    private Boolean isActive;

    //++++++++++++++++++++++++++++++++ FOR CONTROLLER TESTING ++++++++++++++++++++++++++++++++++++
    public Community(String communityName, Long communityMgrid, String communityDesc){
        this.communityName = communityName;
        this.communityMgrid = communityMgrid;
        this.communityDesc = communityDesc;
    }

}
