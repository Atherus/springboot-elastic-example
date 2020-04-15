package com.mytest.elasticdemo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = ApplicationEntity.TABLE_NAME)
public class ApplicationEntity {

    public static final String TABLE_NAME = "APPLICATION";

    @Id
    private Long id;
    private String name;
    private String description;

}
