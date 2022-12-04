package com.anviam.assessment.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import com.anviam.assessment.modal.Agent;

public interface AgentRepository extends JpaRepository<Agent, Long> {

}
