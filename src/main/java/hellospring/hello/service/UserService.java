package hellospring.hello.service;

import hellospring.hello.dto.UserDTO;
import hellospring.hello.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import hellospring.hello.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public List<UserEntity> getUsers(){
        return userRepository.findAll();
    }

    public UserDTO getUser(Long id){
        UserEntity userEntity = userRepository.getById(id);
        UserDTO userdto = new UserDTO(userEntity);
        return userdto;
    }

    public void registerUser(UserDTO userdto){
        UserEntity userEntity = userdto.toEntity();
        userRepository.save(userEntity);
    }

    public void deleteUser(Long id) { userRepository.deleteById(id);}

    public void updateUser(Long id, UserDTO userdto) {
        UserEntity userEntity = userRepository.getById(id);

        userEntity.setUser_name(userdto.getUser_name());
        userEntity.setUser_id(userdto.getUser_id());
        userEntity.setMemo(userdto.getMemo());

        log.info("user = {}", userEntity);
        userRepository.save(userEntity);
    }
}
