package com.mytest.elasticdemo.repository;

import com.mytest.elasticdemo.domain.ApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Long> {

    List<ApplicationEntity> findAll();

    ApplicationEntity findOneById(Long id);
}
