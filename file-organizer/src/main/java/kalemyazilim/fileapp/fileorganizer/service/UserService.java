package kalemyazilim.fileapp.fileorganizer.service;

import kalemyazilim.fileapp.fileorganizer.model.UserModel;
import kalemyazilim.fileapp.fileorganizer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    //Constructor based injection.
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserModel loginUser(String userName, String userPassword){
        if(!userRepository.findByUserNameAndUserPassword(userName, userPassword).isPresent()){
            throw new IllegalStateException("Invalid user login!");
        }
        return userRepository.findByUserNameAndUserPassword(userName, userPassword).orElse(null);
    }
}
