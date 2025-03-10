package trivia;

import java.util.ArrayList;
import java.util.LinkedList;

// REFACTOR ME
public class Game implements IGame
{

    ArrayList players = new ArrayList();
    int[] places = new int[6];
    int[] purses = new int[6];
    boolean[] inPenaltyBox = new boolean[6];

    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();
    ArrayList<String> cate = new ArrayList<String>();

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

    public Game()
    {
        for (int i = 0; i < 50; i++)
        {
            popQuestions.addLast(POP + " Question " + i);
            scienceQuestions.addLast((SCIENCE + " Question " + i));
            sportsQuestions.addLast((SPORTS + " Question " + i));
            rockQuestions.addLast((ROCK + " Question " + i));
        }
    }

    public String createRockQuestion(int index)
    {
        return "Rock Question " + index;
    }

    public boolean isPlayable()
    {
        return (howManyPlayers() >= 2);
    }

    public boolean add(String playerName)
    {
        places[howManyPlayers()] = 1;
        purses[howManyPlayers()] = 0;
        inPenaltyBox[howManyPlayers()] = false;
        players.add(playerName);

        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
        return true;
    }

    public int howManyPlayers()
    {
        return players.size();
    }

    public void roll(int roll)
    {
        System.out.println(players.get(currentPlayer) + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (inPenaltyBox[currentPlayer])
        {
            if (roll % 2 != 0)
            {
                inPenaltyBox[currentPlayer] = false;

                System.out.println(players.get(currentPlayer) + " is getting out of the penalty box");
                avancerJoueur(roll);
            } else
            {
                System.out.println(players.get(currentPlayer) + " is not getting out of the penalty box");
            }

        } else
        {

            avancerJoueur(roll);
        }

    }

    private void avancerJoueur(int roll)
    {
        places[currentPlayer] = places[currentPlayer] + roll;
        if (places[currentPlayer] > MAPSIZE) places[currentPlayer] = places[currentPlayer] - MAPSIZE;

        System.out.println(players.get(currentPlayer)
                + "'s new location is "
                + places[currentPlayer]);
        System.out.println("The category is " + currentCategory());
        askQuestion();
    }

    private void askQuestion()
    {
        switch (currentCategory())
        {
            case POP:
                System.out.println(popQuestions.removeFirst());
                break;
            case SCIENCE:
                System.out.println(scienceQuestions.removeFirst());
                break;
            case SPORTS:
                System.out.println(sportsQuestions.removeFirst());
                break;
            case ROCK:
                System.out.println(rockQuestions.removeFirst());
                break;
        }
    }


    private String currentCategory()
    {
        int place = places[currentPlayer] - 1;
        if (place == 0 || place == 4 || place == 8) return POP;
        if (place == 1 || place == 5 || place == 9) return SCIENCE;
        if (place == 2 || place == 6 || place == 10) return SPORTS;
        return ROCK;
    }

    public boolean handleCorrectAnswer()
    {
        if (inPenaltyBox[currentPlayer])
        {
            if (isGettingOutOfPenaltyBox)
            {
                System.out.println(CORRECT);
                purses[currentPlayer]++;
                System.out.println(players.get(currentPlayer)
                        + " now has "
                        + purses[currentPlayer]
                        + " Gold Coins.");

                boolean winner = didPlayerWin();
                currentPlayer++;
                if (currentPlayer == players.size()) currentPlayer = 0;

                return winner;
            } else
            {
                currentPlayer++;
                if (currentPlayer == players.size()) currentPlayer = 0;
                return true;
            }


        } else
        {

            System.out.println(CORRECT);
            purses[currentPlayer]++;
            System.out.println(players.get(currentPlayer)
                    + " now has "
                    + purses[currentPlayer]
                    + " Gold Coins.");

            boolean winner = didPlayerWin();
            currentPlayer++;
            if (currentPlayer == players.size()) currentPlayer = 0;

            return winner;
        }
    }

    public boolean wrongAnswer()
    {
        System.out.println("Question was incorrectly answered");
        System.out.println(players.get(currentPlayer) + " was sent to the penalty box");
        inPenaltyBox[currentPlayer] = true;

        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
        return true;
    }


    private boolean didPlayerWin()
    {
        return !(purses[currentPlayer] == 6);
    }
}
