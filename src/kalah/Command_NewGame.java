package kalah;

import com.qualitascorpus.testsupport.IO;

public class Command_NewGame extends Command{
    @Override
    public void execute(IO io, Player player, Player opponent, CareTaker cr_player, CareTaker cr_opponent) {
        player.putSeeds();
        opponent.putSeeds();
        player.setStoreSeedsNumber(0);
        opponent.setStoreSeedsNumber(0);
        player.setNextTurn(1);
        opponent.setNextTurn(0);
        player.setSave_state(false);
        cr_player.setMemento(player.createMemento()); //put state into careTaker cr

        opponent.setSave_state(false);
        cr_opponent.setMemento(opponent.createMemento()); //put state into careTaker cr


    }
}
