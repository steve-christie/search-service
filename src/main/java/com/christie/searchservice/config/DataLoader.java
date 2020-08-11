package com.christie.searchservice.config;

import com.christie.searchservice.domain.Person;
import com.christie.searchservice.repository.EntityRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@Service
@RequiredArgsConstructor
public class DataLoader {

    private final EntityRepository entityRepository;
    private AtomicInteger count = new AtomicInteger(0);

    public void loadSampleData() {
        Faker faker = new Faker();
        List<Person> entities = new ArrayList<>();
        while (entities.size() < 100) {
            entities.add(Person.builder()
                    .name(faker.name().fullName())
                    .address(faker.address().streetAddress(true))
                    .order(count.incrementAndGet())
                    .foods(List.of(faker.food().spice(), faker.food().ingredient()))
                    .build());
        }

        entityRepository.saveAll(entities);
    }

}
