package org.example.batch_class_learner_instructor.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
// pass name in  @Entity, and it doesnt change the table name, rather would change the JPA entity name
//@Entity(name = "Staff")
//
//public class Employee {
//    ...
//}
//Query q = entityManager.createQuery("SELECT s FROM Staff s");

public class Batch {
    @Id
    private UUID id;

    @ManyToMany(mappedBy = "batches")
    private List<Instructor> instructors;

    private String name;

    @OneToMany(mappedBy = "currentBatch")
    private Set<Learner> learners = new HashSet<>();

    @ManyToMany(mappedBy = "batches")
    private Set<Class> classes;
}
