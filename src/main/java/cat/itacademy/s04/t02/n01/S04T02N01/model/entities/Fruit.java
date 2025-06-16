package cat.itacademy.s04.t02.n01.S04T02N01.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fruit {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;
    private int kilosAmount;

    public Fruit() {
    }

    public Fruit(String name, int kilosAmount) {
        this.name = name;
        this.kilosAmount = kilosAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKilosAmount() {
        return kilosAmount;
    }

    public void setKilosAmount(int kilosAmount) {
        this.kilosAmount = kilosAmount;
    }

    @Override
    public String toString() {
        return "Fruta con id: " + id +
                ", de nombre '" + name + '\'' +
                ", y " + kilosAmount + " kilos";
    }
}