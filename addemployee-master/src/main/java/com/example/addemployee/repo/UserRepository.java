package com.example.addemployee.repo;

import com.example.addemployee.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
