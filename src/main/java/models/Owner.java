package models;

import javax.persistence.*;

@Entity
@Table(name = "owners")
public class Owner {
	private int id;
	private String name;
	private Game favouriteGame;

	public Owner(){

	}

	public Owner(String name, Game favouriteGame){
		this.name = name;
		this.favouriteGame = favouriteGame;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}
	@Column(name = "name")
	public String getName() {
		return name;
	}
	@OneToMany
	(mappedBy= "owner", fetch = FetchType.LAZY)
	public Game getFavouriteGame() {
		return favouriteGame;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFavouriteGame(Game favouriteGame) {
		this.favouriteGame = favouriteGame;
	}
}
