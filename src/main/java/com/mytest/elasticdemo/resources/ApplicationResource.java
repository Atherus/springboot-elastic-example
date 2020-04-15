package com.mytest.elasticdemo.resources;

import com.mytest.elasticdemo.domain.ApplicationElasticEntity;
import com.mytest.elasticdemo.domain.ApplicationEntity;
import com.mytest.elasticdemo.repository.ApplicationElasticRepository;
import com.mytest.elasticdemo.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mytest.elasticdemo.resources.ApplicationResource.PATH;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(value = PATH)
@RestController
public class ApplicationResource {

    public final static String PATH = "/application";

    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private ApplicationElasticRepository applicationElasticRepository;

    @GetMapping(path = "", produces = APPLICATION_JSON_VALUE)
    public List<ApplicationEntity> getList() {
        return applicationRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ApplicationEntity getOne(@PathVariable(name = "id") Long id) {
        return applicationRepository.findOneById(id);
    }

    @PostMapping(path = "", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ApplicationEntity save(@RequestBody ApplicationEntity applicationEntity) {
        applicationElasticRepository.save(new ApplicationElasticEntity(applicationEntity));
        return applicationRepository.save(applicationEntity);
    }

    @GetMapping(path = "/elastic", produces = APPLICATION_JSON_VALUE)
    public Iterable<ApplicationElasticEntity> getFromElastic() {
        return applicationElasticRepository.findAll();
    }

}
