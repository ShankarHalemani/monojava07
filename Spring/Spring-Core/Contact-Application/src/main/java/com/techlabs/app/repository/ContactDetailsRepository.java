package com.techlabs.app.repository;

import com.techlabs.app.entity.Contact;
import com.techlabs.app.entity.ContactDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactDetailsRepository extends JpaRepository<ContactDetails, Long> {
    Page<ContactDetails> findByContact(Contact contact, Pageable pageable);

}
