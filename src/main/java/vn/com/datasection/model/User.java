package vn.com.datasection.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name = "user")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String address;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date brithday;

	private String email;

	private boolean enable;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@Column(name = "expire_time")
	private Date expireTime;

	private String name;

	private String password;

	private String phone;

	// bi-directional many-to-one association to UserTopic
	@OneToMany(mappedBy = "user")
	private List<UserTopic> userTopics;

	public User() {
	}

	public User(String name, String email, String password, String phone, String address, Date brithday) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.brithday = brithday;
	};

	public User(String name, String email, String password, String phone, String address, Date brithday,
			Date expireTime, boolean enable) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.brithday = brithday;
		this.expireTime = expireTime;
		this.enable = enable;
	};
	
	public User(String email, String password, boolean enable) {
		this.email=email;
		this.password=password;
		this.enable=enable;
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBrithday() {
		return this.brithday;
	}

	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getEnable() {
		return this.enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Date getExpireTime() {
		return this.expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<UserTopic> getUserTopics() {
		return this.userTopics;
	}

	public void setUserTopics(List<UserTopic> userTopics) {
		this.userTopics = userTopics;
	}

	public UserTopic addUserTopics(UserTopic userTopics) {
		getUserTopics().add(userTopics);
		userTopics.setUser(this);

		return userTopics;
	}

	public UserTopic removeUserTopics(UserTopic userTopics) {
		getUserTopics().remove(userTopics);
		userTopics.setUser(null);

		return userTopics;
	}

}