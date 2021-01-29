package com.krishna.onlinelibrary.repository;


import com.krishna.onlinelibrary.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    /*
        Find the user by email address
     */
    Optional<AppUser> findByEmail(String email);
}
