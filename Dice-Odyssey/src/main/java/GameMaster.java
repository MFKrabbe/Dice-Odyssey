import java.util.Scanner; // insert Name, dice type and rounds.

/**
 * Makes a GameMaster to control the game
 */

public class GameMaster {

    public GameMaster() {}

    Scanner in = new Scanner(System.in);

    Player player = new Player();
    Player ai = new Player();
    Dice dice = new Dice();

    /**
     * You set the name of the player.
     */
    public void setAskName() {
        System.out.println("WHAT IS YOUR NAME?");
        String name = in.nextLine().toUpperCase();
        player.setPlayerName(name);
        System.out.println(" ");

        ai.setPlayerName("HALL9000");
    }

    /**
     * You set the amout of sides you want the dice.
     */
    public void setAskDice() {
        System.out.println("CHOOSE HOW MANY SIDES YOU WANT ON THE DICE ?"); //karl.askDice(int sides)
        int diceAnswer = in.nextInt();
        dice.setDiceSides(diceAnswer);
        System.out.println(" ");
    }

    /**
     * Ask the amount of rounds you want to play, must be higher than 1.
     * @return The amount of rounds you want to play.
     * @throws InterruptedException
     */
    public int askRounds() throws InterruptedException {
        System.out.println("HOW MANY ROUNDS DO YOU WANT TO PLAY?");
        int amount = in.nextInt();
        System.out.println(" ");
        if (amount <= 0) {
            System.out.println("PLEASE INPUT 1 OR HIGHER?");
            this.askRounds();
        }
        return amount;
    }

    /**
     * You are asked if you want to play (throw dice)
     * If you answer yes the game round continuous as normal
     * if you answer no the round is skipped and 2 points are rewarded to AI
     */
    public void continueGame() {
        String answer;
        System.out.println("DO YOU WANT TO THROW DICE? ANSWER WITH YES");
        in = new Scanner(System.in);
        answer = in.nextLine();                                             // Clears scanner input, ellers ville den skippe første kast
        System.out.println(" ");
        if (answer.equalsIgnoreCase("yes")) {
            this.gameRound();                                               //this.gameRound(dice.throwDice(2, player.getPlayerName()), dice.throwDice(2, ai.getPlayerName()));
        } else {
            System.out.printf("I'M SORRY %s, I'M AFRAID I CAN'T DO THAT \n", player.getPlayerName());
            System.out.println("2 POINTS FOR HALL9000\n");
            ai.givePlayerPoints(2);
        }
    }

    /**
     * The player and AI throws their dice
     * The total sum of their throws gets calculated
     * Compare the player and AI points and declares a winner of the round
     */
    private void gameRound() {                //private void gameRound(int throwSum1, int throwSum2)
        int throwSumPlayer = 0;
        int throwSumAI = 0;
        for (int i = 1; i <= 2; i++) {
            int throwPlayer = dice.throwDice();
            int throwAi = dice.throwDice();
            System.out.printf("%s'S DICE LANDS ON %d \t",player.getPlayerName(), throwPlayer);
            System.out.printf("%s'S DICE LANDS ON %d \n",ai.getPlayerName(), throwAi);

            throwSumPlayer += throwPlayer;
            throwSumAI += throwAi;
        }
        /*
        int throwPlayer1 = dice.throwDice();
        int throwPlayer2 = dice.throwDice();
        int throwAi1 = dice.throwDice();
        int throwAi2 = dice.throwDice();
        System.out.printf("%s'S DICE LANDS ON %d \t",player.getPlayerName(), throwPlayer1);
        System.out.printf("%s'S DICE LANDS ON %d \n",ai.getPlayerName(), throwAi1);
        System.out.printf("%s'S DICE LANDS ON %d \t",player.getPlayerName(), throwPlayer2);
        System.out.printf("%s'S DICE LANDS ON %d \n",ai.getPlayerName(), throwAi2);

        int throwSum1 = throwPlayer1 + throwPlayer2;
        int throwSum2 = throwAi1 + throwAi2;

         */

        System.out.printf("\n%-10s TOTAL DICE SUM IS %d\n", player.getPlayerName(), throwSumPlayer);
        System.out.printf("%-10s TOTAL DICE SUM IS %d\n\n", ai.getPlayerName(), throwSumAI);

        //Player total sum compares with AI total Sum
        if (throwSumPlayer > throwSumAI) {                            //Player sum is the largets = player gets the points

            System.out.printf("\n%s WINS THE ROUND!\n\n", player.getPlayerName());
            player.givePlayerPoints(2);

            player.presentPlayer();
            ai.presentPlayer();
            System.out.println(" ");
        } else if (throwSumPlayer < throwSumAI) {                     //AI sum is the largets = AI get the points

            System.out.printf("\n%s WINS THE ROUND!\n\n", ai.getPlayerName());
            ai.givePlayerPoints(2);

            player.presentPlayer();
            ai.presentPlayer();
            System.out.println(" ");
        } else {

            System.out.println("\nROUND IS A DRAW\n\n");        //Player sum == AI sum, each player gets 1 point
            player.givePlayerPoints(1);
            ai.givePlayerPoints(1);

            player.presentPlayer();
            ai.presentPlayer();
            System.out.println(" ");
        }
    }

    /**
     * Plays and loops the game x amount of times
     * @param amount the amount of games to be played
     * @throws InterruptedException
     */
    public void game(int amount) throws InterruptedException{

        int counter = 1;
        do
        {    //do while loop, how many rounds
            System.out.printf("\nROUND %d FIGHT!!!\n\n",counter);
            Thread.sleep(1000);

            this.continueGame();
            Thread.sleep(1000);

            counter ++;
        } while (counter <= amount);
        this.declareWinner();
    }


    /**
     * Compares the player and AI points and declares a winner
     */
    public void declareWinner()
    {
        //Gets player and AI point and compares points
        if(player.getPlayerPoints() > ai.getPlayerPoints())                     //if player points higher
        {
            System.out.printf("%s WINS!!! :P\n", player.getPlayerName());
        }
        else if(player.getPlayerPoints() < ai.getPlayerPoints())                //if AI points higher
        {
            System.out.printf("%s WINS >:) \n%s IS LEFT TO ROT IN SPACE.....\n\n", ai.getPlayerName(), player.getPlayerName());
        }
        else                                                                    //if player and AI points are equal
        {
            System.out.println("ITS A DRAW!\n");
        }
    }

    /**
     * Resets both player and AI points back to 0
     */
    public void resetGame()
    {
        player.resetPlayerPoints();
        ai.resetPlayerPoints();
    }
}
