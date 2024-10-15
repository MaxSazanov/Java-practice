package polytech.labs.strategy;

public class WalkStrategy implements Move {
    @Override
    public void move() {
        System.out.println("The hero walks to another place.");
    }
}
