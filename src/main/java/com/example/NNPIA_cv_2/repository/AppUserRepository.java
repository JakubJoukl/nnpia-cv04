package com.example.NNPIA_cv_2.repository;

import com.example.NNPIA_cv_2.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

//@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

    public List<AppUser> findByActive(boolean active);

    public Optional<AppUser> findById(int id);

    @Query("SELECT u FROM AppUser u inner JOIN u.userRoles r where r.id = ?1")
    public List<AppUser> findUsersByRole(int roleId);
}
