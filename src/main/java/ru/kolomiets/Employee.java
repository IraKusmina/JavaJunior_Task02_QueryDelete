package ru.kolomiets;

import java.util.UUID;

@Table(
        name = "users"
)
public class Employee {
    @Column(
            name = "id",
            primaryKey = true
    )
    private UUID id;
    @Column(
            name = "username"
    )
    private String username;
    @Column(
            name = "email"
    )
    private String email;

    public UUID getId() {
        return this.id;
    }

    public Employee(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
