package kalah;

import com.qualitascorpus.testsupport.IO;


public class Command_Quit extends Command{
    @Override
    public void execute(IO io, Player player, Player opponent, CareTaker cr_player, CareTaker cr_opponent) {
            io.println("Game over");
            showBoard.showBoard(io, player, opponent);

        }
    }

