import java.util.*;
public class Main {
    static abstract class GameCharacter {
        abstract int attack();
        abstract int defend();
    }
    static class Warrior extends GameCharacter {
        int strength;
        Warrior(int strength) { this.strength = strength; }
        int attack() { return strength * 3; }
        int defend() { return strength; }
    }
    static class Wizard extends GameCharacter {
        int power;
        Wizard(int power) { this.power = power; }
        int attack() { return power * 2; }
        int defend() { return power; }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        int val = sc.nextInt();
        GameCharacter gc = null;
        if (choice == 1) gc = new Warrior(val);
        else if (choice == 2) gc = new Wizard(val);
        else {
            System.out.println("Invalid character choice");
            return;
        }
        System.out.println("Attack: " + gc.attack());
        System.out.println("Defend: " + gc.defend());
    }
}
