package kalah;

import com.qualitascorpus.testsupport.IO;

public class Command_SaveGame extends Command{

    @Override
    public void execute(IO io, Player player, Player opponent, CareTaker cr_player, CareTaker cr_opponent) {

        player.setSava_storeSeeds(player.getStoreSeedsNumber());
        player.setSave_nextTurn(player.getNextTurn());
        int[] save_Player_pits = new int[7];
        for (Integer i : player.getHoursesAndSeeds().keySet()
             ) {
            save_Player_pits[i] = player.getHoursesAndSeeds().get(i);
        }
        player.setSave_Player_pits(save_Player_pits);

        opponent.setSava_storeSeeds(opponent.getStoreSeedsNumber());
        opponent.setSave_nextTurn(opponent.getNextTurn());
        int[] save_Opponent_pits = new int[7];
        for (Integer i : opponent.getHoursesAndSeeds().keySet()
        ) {
            save_Opponent_pits[i] = opponent.getHoursesAndSeeds().get(i);
        }
        opponent.setSave_Player_pits(save_Opponent_pits);

        //set a save state
        opponent.setSave_state(true);
        cr_opponent.setMemento(opponent.createMemento()); //put state into careTaker cr

        player.setSave_state(true);
        cr_player.setMemento(player.createMemento()); //put state into careTaker cr



    }
}
