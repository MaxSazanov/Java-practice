package polytech.labs.strategy;

public class FlyStrategy implements Move {

    @Override
    public void move() {
        System.out.println("The hero is flying on a plane to another place.");
    }
}
