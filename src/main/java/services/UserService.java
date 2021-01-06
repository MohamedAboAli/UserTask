package services;

import java.util.List;

import dto.UserDTO;

public interface UserService {
    public List<UserDTO> getAllUsers();
    public void updateUser(Long userID, String likedUserName);
}
