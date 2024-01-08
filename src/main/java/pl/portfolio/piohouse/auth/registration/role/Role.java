package pl.portfolio.piohouse.auth.registration.role;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@Table(name = "roles" )
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long role_id;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RoleEnum roleEnum;
}
