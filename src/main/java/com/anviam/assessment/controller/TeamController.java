package com.anviam.assessment.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;
import javax.crypto.spec.OAEPParameterSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.anviam.assessment.modal.Agent;
import com.anviam.assessment.modal.Team;
import com.anviam.assessment.reposiroty.TeamRepository;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    TeamRepository teamRepository;

    @PostMapping
    public Team createTeam(@RequestBody Team team){
        return teamRepository.save(team);
    }
    @GetMapping
    public List<Team> findTeam(){
        return teamRepository.findAll();
    }
    @GetMapping(value = "/{id}")
    public Optional<Team> findTeam(@PathVariable Long id){
        return teamRepository.findById(id);
    }
    @PutMapping(value = "/{id}/agent")
    public Team updateTeam(@PathVariable Long id,@RequestBody Team team){
        Team team1 = null;
        try {
             team1= teamRepository.findById(id).get();
             if (Objects.nonNull(team1.getAgent())){
                 Logger.getLogger("Agent is available for the team");
             }else {
                 team1.setAgent(team.getAgent());
             }
        }catch (Exception e){
            e.printStackTrace();
        }
        return teamRepository.save(team1);
    }
}
