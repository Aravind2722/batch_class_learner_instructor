package org.example.batch_class_learner_instructor.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Entity
public class Class {
    @Id
    private UUID id;

    private String topic;

    @ManyToMany
    @JoinTable(
            name = "BATCHES_CLASSES",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "batch_id")
    )
    private Set<Batch> batches;

    @ManyToOne
    private Instructor currentInstructor;
}
