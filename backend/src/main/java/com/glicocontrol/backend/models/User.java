package com.glicocontrol.backend.models;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_users")
public class User {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private int age;
        private double weight;
        private double height;

        @Column(name = "medications_in_use")
        private String medicationsInUse; // Ex: Insulina, Metformina

        private LocalDateTime createdAt;

        @PrePersist
        public void prePersist() {
            this.createdAt = LocalDateTime.now();
        }

        // Construtores
        public User() {}

        // Getters e Setters
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }

        public double getWeight() { return weight; }
        public void setWeight(double weight) { this.weight = weight; }

        public double getHeight() { return height; }
        public void setHeight(double height) { this.height = height; }

        public String getMedicationsInUse() { return medicationsInUse; }
        public void setMedicationsInUse(String medicationsInUse) { this.medicationsInUse = medicationsInUse; }

        public LocalDateTime getCreatedAt() { return createdAt; }
    }

