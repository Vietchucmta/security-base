package vn.com.datasection.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_topic database table.
 * 
 */
@Entity
@Table(name="user_topic")
@NamedQuery(name="UserTopic.findAll", query="SELECT u FROM UserTopic u")
public class UserTopic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private boolean permission;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	//bi-directional many-to-one association to Topic
	@ManyToOne
	@JoinColumn(name="topic_id")
	private Topic topic;

	public UserTopic() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getPermission() {
		return this.permission;
	}

	public void setPermission(boolean permission) {
		this.permission = permission;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Topic getTopic() {
		return this.topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}