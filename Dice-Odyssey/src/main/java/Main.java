import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws InterruptedException {
        GameMaster karl = new GameMaster();
        Scanner input = new Scanner(System.in);
        karl.setAskName();
        karl.setAskDice();

        boolean isOn = true;
        String answer;
        do
        {
            karl.game(karl.askRounds());
            // Ask if you want to play again. IF answer not yes or no, loop continues until you input yes or no
            System.out.println("DO YOU WANT TO PLAY AGAIN? (YES/NO)");
            do{
                answer = input.next();  // gets answer from player
                //If input is no the game stops, breaks the loop
                if (answer.equalsIgnoreCase("NO"))
                {
                    System.out.println("GAME STOPPED");
                    isOn = false;               //break;
                    break;
                }
                //if input is yes, restarts game, breaks the loop
                else if(answer.equalsIgnoreCase("YES"))
                {
                    System.out.println("RESETTING GAME\n\n");
                    karl.resetGame();
                    break;
                }
                System.out.println("PLEASE ENTER YES OR NO");
            }while(true);

        }while(isOn);

    }
}
