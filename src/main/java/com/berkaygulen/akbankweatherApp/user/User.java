package com.berkaygulen.akbankweatherApp.user;
import com.berkaygulen.akbankweatherApp.customAnnotation.UniqueUsername;
import com.berkaygulen.akbankweatherApp.general.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "USERS")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(generator = "User", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "User",sequenceName = "USER_ID_SEQ")
    private Long id;

    @Column(name = "FIRST_NAME", length = 100, nullable = false)
    @NotBlank
    private String firstName;

    @Column(name = "LAST_NAME", length = 100, nullable = false)
    private String lastName;

    @Column(name = "USERNAME", length = 50, nullable = false,unique = true)
    private String username;

    @Email
    @Column(name = "EMAIL", length = 50,nullable = false,unique = true)
    private String email;

    @Column(name = "PASSWORD", length = 400, nullable = false)
    private String password;
}
