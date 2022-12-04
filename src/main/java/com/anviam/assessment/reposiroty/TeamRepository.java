package com.anviam.assessment.reposiroty;
import org.springframework.data.jpa.repository.JpaRepository;
import com.anviam.assessment.modal.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
