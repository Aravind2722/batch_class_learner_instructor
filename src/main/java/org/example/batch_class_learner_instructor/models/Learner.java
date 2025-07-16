package org.example.batch_class_learner_instructor.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
public class Learner {
    @Id
    private UUID id;

    private String name;

    private String email;

    @ManyToOne
    private Batch currentBatch;

    @ManyToMany
    @JoinTable(
            name = "LEARNERS_PREVIOUS_BATCHES",
            joinColumns = @JoinColumn(name = "LEARNER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PREVIOUS_BATCH_ID")
    )
    private Set<Batch> previousBatches=new HashSet<>();
}
