package cat.itacademy.s04.t02.n01.S04T02N01.repository;

import cat.itacademy.s04.t02.n01.S04T02N01.model.entities.Fruit;
import org.springframework.data.repository.CrudRepository;

public interface FruitRepository extends CrudRepository<Fruit, Integer> {}