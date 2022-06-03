package kalah;

public class CareTaker {
    private Memento_SaveGame memento;
    public void setMemento(Memento_SaveGame m) {
        memento = m;
    }
    public Memento_SaveGame getMemento() {
        return memento;
    }
}
