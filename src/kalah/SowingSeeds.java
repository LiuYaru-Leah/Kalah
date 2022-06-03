package kalah;

/**
 * The goal of this class is to define the real board including the shape of the board and how to sow.
 * */
public class SowingSeeds {

    public Player player;
    public Player opponent;

    public int sowing(int position, Player player, Player opponent) {
        this.player = player;
        this.opponent = opponent;
        // define the matchingSeeds of position player choose
        int matchingSeeds = player.getSeeds(position);

        //useEmpty
        if (matchingSeeds == 0) {
            // io.println("House is empty. Move again.");
            return 1;
        }

        player.setPits(position, 0);

        for (int seeds = matchingSeeds; seeds > 0; seeds--) {
            position++;
            if (position > 14) {
                position -= 14;
            }
            switch (position) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    //if it is the last seed
                    if (player.getSeeds(position) == 0 && seeds == 1 && opponent.getSeeds(player.TOTAL_HOUSE_NUM - position + 1) != 0) {
                        player.setStoreSeedsNumber(player.getStoreSeedsNumber() + 1 + opponent.getSeeds(player.TOTAL_HOUSE_NUM - position + 1));
                        opponent.setPits(player.TOTAL_HOUSE_NUM - position + 1, 0);
                        if (player.totalHousesSeeds(player) == 0 && opponent.totalHousesSeeds(opponent) != 0) {
                            player.setNextTurn(0);
                            opponent.setNextTurn(1);
                            return 0;
                        }
                    } else {
                        player.setPits(position, player.getSeeds(position) + 1);
                    }
                    player.setNextTurn(0);
                    opponent.setNextTurn(1);
                    break;
                case 7:
                    player.setStoreSeedsNumber(player.getStoreSeedsNumber() + 1);
                    if (seeds == 1) {
                        player.setNextTurn(1);
                        opponent.setNextTurn(0);
                    }
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                    opponent.setPits(position - player.TOTAL_HOUSE_NUM - 1, opponent.getHoursesAndSeeds().get(position - player.TOTAL_HOUSE_NUM - 1) + 1);
                    player.setNextTurn(0);
                    opponent.setNextTurn(1);
                    break;
                case 14:
                    //if seed is landed in a store which is not owned by the player, skip.
                    opponent.setStoreSeedsNumber(opponent.getStoreSeedsNumber());
                    seeds++;
            }
            if ((player.totalHousesSeeds(player) == 0 && player.getNextTurn() == 1) ||
                    (opponent.totalHousesSeeds(opponent) == 0 && opponent.getNextTurn() == 1)) {
                player.setNextTurn(0);
                opponent.setNextTurn(0);
            }
        }
        return 0;
    }

    public Player mostSeeds() {
        if (player.totalSeeds(player) > opponent.totalSeeds(opponent)) {
            return player;
        } else if (player.totalSeeds(player) < opponent.totalSeeds(opponent)) {
            return opponent;
        } else {
            return null;
        }
    }

}
