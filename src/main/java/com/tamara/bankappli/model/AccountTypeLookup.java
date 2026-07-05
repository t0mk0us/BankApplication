package com.tamara.bankappli.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "ACCOUNT_TYPE")
public class AccountTypeLookup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // Using NVARCHAR to match your clean database normalization layout!
    @Column(name = "name", nullable = false, unique = true, length = 30)
    private String name; // Stores "SAVING", "CHECKING", "MORTGAGE", "RRSP", etc.

    @Column(name = "description", length = 100)
    private String description; // Optional: e.g., "Standard Individual Savings Account"

    // Default constructor required by JPA/Hibernate
    public AccountTypeLookup() {}

    public AccountTypeLookup(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTypeLookup that = (AccountTypeLookup) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "AccountTypeLookup [id=" + id + ", name=" + name + "]";
    }
}
