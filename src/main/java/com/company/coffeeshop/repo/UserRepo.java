package com.company.coffeeshop.repo;

import com.company.coffeeshop.entity.user.User;
import io.jmix.core.repository.JmixDataRepository;
import liquibase.pro.packaged.U;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepo extends JmixDataRepository<User, UUID> {

    Optional<User> findByUsername(String username);
}
