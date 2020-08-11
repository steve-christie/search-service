package com.christie.searchservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "person")
public class Person {
    @Id
    private String id;

    @Field
    private String name;

    @Field
    private String address;

    @Field
    private int order;

    @Field
    private List<String> foods;

    @Field
    private List<Pet> pets;

    @Field
    private List<String> tags;
}
