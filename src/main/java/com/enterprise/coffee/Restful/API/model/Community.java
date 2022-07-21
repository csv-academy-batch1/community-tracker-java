package com.enterprise.coffee.Restful.API.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("CommunityId")
    @Column(name = "communityid", nullable = false)
    private Long communityId;
<<<<<<< HEAD

=======
>>>>>>> fdade3b8756a36682f2a6720223c549f39d010ac
    @JsonProperty("CommunityName")
    @Column(name = "communityname", nullable = false)
    private String communityName;

    @JsonProperty("Communityicon")
    @Column(name = "communityicon")
    private String communityIcon;
<<<<<<< HEAD

    @JsonProperty("CommunityMgrid")
    @Column(name = "communitymgrid")
    private Long communityMgrid;

=======
    @JsonProperty("CommunityMgrid")
    @Column(name = "communitymgrid")
    private Long communityMgrid;
>>>>>>> fdade3b8756a36682f2a6720223c549f39d010ac
    @JsonProperty("Description")
    @Column(name = "communitydesc")
    private String description;

    @JsonProperty("Active")
    @Column(name = "isactive")
    private Boolean isActive;

}
