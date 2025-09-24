package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

class ShopRepositoryTest {
    ShopRepository repo = new ShopRepository();
    Product banan = new Product(1, "banan", 25);
    Product milk = new Product(2, "milk", 40);
    Product bread = new Product(3, "bread", 6);
    Product orange = new Product(4, "orange", 125);
    NotFoundException exp = new NotFoundException("fggfgf");


    @BeforeEach
    public void setup() {
        repo.add(banan);
        repo.add(milk);
        repo.add(bread);
        repo.add(orange);
    }

    @Test
    void shouldRemove() {
        repo.remove(2);
        Product[] expected = {banan, milk, orange};

        Assertions.assertArrayEquals(expected, repo.findAll());


    }

    @Test
    void notShouldRemove() {

        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(5));


    }
}