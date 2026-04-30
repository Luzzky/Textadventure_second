package Enemies;

import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

public class RandomCollection<Enemie> {
    private final NavigableMap<Double, Enemie> map = new TreeMap<Double, Enemie>();
    private final Random random = new Random();
    private double total = 0;

    public RandomCollection<Enemie> add(double weight, Enemie result) {
        if (weight <= 0) return this;
        total += weight;
        map.put(total, result);
        return this;
    }

    public Enemie next() {
        double value = random.nextDouble() * total;
        return map.higherEntry(value).getValue();
    }
}
