package ai.ecma.appjpatransaction.controller;

import ai.ecma.appjpatransaction.repository.UserRepository;
import ai.ecma.appjpatransaction.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.UUID;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    private final UserRepository userRepository;
    private final EntityManager entityManager;

    @Transactional
    @GetMapping("/buy-first")
    public String buyFirstProduct() {

        User user = userRepository.findFirstByIdNotNull().orElseThrow();

        log.info("This is first buy api user balance -> {}", user.getBalance());

        if (user.getBalance() > 700) {
            user.setBalance(user.getBalance() - 700);
            user.setName("First buy name");
            try {
                Thread.sleep(10000);
                userRepository.save(user);
            } catch (Exception e) {
                e.printStackTrace();//IT CAN NOT CATCH THIS LINE
            }
        } else
            return "You don't have enough money";

        return "success";
    }

    @Transactional
    @GetMapping("/buy-second")
    public String buySecondProduct() {
        User user = userRepository.findFirstByIdNotNull().orElseThrow();
        log.info("This is second buy api user balance -> {}", user.getBalance());

        if (user.getBalance() > 800) {
            user.setName("Second buy name");
            user.setBalance(user.getBalance() - 800);
            userRepository.save(user);
        } else
            return "You don't have enough money";

        return "success";
    }


    @Transactional
    @GetMapping("/change-user-name")
    public String changeUserName(){
        User user = userRepository.findFirstByIdNotNull().orElseThrow();
        user.setName(UUID.randomUUID().toString());
        userRepository.save(user);
        return "success";
    }


    @Transactional
    @GetMapping("/restore-user-data")
    public String restoreUserData(){
        User user = userRepository.findFirstByIdNotNull().orElseThrow();
        user.setName("User");
        user.setBalance(1000D);
        userRepository.save(user);
        return "success";
    }

}
