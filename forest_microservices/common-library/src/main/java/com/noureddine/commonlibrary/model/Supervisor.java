package com.noureddine.commonlibrary.model;




import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "supervisor")
public class Supervisor extends User {


    @ManyToMany
    @JoinTable(name = "supervisor_organisation",joinColumns = @JoinColumn(name = "supervisor_id"),
            inverseJoinColumns =@JoinColumn(name = "organisation_id") )
    private Set<Organisation> organisations;


    @Embedded
    private Profile profile;





}
