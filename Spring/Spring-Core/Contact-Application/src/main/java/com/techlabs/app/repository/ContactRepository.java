package com.techlabs.app.repository;

import com.techlabs.app.entity.Contact;
import com.techlabs.app.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    Page<Contact> findByUser(User user, Pageable pageable);


    Optional<Contact> findContactByIdAndIsActive(Long id, Boolean active);
}
