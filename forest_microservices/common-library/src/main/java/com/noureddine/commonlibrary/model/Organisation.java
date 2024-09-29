package com.noureddine.commonlibrary.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "organisation")
public class Organisation {

    @Id
    @GeneratedValue
    private Long id;

    private String name;


    @ManyToMany(mappedBy = "organisations")
    private Set<AppAdmin> appAdmins;

    @ManyToMany(mappedBy = "organisations")
    private Set<Supervisor> supervisors;




}
