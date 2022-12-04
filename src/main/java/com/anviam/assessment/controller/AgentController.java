package com.anviam.assessment.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.anviam.assessment.modal.Agent;
import com.anviam.assessment.reposiroty.AgentRepository;

@RestController
@RequestMapping("/agent")
public class AgentController {
    @Autowired
    AgentRepository agentRepository;

    @GetMapping("/{id}")
    public Optional<Agent> findAgentById(@PathVariable("id") Long id) {
       return agentRepository.findById(id);
    }
    @GetMapping("/page-one")
    public List<Agent> findAgent(@RequestParam (value = "offset", required = false, defaultValue = "1") int offset,@RequestParam(value = "limit", required = false, defaultValue = "10") int limit) {
        List<Agent> agentList =agentRepository.findAll();
        Pageable paging = PageRequest.of(
                0, 5, Sort.by("id").ascending());
        Page<Agent> page = agentRepository.findAll(paging);
        return page.getContent();
    }

    @PostMapping
    public ResponseEntity<Agent> createAgent(@RequestBody Agent agent){
        Agent agenta =  agentRepository.save(agent);
        return new ResponseEntity<>(agenta, HttpStatus.OK);
    }

}
