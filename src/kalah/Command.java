package kalah;

import com.qualitascorpus.testsupport.IO;

public abstract class Command{
    protected ShowBoard showBoard = new ShowBoard();

    public abstract void execute(IO io, Player player, Player opponent, CareTaker cr_player, CareTaker cr_opponent);
}
