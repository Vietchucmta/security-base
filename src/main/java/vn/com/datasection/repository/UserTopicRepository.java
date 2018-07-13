package vn.com.datasection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.com.datasection.model.UserTopic;

public interface UserTopicRepository extends JpaRepository<UserTopic, Integer> {

}
