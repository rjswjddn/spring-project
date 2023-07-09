package hellospring.hello.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import hellospring.hello.repository.UserRepository;
import hellospring.hello.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(Long id){
        User user = userRepository.getById(id);
        return user;
    }

    public void registerUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(Long id) { userRepository.deleteById(id);}

    public void updateUser(User user) {
        userRepository.save(user);
    }
}
