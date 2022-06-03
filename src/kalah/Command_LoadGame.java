package kalah;

import com.qualitascorpus.testsupport.IO;

public class Command_LoadGame extends Command{

    @Override
    public void execute(IO io, Player player, Player opponent, CareTaker cr_player, CareTaker cr_opponent) {

      player.setNextTurn(player.getSave_nextTurn());
      player.setStoreSeedsNumber(player.getSava_storeSeeds());
      int[] save_Player_pits = player.getSave_Player_pits();
        for (Integer i: player.getHoursesAndSeeds().keySet()
             ) {
            player.setPits(i,save_Player_pits[i]);
        }

        opponent.setNextTurn(opponent.getSave_nextTurn());
        opponent.setStoreSeedsNumber(opponent.getSava_storeSeeds());
        int[] save_Opponent_pits = opponent.getSave_Player_pits();
        for (Integer i: opponent.getHoursesAndSeeds().keySet()
        ) {
            opponent.setPits(i,save_Opponent_pits[i]);
        }

    }
}
