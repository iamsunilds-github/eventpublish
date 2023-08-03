package com.eventpublish.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventpublish.model.EventPlan;

@Repository
public interface EventPlanRepository extends JpaRepository<EventPlan, Long> {

}
