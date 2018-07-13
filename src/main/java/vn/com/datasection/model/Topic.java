package vn.com.datasection.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the topic database table.
 * 
 */
@Entity
@Table(name="topic")
@NamedQuery(name="Topic.findAll", query="SELECT t FROM Topic t")
public class Topic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@Column(name="create_time")
	private Date createTime;

	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@Column(name="last_updated")
	private Date lastUpdated;

	private boolean status;

	private String title;

	//bi-directional many-to-one association to UserTopic
	@OneToMany(mappedBy="topic")
	private List<UserTopic> userTopics;

	public Topic() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<UserTopic> getUserTopics() {
		return this.userTopics;
	}

	public void setUserTopics(List<UserTopic> userTopics) {
		this.userTopics = userTopics;
	}

	public UserTopic addUserTopics(UserTopic userTopics) {
		getUserTopics().add(userTopics);
		userTopics.setTopic(this);

		return userTopics;
	}

	public UserTopic removeUserTopics(UserTopic userTopics) {
		getUserTopics().remove(userTopics);
		userTopics.setTopic(null);

		return userTopics;
	}

}