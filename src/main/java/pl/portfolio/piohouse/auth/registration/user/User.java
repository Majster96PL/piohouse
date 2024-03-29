package pl.portfolio.piohouse.auth.registration.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.portfolio.piohouse.auth.registration.role.Role;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;
    @NotBlank(message = "Firstname required!")
    @Size(max = 20)
    private String firstname;
    @NotBlank(message = "Lastname required!")
    @Size(max = 20)
    private String lastname;
    @NotBlank(message = "Username required!")
    @Size(max = 60)
    private String username;
    @NotBlank(message = "Email required!")
    @Size(max = 60)
    private String email;
    @NotBlank(message = "Password required!")
    @Size(max = 120)
    private String password;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;
}
