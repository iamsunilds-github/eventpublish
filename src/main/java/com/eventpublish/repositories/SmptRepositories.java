package com.eventpublish.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventpublish.model.SmtpCredentials;

@Repository
public interface SmptRepositories extends JpaRepository<SmtpCredentials, Integer> {

	SmtpCredentials findBySmtpSource(String smtpSource);

}
