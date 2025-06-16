package cat.itacademy.s04.t02.n01.S04T02N01.controller;

import cat.itacademy.s04.t02.n01.S04T02N01.model.entities.Fruit;
import cat.itacademy.s04.t02.n01.S04T02N01.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/fruit")
public class FruitController {

    @Autowired
    private FruitService fruitService;

    @PostMapping("/add")
    public ResponseEntity<Fruit> addFruit(@RequestBody Fruit fruit) {
        Fruit addedFruit = fruitService.addFruit(fruit);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedFruit);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Fruit> updateFruit(@PathVariable int id, @RequestBody Fruit fruit) {
        Fruit existingFruit = fruitService.getFruitById(id);

        if (existingFruit != null) {
            fruit.setId(id);
            Fruit updatedFruit = fruitService.updateFruit(fruit);
            return ResponseEntity.ok(updatedFruit);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFruit(@PathVariable int id) {
        Fruit fruit = fruitService.getFruitById(id);

        if (fruit != null) {
            fruitService.deleteFruit(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Fruit> getOneFruit(@PathVariable int id) {
        Fruit fruit = fruitService.getFruitById(id);

        if (fruit != null) {
            return ResponseEntity.ok(fruit);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAllFruits() {
        List<Fruit> fruits = (List<Fruit>) fruitService.getAllFruit();
        return fruits.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(fruits);
    }

}