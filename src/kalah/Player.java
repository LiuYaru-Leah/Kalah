package kalah;

import java.util.HashMap;

/**
 * This is a player class which uses to define player's pits and seeds
 * Player class extends GameInitialValue in order to acquire the initial information including number of seeds and houses.
 * */
public class Player extends GameInitialValue {

    //Create a collection in order to define pits and store the seeds.
    private HashMap<Integer, Integer> hoursesAndSeeds = new HashMap<Integer, Integer>();
    private int storeSeedsNumber = 0;
    private int nextTurn;
    private int[] save_Player_pits;
    private boolean save_state;

    public int[] getSave_Player_pits() {
        return save_Player_pits;
    }

    public void setSave_Player_pits(int[] save_Player_pits) {
        this.save_Player_pits = save_Player_pits;
    }

    private int sava_storeSeeds;
    private int save_nextTurn;

    public int getSava_storeSeeds() {
        return sava_storeSeeds;
    }

    public void setSava_storeSeeds(int sava_storeSeeds) {
        this.sava_storeSeeds = sava_storeSeeds;
    }


    public int getSave_nextTurn() {
        return save_nextTurn;
    }

    public void setSave_nextTurn(int save_nextTurn) {
        this.save_nextTurn = save_nextTurn;
    }

    public  HashMap<Integer, Integer> getHoursesAndSeeds() {
        return hoursesAndSeeds;
    }

    public void setHoursesAndSeeds(HashMap<Integer, Integer> hoursesAndSeeds) {
        this.hoursesAndSeeds = hoursesAndSeeds;
    }

    public int getStoreSeedsNumber() {
        return storeSeedsNumber;
    }

    public void setStoreSeedsNumber(int storeSeedsNumber) {
        this.storeSeedsNumber = storeSeedsNumber;
    }

    public void putSeeds(){
        for (int i = 1; i <= TOTAL_HOUSE_NUM; i++){
            hoursesAndSeeds.put(i, INITIAL_SEED_NUMBER);
        }
    }

    //get the matching seeds number with position
    public Integer getSeeds(Integer position){
        return hoursesAndSeeds.get(position);
    }

    public void setPits(Integer position, Integer seeds){
        hoursesAndSeeds.put(position,seeds);
    }

    public int getNextTurn() {
        return nextTurn;
    }

    public void setNextTurn(int nextTurn) {
        this.nextTurn = nextTurn;
    }

    public int totalHousesSeeds(Player player){
        int totalHousesSeeds = 0;
        for (Integer pitSeeds: player.getHoursesAndSeeds().keySet()
        ) {
            totalHousesSeeds += player.getHoursesAndSeeds().get(pitSeeds);
        }
        return totalHousesSeeds;
    }

    public int totalSeeds(Player player){
        int totalSeeds = 0;
        for (Integer pitSeeds: player.getHoursesAndSeeds().keySet()
             ) {
           totalSeeds += player.getHoursesAndSeeds().get(pitSeeds);
        }
        totalSeeds += player.getStoreSeedsNumber();

        return totalSeeds;
    }


    public boolean getSave_state() {
        return save_state;
    }

    public void setSave_state(boolean save_state) {
        this.save_state = save_state;
    }

    public Memento_SaveGame createMemento() {
        return new Memento_SaveGame(save_state);
    }
    public void restoreMemento(Memento_SaveGame m) {
        this.setSave_state(m.getState());
    }

}
