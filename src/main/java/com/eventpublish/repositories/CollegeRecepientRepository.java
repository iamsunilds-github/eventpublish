package com.eventpublish.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eventpublish.model.CollegeRecepients;

@Repository
public interface CollegeRecepientRepository extends JpaRepository<CollegeRecepients, Long> {

	@Query(value = "select email from college_recepients", nativeQuery = true)
	List<String> findEmail();

}
