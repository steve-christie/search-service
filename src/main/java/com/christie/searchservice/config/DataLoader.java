package com.christie.searchservice.config;

import com.christie.searchservice.domain.Person;
import com.christie.searchservice.domain.Pet;
import com.christie.searchservice.domain.PetType;
import com.christie.searchservice.repository.EntityRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


@Service
@RequiredArgsConstructor
public class DataLoader {

    private final EntityRepository entityRepository;
    private AtomicInteger count = new AtomicInteger(0);

    public void loadSampleData(int numberToGenerate) {
        Faker faker = new Faker();
        List<Person> entities = new ArrayList<>();
        while (entities.size() < numberToGenerate) {
            Person person = Person.builder()
                    .name(faker.name().fullName())
                    .address(faker.address().streetAddress(true))
                    .order(count.incrementAndGet())
                    .foods(List.of(faker.food().spice(), faker.food().ingredient()))
                    .build();
            generateRandomPets(person, faker);
            populateTags(person);
            entities.add(person);
        }

        entityRepository.saveAll(entities);
    }

    private void populateTags(Person person) {
        List<String> tags = new ArrayList<>();
        person.getPets().stream().map(Pet::getName).forEach(tags::add);
        tags.add(person.getName());
        person.setTags(tags);
    }

    private void generateRandomPets(Person person, Faker faker) {
        int numberOfPets = getNumberInRange(0, 10);
        List<Pet> pets = new ArrayList<>();
        for (int i = 0; i < numberOfPets; i++) {
            Pet pet = Pet.builder().type(PetType.values()[getNumberInRange(0, 5)]).name(faker.pokemon().name()).age(getNumberInRange(0, 100)).build();
            pets.add(pet);
        }
        person.setPets(pets);
    }

    private int getNumberInRange(int min, int max) {
        return new Random().ints(min, max).findFirst().orElse(0);
    }

}
