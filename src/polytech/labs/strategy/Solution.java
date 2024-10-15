package polytech.labs.strategy;

public class Solution {
    public static void main(String[] args) {
        Hero hero = new Hero();
        hero.move();

        hero.setMoveStrategy(new FlyStrategy());
        hero.move();

        hero.setMoveStrategy(new RideStrategy());
        hero.move();

        hero.setMoveStrategy(new WalkStrategy());
        hero.move();
    }
}
