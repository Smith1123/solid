package hu.smith.software.poker.game;

import java.util.Objects;

public class Player {
    private String name;
    private double cash;
    private Hand hand;
    private boolean sitOut;

    public Player(String name, double cash) {
        this.name = name;
        this.cash = cash;
        this.hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public double getCash() {
        return cash;
    }

    public Hand getHand() {
        return hand;
    }

    public boolean isSitOut() {
        return sitOut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return name.equals(player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
