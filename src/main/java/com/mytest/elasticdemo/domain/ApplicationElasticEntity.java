package com.mytest.elasticdemo.domain;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "myindexname", type = "application")
public class ApplicationElasticEntity {

    public static final String TABLE_NAME = "APPLICATION";

    private Long id;
    private String name;
    private String description;

    public ApplicationElasticEntity(ApplicationEntity applicationEntity) {
        this.id = applicationEntity.getId();
        this.name = applicationEntity.getName();
        this.description = applicationEntity.getDescription();
    }

    public ApplicationElasticEntity() {
    }
}
