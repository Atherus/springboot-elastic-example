package com.mytest.elasticdemo.repository;

import com.mytest.elasticdemo.domain.ApplicationElasticEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationElasticRepository extends ElasticsearchRepository<ApplicationElasticEntity, Long> {

    List<ApplicationElasticEntity> findAll();

    ApplicationElasticEntity findOneById(Long id);
}
