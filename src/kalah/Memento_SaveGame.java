package kalah;

public class Memento_SaveGame {
    private Boolean state;

    public Memento_SaveGame(Boolean state){
        this.state = state;
    }

    public Boolean getState(){
        return state;
    }

}
