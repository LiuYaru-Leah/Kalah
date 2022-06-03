package kalah;

import com.qualitascorpus.testsupport.IO;

/**
 * The goal of this class is to define the real board including the shape of the board and how to sow.
 */
public class ShowBoard{

    // Show the game board
    public void showBoard(IO io, Player player, Player opponent) {

        io.println("+----+-------+-------+-------+-------+-------+-------+----+");
        //The board of opponent/p2
        io.print("| P2 |");
        for (int position = opponent.TOTAL_HOUSE_NUM; position > 0; position--) {
            String validNumStr = getValidNumStr(opponent.getHoursesAndSeeds().get(position));
            io.print(" " + position + "[" + validNumStr + "] |");
        }
        //print the seeds number of store
        String validNumStrP = getValidNumStr(player.getStoreSeedsNumber());
        io.println(" " + validNumStrP + " |");

        io.println("|    |-------+-------+-------+-------+-------+-------|    |");

        //The board of player/p1
        String validNumStrO = getValidNumStr(opponent.getStoreSeedsNumber());
        io.print("| " + validNumStrO + " | ");
        for (Integer position : player.getHoursesAndSeeds().keySet()
        ) {
            String validNumStr = getValidNumStr(player.getSeeds(position));
            io.print(position + "[" + validNumStr + "] | ");
        }
        io.println("P1 |");
        io.println("+----+-------+-------+-------+-------+-------+-------+----+");

    }

    public void showOptions(IO io){
        io.println("    (1-6) - house number for move");
        io.println("    N - New game");
        io.println("    S - Save game");
        io.println("    L - Load game");
        io.println("    q - Quit");
    //    io.println("Choice:");
    }


    public String getValidNumStr(int num) {
        if (num >= 10) {
            return "" + num;
        } else {
            return " " + num;
        }
    }

}
