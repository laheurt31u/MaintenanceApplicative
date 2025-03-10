package trivia;

import java.util.ArrayList;

public interface IGame {

	public static final int MAPSIZE = 12;
	public static final String CORRECT = "Answer was correct !!!!";
	 public static final String POP = "Pop";
	 public static final String SCIENCE = "Science";
	 public static final String SPORTS = "Sports";
	 public static final String ROCK = "Rock";

	boolean add(String playerName);

	void roll(int roll);

	boolean handleCorrectAnswer();

	boolean wrongAnswer();



}