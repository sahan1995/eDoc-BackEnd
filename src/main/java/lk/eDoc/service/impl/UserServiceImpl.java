package lk.eDoc.service.impl;

import lk.eDoc.dto.UserDTO;
import lk.eDoc.entity.User;
import lk.eDoc.repository.UserRepository;
import lk.eDoc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Override
    public boolean saveUser(String userName, UserDTO userDTO) {
        if (!userName.equals(userDTO.getUname())) {
            throw new RuntimeException("Not Same");
        } else {
            String enCodePassword = encoder.encode(userDTO.getPassword());
            User user = new User(userDTO.getUname(), enCodePassword, userDTO.getRole(), userDTO.getID());
            userRepo.save(user);
            return true;
        }
    }

    @Override
    public boolean updateUser(String userName, UserDTO userDTO) {
        if (!userName.equals(userDTO.getUname())) {
            throw new RuntimeException("ID's Are Not Same");
        } else {
            User user = new User(userDTO.getUname(), userDTO.getPassword(), userDTO.getRole(), userDTO.getID());
            userRepo.save(user);
            return true;
        }
    }

    @Override
    public UserDTO findByID(String userName) {

        Optional<User> userOpt = userRepo.findById(userName);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            return new UserDTO(user.getUname(), user.getPassword(), user.getRole(), user.getID());
        } else {
            return null;
        }

    }

    @Override
    public boolean isExists(String userName) {
        if (userRepo.findById(userName).isPresent()) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Map<String,String> signIn(String userName, String password) {

        Map<String, String> userDetails = new HashMap<>();
        Optional<User> userOpt = userRepo.findById(userName);
        if(userOpt.isPresent()){
            User user = userOpt.get();
            boolean isMatch = encoder.matches(password,user.getPassword());

            if(isMatch){

                userDetails.put("role",user.getRole());
                userDetails.put("useID",user.getID());
                return  userDetails;

            }else{
               return userDetails;
            }
        }else {
            return userDetails;
        }

    }
}
