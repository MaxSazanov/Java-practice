package polytech.labs.strategy;

public class Hero {
    Move moveStrategy;

    public Hero() {
        moveStrategy = new WalkStrategy();
    }

    public void setMoveStrategy(Move moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        moveStrategy.move();
    }
}
