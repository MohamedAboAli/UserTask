package dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.User;

public class UserDTO {
	
// it is use to transfer Data
	
	    private Long id;
	    private String name;
	 
	    private Set<String> fansIDS=new HashSet<>();
	    private Set<String> myLikes=new HashSet<>();
	    
	    
		public Set<String> getMyLikes() {
			return myLikes;
		}
		public void setMyLikes(Set<String> myLikes) {
			this.myLikes = myLikes;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Set<String> getFansIDS() {
			return fansIDS;
		}
		public void setFansIDS(Set<String> fansIDS) {
			this.fansIDS = fansIDS;
		}
		
	    
	    

}
