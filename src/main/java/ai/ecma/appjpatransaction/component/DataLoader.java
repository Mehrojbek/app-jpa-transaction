package ai.ecma.appjpatransaction.component;

import ai.ecma.appjpatransaction.repository.UserRepository;
import ai.ecma.appjpatransaction.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final UserRepository userRepository;


    @Override
    public void run(String... args) {
        User user = userRepository.findFirstByIdNotNull().orElse(new User(
                null,
                "User",
                1000D,
                null
        ));
        userRepository.save(user);
    }
}
