package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// user table that mapped with DB

@Entity
@Table(name = "sa_user", schema = "Loginuser")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long recid;	

	@Column(name = "name")
	private String name;
	
 
	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(name="user_likes",
		joinColumns={@JoinColumn(name="user_id")},
		inverseJoinColumns={@JoinColumn(name="fan_id")})
	private Set<User> fans = new HashSet<User>();

	@ManyToMany(mappedBy="fans")
	private Set<User> myLikes = new HashSet<User>();
	

	public Set<User> getFans() {
		return fans;
	}

	public void setFans(Set<User> fans) {
		this.fans = fans;
	}

	public Set<User> getMyLikes() {
		return myLikes;
	}

	public void setMyLikes(Set<User> myLikes) {
		this.myLikes = myLikes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getRecid() {
		return recid;
	}

	public void setRecid(Long recid) {
		this.recid = recid;
	}



}
