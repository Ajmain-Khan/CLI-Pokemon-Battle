public class HumanPlayer extends Player{
    // Constructor
    public HumanPlayer(Monster monster) {
        this.monster = monster;
    }

    public int chooseMove() {
        System.out.println("\n\t╔══════════════════════════════════════════╗" +
                            "\n■=======╫\t\t Your Move:  \t\t   ╫=======■" +
                            "\n\t╠══════════════════════════════════════════╣\n" +
                            "\t╫   1) Vine Whip     ☘ Grass     Pwr: 45   ╫\n" +
                            "\t╫   2) Tackle        ✴ Normal    Pwr: 50   ╫\n" +
                            "\t╫   3) Take Down     ✴ Normal    Pwr: 90   ╫\n" +
                            "\t╫   4) Razor Leaf    ☘ Grass     Pwr: 55   ╫\n" +
                            "\t╠==========================================╝");

        System.out.print("\t╚\tSelect Move: ");
        int select = in.nextInt();  // Accept user input
        while (select < 1 || select > 4) {  // Raises error in cases where user doesn't input the correct value
            System.out.print("\t╚\tERROR! Select a move (1-4): ");
            select = in.nextInt();
        }
        return select;
    }
}