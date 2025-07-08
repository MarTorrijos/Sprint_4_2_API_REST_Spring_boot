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
        return ResponseEntity.status(HttpStatus.CREATED).body(fruitService.addFruit(fruit));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Fruit> updateFruit(@PathVariable int id, @RequestBody Fruit fruit) {
        return ResponseEntity.ok(fruitService.updateFruit(id, fruit));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFruit(@PathVariable int id) {
        fruitService.deleteFruit(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Fruit> getOneFruit(@PathVariable int id) {
        return ResponseEntity.ok(fruitService.getFruitById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAllFruits() {
        List<Fruit> fruits = fruitService.getAllFruit();
        return fruits.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(fruits);
    }

}