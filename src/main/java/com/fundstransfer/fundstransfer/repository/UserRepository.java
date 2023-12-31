package com.fundstransfer.fundstransfer.repository;

import com.fundstransfer.fundstransfer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
