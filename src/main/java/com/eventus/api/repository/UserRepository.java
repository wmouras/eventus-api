package com.eventus.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eventus.api.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String login);

}