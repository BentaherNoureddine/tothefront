package com.noureddine.commonlibrary.model;




import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_admin")
public class AppAdmin extends User {



    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "admin_organisation",joinColumns = @JoinColumn(name = "app_admin_id"),
            inverseJoinColumns =@JoinColumn(name = "organisation_id") )
    private Set<Organisation> organisations;

    @Embedded
    private Profile profile;

}
