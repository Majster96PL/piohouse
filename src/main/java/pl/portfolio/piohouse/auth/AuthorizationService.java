package pl.portfolio.piohouse.auth;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.portfolio.piohouse.auth.registration.role.Role;
import pl.portfolio.piohouse.auth.registration.role.RoleEnum;
import pl.portfolio.piohouse.auth.registration.user.User;
import pl.portfolio.piohouse.auth.registration.user.UserService;

@Service
@AllArgsConstructor
public class AuthorizationService {

    private UserService userService;
    private Role role;

    private void registerUser(User user){
        userService.getNewUser(new User(
                user.getFirstname(),
                user.getLastname(),
                user.getUsername(),
                user.getPassword(),
                user.getRoles(RoleEnum.USER)
        ));

    }
}
