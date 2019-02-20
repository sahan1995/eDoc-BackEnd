package lk.eDoc.service;

import lk.eDoc.dto.UserDTO;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface UserService {

    boolean saveUser(String userName , UserDTO userDTO);

    boolean updateUser(String userName,UserDTO userDTO);

    UserDTO findByID(String userName);

    boolean isExists(String userName);

    Map<String,String> signIn(String userName, String password);
}
