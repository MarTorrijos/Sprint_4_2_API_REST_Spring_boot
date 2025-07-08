package cat.itacademy.s04.t02.n01.S04T02N01.service;

import cat.itacademy.s04.t02.n01.S04T02N01.model.entities.Fruit;
import cat.itacademy.s04.t02.n01.S04T02N01.model.exceptions.ResourceNotFoundException;
import cat.itacademy.s04.t02.n01.S04T02N01.repository.FruitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FruitService {

    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public Fruit addFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    public Fruit updateFruit(int id, Fruit fruit) {
        Fruit existingFruit = fruitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fruit with ID " + id + " not found"));

        fruit.setId(existingFruit.getId());
        return fruitRepository.save(fruit);
    }

    public void deleteFruit(int id) {
        if (!fruitRepository.existsById(id)) {
            throw new ResourceNotFoundException("Fruit with ID " + id + " not found");
        }
        fruitRepository.deleteById(id);
    }

    public Fruit getFruitById(int id) {
        return fruitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fruit with ID " + id + " not found"));
    }

    public List<Fruit> getAllFruit() {
        return StreamSupport.stream(fruitRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

}