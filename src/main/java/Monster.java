public class Monster {
    private String name, type;
    private int hp, speed, attack, defense;
    private Move move1, move2, move3, move4;

    // Constructor
    public Monster(String name, String type, int hp, int speed, int attack, int defense, 
                    Move move1, Move move2, Move move3, Move move4) {
        this.name = name; this.type = type; this.hp = hp; this.speed = speed;
        this.attack = attack; this.defense = defense; this.move1 = move1;
        this.move2 = move2; this.move3 = move3; this.move4 = move4;
    }

    // Accessors
    public String getName() {   // Returns monster's name
        return name;
    }
    public String getType() {   // Returns monster's element type
        return type;
    }
    public int getHP() {    // Returns monster's health points
        return hp;
    }
    public int getSpeed() { // Returns monster's speed
        return speed;
    }
    public int getAttack() {    // Returns monster's attack stats
        return attack;
    }
    public int getDefense() {   // Returns monster's defense stats
        return defense;
    }
    public Move getMove1() {    // Returns monster's 1st move
        return move1;
    }
    public Move getMove2() {    // Returns monster's 2nd move
        return move2;
    }
    public Move getMove3() {    // Returns monster's 3rd move
        return move3;
    }
    public Move getMove4() {    // Returns monster's 4th move
        return move4;
    }

    // Mutators
    public void setHP(int hp) {
        this.hp = hp;   // Set monster's hp to parsed value
    }
}