package Enemies;

import java.util.List;
import java.util.function.Supplier;
import java.util.Random;


public class EnemieAdministration {

    private Random rand = new Random();
    private RandomCollection<Enemie> rc = new RandomCollection<>();

    public EnemieAdministration(){
        rc.add(30, new Golem());
        rc.add(70, new Zombie());
    }

    private final List<Supplier<Enemie>> gegnerListe = List.of(
            Zombie::new,
            Golem::new
    );

    public Enemie getRandomEnemie() {
//        int index = rand.nextInt(gegnerListe.size());
//        return gegnerListe.get(index).get();
        return rc.next();
    }
}
