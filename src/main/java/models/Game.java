package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="games")

public class Game {
	private int id;
	private String title;
	private Genre genre;
	private List<Console> consoles;

	public Game(){

	}

	public Game(String title, Genre genre) {
		this.title = title;
		this.genre = genre;
		this.consoles =new ArrayList<Console>();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	public int getId() {
		return id;
	}
	@Column(name ="title")
	public String getTitle() {
		return title;
	}
	@Enumerated(value = EnumType.STRING)
	public Genre getGenre() {
		return genre;
	}

	@ManyToMany
	@JoinTable(name ="game_console",
		joinColumns =  {@JoinColumn(name = "game_id", nullable = false, updatable = false)},
		inverseJoinColumns = {@JoinColumn(name ="console_id", nullable = false, updatable = false)})
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	public List<Console> getConsoles() {
		return consoles;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public void setConsoles(List<Console> consoles) {
		this.consoles = consoles;
	}

	public void addConsoleToGame(Console console){
		this.consoles.add(console);
	}

}
