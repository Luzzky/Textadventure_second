package Enemies;

import java.util.List;
import java.util.function.Supplier;
import java.util.Random;


public class EnemieAdministration {

    private Random rand = new Random();

    private final List<Supplier<Enemie>> gegnerListe = List.of(
            Zombie::new,
            Golem::new
    );

    public Enemie getRandomEnemie() {
        int index = rand.nextInt(gegnerListe.size());
        return gegnerListe.get(index).get();
    }
}
