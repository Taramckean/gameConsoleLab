import db.DBConsole;
import db.DBGame;
import db.DBHelper;
import models.Console;
import models.Game;
import models.Genre;
import models.Owner;

import java.util.List;

public class Runner {
	public static void main(String[] args) {

		Game game1 = new Game("The Legend of Zelda", Genre.ADVENTURE);
		Game game2 = new Game("Super Smash Bros", Genre.MULTIPLAYER);
		Game game3 = new Game("Fifa", Genre.SIMULATION);
		Game game4 = new Game("Sniper: Ghost Warrior", Genre.STEALTH_SHOOTER);
		Game game5 = new Game("Myst", Genre.ADVENTURE);
		DBHelper.saveOrUpdate(game1);
		DBHelper.saveOrUpdate(game2);
		DBHelper.saveOrUpdate(game3);
		DBHelper.saveOrUpdate(game4);
		DBHelper.saveOrUpdate(game5);

		Console console1 = new Console("Nintendo", "64", "United Kingdom");
		Console console2 = new Console("Sony", "Playstation 2", "United States");
		Console console3 = new Console("Nintendo", "5th generation", "Worldwide");
		DBHelper.saveOrUpdate(console1);
		DBHelper.saveOrUpdate(console2);
		DBHelper.saveOrUpdate(console3);

		Owner owner1 = new Owner("Campbell", game1 );
		Owner owner2 = new Owner("Tara", game1);
		DBHelper.saveOrUpdate(owner1);
		DBHelper.saveOrUpdate(owner2);


		DBGame.addGametoConsole(console1, game1);
		DBGame.addGametoConsole(console1, game2);

		DBGame.addGametoConsole(console2, game4);
		DBGame.addGametoConsole(console3, game4);

		List<Console> ConsolesFromGames = DBGame.getConsolesFromGame(game4);

		List <Game> gamesFromConsoles = DBConsole.getGamesFromConsole(console1);

		List<Owner> ownersForThisGame = DBGame.getOwnersForGame(game1);
	}
}
