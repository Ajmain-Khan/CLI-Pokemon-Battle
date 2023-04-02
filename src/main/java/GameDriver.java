import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
	The program is best ran in vscode terminal, otherwise there incompatibilties with the ASCII text art, however the program still runs as it should.

	Added Features:
		- Better CPU *AI*: Decides move based on type advantage
		- Variable Move Power: Moves can be "Super Effective" or "Not very effective" based on move type & enemy type
		- Intro Screen & Art: Prints ASCII art from text files for visual pleasure
		- Loading Animation: Added an animated loading symbol that simulates spinning
		- Time pauses: Pauses execution to simulate a realistic pokemon battle
*/

public class GameDriver {
	public static void main(String[] args) throws InterruptedException {

		// Bulbasaur (Player Pokemon)
		Move move1 = new Move("Vine Whip", "Grass", 45, 1.0f);
		Move move2 = new Move("Tackle", "Normal", 50, 1.0f);
		Move move3 = new Move("Take Down", "Normal", 90, 0.85f);
		Move move4 = new Move("Razor Leaf", "Grass", 55, 0.95f);
		Monster monster = new Monster("Bulbasaur", "Grass", 240, 45, 49, 49, move1, move2, move3, move4);
		HumanPlayer player = new HumanPlayer(monster);

		// Torchic (CPU Pokemon)
		move1 = new Move("Scratch", "Normal", 40, 1.0f);
		move2 = new Move("Ember", "Fire", 40, 1.0f);
		move3 = new Move("Peck", "Flying", 35, 1.0f);
		move4 = new Move("Fire Spin", "Fire", 35, 0.85f);
		monster = new Monster("Torchic", "Fire", 240, 45, 60, 40, move1, move2, move3, move4);
		CPUPlayer enemy = new CPUPlayer(monster);

		SpinLoad load = new SpinLoad();	// Instantiating Spinload class

		//String currentWorkingPath = System.getProperty("user.dir");
		//System.out.println(directory.getAbsolutePath());

		// Getting directory of text files
		File directory = new File(".\\src\\main\\java\\resources\\logo.txt");
		List<String> logo = new ReadText().readTXT(directory);	// Stores a list of strings from each line in text file

		directory = new File(".\\src\\main\\java\\resources\\versus.txt");
		List<String> versus = new ReadText().readTXT(directory);

		// Directory for Bulbasaur
		directory = new File(".\\src\\main\\java\\resources\\BulbasaurASCII.txt");
		List<String> bulbasaur = new ReadText().readTXT(directory);	// Invokes readTXT method to return a list from parsed text
		
		// Directory for Torchic
		directory = new File(".\\src\\main\\java\\resources\\TorchicASCII.txt");
		List<String> torchic = new ReadText().readTXT(directory);


		///////////////////////////
		// Printing out text art //		// Comment out the following blocks of code when testing as they slow down the process & don't affect core logic
		///////////////////////////

		// Print Title Card
		for (String i : logo) {
			System.out.println(i);
			TimeUnit.MILLISECONDS.sleep(20);
		}
		load.showLoad(load, 37, 90);	// Show loading animation
		// Print Bulbasaur
		for (String i : bulbasaur) {
			System.out.println(i);
			TimeUnit.MILLISECONDS.sleep(40);
		}
		TimeUnit.MILLISECONDS.sleep(1000);
		// Print versus text
		for (String i : versus) {
			System.out.println(i);
			TimeUnit.MILLISECONDS.sleep(40);
		}
		TimeUnit.MILLISECONDS.sleep(1000);
		// Print Torchic
		for (String i : torchic) {
			System.out.println(i);
			TimeUnit.MILLISECONDS.sleep(40);
		}
		load.showLoad(load, 26, 90);
		

		while ((!player.hasLost()) && (!enemy.hasLost())) {
			// Print both monsters' HP
			System.out.printf("\n\t■=================================■\n" +
			"\t||\t %s HP: %d\n", player.getMonster().getName(), player.getMonster().getHP());
			System.out.printf("\t||\t  %s HP: %d" +
			"\n\t■=================================■\n", enemy.getMonster().getName(), enemy.getMonster().getHP());
			
			// Decide the next move
			int playerMove = player.chooseMove();
			int enemyMove = enemy.chooseMove(player.getMonster().getType());
			
			// Execute the next move
			if (player.isFasterThan(enemy)) {
				player.attack(enemy, playerMove);
				if (!enemy.hasLost()) {
					enemy.attack(player, enemyMove);
				}
			} else {
				enemy.attack(player, enemyMove);
				if (!player.hasLost()) {
					player.attack(enemy, playerMove);
				}
			}
		}
		
		if (player.hasLost()) {
			System.out.printf("\n\t╔═══════════════════════════════════════════════════════╗" +
							"\n\t╫\tYou and %s have lost the battle.\t\t╫\n" +
							"\t╚═══════════════════════════════════════════════════════╝", player.getMonster().getName());
		} else {
			System.out.printf("\n\t╔═══════════════════════════════════════════════╗" +
							"\n\t╫\tYou and %s are victorious!\t╫\n" +
							"\t╚═══════════════════════════════════════════════╝", player.getMonster().getName());
		}
	}
}
