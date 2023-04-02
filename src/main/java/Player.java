import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class Player {
    protected Monster monster;
    Scanner in = new Scanner(System.in);
    Random rand = new Random();
    
    // Accessor
    public Monster getMonster() {
        return this.monster;
    }

    public boolean isFasterThan(Player enemy) { // Method that compares speed of monsters. Returns false by default
        if (monster.getSpeed() > enemy.getMonster().getSpeed()) // If player speed is greater than enemy's, returns true
            return true;
        return false;
    }

    public boolean hasLost() {  // Method to check hp, and whether the monster has been defeated
        if (this.monster.getHP() <= 0)
            return true;
        return false;
    }

    public boolean typeAdvantage(Monster enemy, String type) {    // Method to check if a move is stronger on a specific type
        if (enemy.getType() == "Grass" && type == "Fire")    // Fire type is super effective against grass
            return true;
        else if (enemy.getType() == "Grass" && type == "Flying")   // Flying type is super effective against grass
            return true;
        else
            return false;
    }

    public boolean typeDisadvantage(Monster enemy, String moveType) {   // Method to check if a move is weaker on a specific type
        if (enemy.getType() == "Fire" && moveType == "Grass")    // Grass type moves are not very effective against fire types
            return true;
        else
            return false;

    }

    public void attack(Player enemy, int playerMove) throws InterruptedException {
        float accuracy = 0; // Accuracy of monsters move
        int power = 0;  // Power of monsters move
        float randAccuracy = rand.nextFloat();  // Randomly generated accuracy
        boolean superEffective = false; // Keeps track of move effectiveness
        boolean ineffective = false;
        if (playerMove == 1) {
            accuracy = monster.getMove1().get_accuracy();
            if (typeAdvantage(enemy.monster, monster.getMove1().get_type())) {  // Call method to check if move is super effective against enemy
                power = (int) ((monster.getMove1().get_power())*1.5);   // Super effective moves do 50% more damage
                superEffective = true;
            }
            else if (typeDisadvantage(enemy.monster, monster.getMove1().get_type())) {   // Call method to check if move is less effective against enemy
                power = (int) ((monster.getMove1().get_power())*0.5);   // Ineffective moves do half damage
                ineffective = true;
            }
            else
                power = monster.getMove1().get_power();
            System.out.println("\n\t\t" + monster.getName() + " used " + monster.getMove1().get_name());
        }
        else if (playerMove == 2) {
            accuracy = monster.getMove2().get_accuracy();
            if (typeAdvantage(enemy.monster, monster.getMove2().get_type())) {
                power = (int) ((monster.getMove2().get_power())*1.5);
                superEffective = true;
            }
            else if (typeDisadvantage(enemy.monster, monster.getMove2().get_type())) {
                power = (int) ((monster.getMove2().get_power())*0.5);   // Ineffective moves do half damage
                ineffective = true;
            }
            else
                power = monster.getMove2().get_power();
            System.out.println("\n\t\t" + monster.getName() + " used " + monster.getMove2().get_name());
        }
        else if (playerMove == 3) {
            accuracy = monster.getMove3().get_accuracy();
            if (typeAdvantage(enemy.monster, monster.getMove3().get_type())) {
                power = (int) ((monster.getMove3().get_power())*1.5);
                superEffective = true;
            }
            else if (typeDisadvantage(enemy.monster, monster.getMove3().get_type())) {
                power = (int) ((monster.getMove3().get_power())*0.5);   // Ineffective moves do half damage
                ineffective = true;
            }
            else
                power = monster.getMove3().get_power();
            System.out.println("\n\t\t" + monster.getName() + " used " + monster.getMove3().get_name());
        }
        else if (playerMove == 4) {
            accuracy = monster.getMove4().get_accuracy();
            if (typeAdvantage(enemy.monster, monster.getMove4().get_type())) {
                power = (int) ((monster.getMove4().get_power())*1.5);
                superEffective = true;
            }
            else if (typeDisadvantage(enemy.monster, monster.getMove4().get_type())) {
                power = (int) ((monster.getMove4().get_power())*0.5);   // Ineffective moves do half damage
                ineffective = true;
            }
            else
                power = monster.getMove4().get_power();
            System.out.println("\n\t\t" + monster.getName() + " used " + monster.getMove4().get_name());
        }
        if (randAccuracy < accuracy) {  // Attacks land only if move accuracy is greater than generated accuracy
            int damage = monster.getAttack() + power - enemy.monster.getDefense();  // Damage calculation
            enemy.monster.setHP(enemy.monster.getHP()-damage);  // Apply damage to enemy monster's hp
            TimeUnit.MILLISECONDS.sleep(500);
            if (superEffective)
                System.out.println("\t\tIt's SUPER Effective!");
            else if (ineffective)
                System.out.println("\t\tIt's not very effective...");
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("\t\t" + monster.getName() + " deals " + damage + " damage to " + enemy.monster.getName() + "\n");
        }
        else {
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("\t\tIt missed!");
        }
    }
}