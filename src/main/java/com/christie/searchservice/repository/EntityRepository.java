package com.christie.searchservice.repository;

import com.christie.searchservice.domain.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EntityRepository extends ElasticsearchRepository<Person, String> {
}
