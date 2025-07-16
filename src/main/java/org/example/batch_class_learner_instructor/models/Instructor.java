package org.example.batch_class_learner_instructor.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
public class Instructor {
    @Id
    private UUID id;

    @ManyToMany
    @JoinTable(
            name = "INSTRUCTORS_BATCHES",
            joinColumns = @JoinColumn(name = "instructor_id"),
            inverseJoinColumns = @JoinColumn(name = "batch_id")
    )
    private Set<Batch> batches=new HashSet<>();

    private String name;

    private String email;
}
