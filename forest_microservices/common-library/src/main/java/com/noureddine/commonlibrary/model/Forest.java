package com.noureddine.commonlibrary.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "forest")
public class Forest {

    @Id
    @GeneratedValue

    private long id;

    private String name;

    @OneToMany(mappedBy = "forest", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Report> reports = new ArrayList<>();
}
