package trivia;

public interface IGame {

	public final int MAPSIZE = 12;
	public final String CORRECT = "Answer was correct !!!!";

	boolean add(String playerName);

	void roll(int roll);

	boolean handleCorrectAnswer();

	boolean wrongAnswer();



}