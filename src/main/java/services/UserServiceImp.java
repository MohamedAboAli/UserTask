
package services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.UserDTO;
import model.User;
import repository.UserRep;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRep userrep;

	
	@Override
	public List<UserDTO> getAllUsers() {
		List<UserDTO> userDtos = new ArrayList<>();
		List<User> users = userrep.findAll(); // get all users from DB 
		users.stream().forEach(user -> {
			UserDTO userDto = mapEntityToDto(user); // get user data from User Object to UserDTO Object
			userDtos.add(userDto);
		});
		return userDtos;  
	}

	private UserDTO mapEntityToDto(User user) {
		UserDTO responseDto = new UserDTO();
		responseDto.setName(user.getName());
		responseDto.setId(user.getRecid());
		responseDto.setFansIDS(user.getFans().stream().map(User::getName).collect(Collectors.toSet())); // get fans name from User Object and set in FansIDS on UserDTO
		responseDto.setMyLikes(user.getMyLikes().stream().map(User::getName).collect(Collectors.toSet())); // get mylikes name from User Object and set in MyLikes on UserDTO
		return responseDto;
	}

	
	@Override
	public void updateUser(Long userID, String likedUserName) { // used to updated login User likes 
		User likedUser = userrep.findByName(likedUserName); // get liked user 
		User user = userrep.getOne(userID); // get login User
		if(user != likedUser) {  
		user.getMyLikes().add(likedUser);  // add liked User to login User MyLikes set 
		likedUser.getFans().add(user); // add login user to liked User fans set 
	    userrep.save(user);
		}
		
	}

	public UserRep getUserrep() {
		return userrep;
	}

	public void setUserrep(UserRep userrep) {
		this.userrep = userrep;
	}

}
