package pl.portfolio.piohouse.auth.registration.user;

import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
    private static final String MESSAGE_EXCEPTION = "User with username not found!";
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findUserByUsername(username);
        if(optionalUser.isEmpty())
            throw new UsernameNotFoundException(MESSAGE_EXCEPTION);
        else {
            User user = optionalUser.get();
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    user.getRoles()
                            .stream()
                            .map(role -> new SimpleGrantedAuthority(role.toString()))
                            .collect(Collectors.toSet())
            );
        }
    }

    private String getNewUser(User user){
        boolean isUsersExits = userRepository
                .findUserByUsername(user.getUsername())
                .isPresent();
        if (isUsersExits){
            throw new IllegalStateException(MESSAGE_EXCEPTION);
        }
        String password = user.getPassword();
        user.setPassword(password);
        userRepository.save(user);
        return " ";
    }
}
