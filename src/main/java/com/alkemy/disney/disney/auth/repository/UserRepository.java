package com.alkemy.disney.disney.auth.repository;

import com.alkemy.disney.disney.auth.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long > {
        //TODO le agregue otro parametro con el tipo de ID que necesita JpaRespository
    UserEntity findByUsername(String username);
}
