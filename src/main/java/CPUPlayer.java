public class CPUPlayer extends Player {
    // Constructor
    public CPUPlayer(Monster monster) {
        this.monster = monster;
    }

    public int chooseMove(String enemyType) {
        if (monster.getType() == "Fire" && enemyType == "Grass") {  // Prioritize super effective moves against grass types
            return (int) (Math.random() * 3) + 2;   // Chooses random integer between 2 and 4 (fire/flying type moves)
        }
        else
            return rand.nextInt(4)+1;   // Randomly choose integer between 1-4 (actually 0-3 but +1)
    }
}