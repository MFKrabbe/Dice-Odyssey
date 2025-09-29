/**
 * Makes an empty player class
 */

public class Player
{
    public Player(){}

    private String playerName;
    private int playerPoints;

    /**
    * Presents the player (present the player name + player points)
    */
    public void presentPlayer() {
        System.out.printf("%-10s HAS %d POINTS \n", playerName, playerPoints);
    }

    /**
     * @return Gets the name of the player
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * @return Gets the player points
     */
    public int getPlayerPoints() {
        return playerPoints;
    }

    /**
     * Sets the player name
     * @param playerName The name that the player will have
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * Resets player points
     */
    public void resetPlayerPoints() {
        this.playerPoints = 0;
    }

    /**
     * Gives player points
     * @param playerPoints The amount of points the player is given.
     */
    public void givePlayerPoints(int playerPoints) {
        this.playerPoints += playerPoints;
    }

}
