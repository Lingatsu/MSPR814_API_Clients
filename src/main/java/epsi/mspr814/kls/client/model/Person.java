package epsi.mspr814.kls.client.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue
    private UUID uuid;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String password;

}