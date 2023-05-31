package com.berkaygulen.akbankweatherApp.user;
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
    @NotBlank
    private String firstName;
    private String lastName;
    private String userName;
    @Email
    private String email;
    private String password;
}
