package kalah;

import com.qualitascorpus.testsupport.IO;
import com.qualitascorpus.testsupport.MockIO;


public class Kalah {

    public static void main(String[] args) {
        new Kalah().play(new MockIO());
    }

    //create two players
    Player p1 = new Player();
    Player p2 = new Player();

    //Create a gameBoard
    SowingSeeds sowingSeeds = new SowingSeeds();
    ShowBoard showBoard = new ShowBoard();

    //Define an Integer that player chooses
    int position;

    GetChoice getChoice = new GetChoice();
    Command commandQuit = new Command_Quit();
    Command commandNewGame = new Command_NewGame();
    Command commandSaveGame = new Command_SaveGame();
    Command commandLoadGame = new Command_LoadGame();
    Invoker invoker = new Invoker();

    CareTaker cr_player = new CareTaker();
    CareTaker cr_opponent = new CareTaker();

    public void play(IO io) {
        p1.putSeeds();
        p1.setNextTurn(1);  //p1 is the first turn
        p1.setSave_state(false); //p1 do not have save state.
        cr_player.setMemento(p1.createMemento()); //put state into careTaker cr

        p2.putSeeds();
        p2.setNextTurn(0); //p2 is the second turn.
        p2.setSave_state(false); //p2 do not have save state.
        cr_opponent.setMemento(p2.createMemento()); //put state into careTaker cr


        while (p1.getNextTurn() != 0 || p2.getNextTurn() != 0) {
            if (p1.getNextTurn() == 1 && p2.getNextTurn() == 0) {
                while (p1.getNextTurn() == 1 && p2.getNextTurn() == 0) {
                    showBoard.showBoard(io, p1, p2);
                    io.println("Player P1");
                    position = getChoice.readFromKeyboard("Choice:", io);

                    //when readFromKeyBoard = n, position = -1
                    if (position == -1) {
                        invoker.setCommand(commandNewGame);
                        invoker.action(io, p1, p2, cr_player, cr_opponent);
                        break;
                    }
                    //when readFromKeyBoard = s, position = -2
                    else if (position == -2){
                        invoker.setCommand(commandSaveGame);
                        invoker.action(io, p1, p2, cr_player, cr_opponent);
                      break;
                    }
                    //when readFromKeyBoard = l, position = -3
                    else if(position == -3){
                        // use memento to store the save state that denotes wether the user save the board or not
                        if (!cr_player.getMemento().getState() && !cr_opponent.getMemento().getState()) {
                            io.println("No saved game");
                            break;
                        }
                        invoker.setCommand(commandLoadGame);
                        invoker.action(io, p1, p2, cr_player, cr_opponent);
                        break;
                    }
                    //when readFromKeyBoard = q, position = -4
                    else if (position == -4){
                        invoker.setCommand(commandQuit);
                        invoker.action(io, p1, p2, cr_player, cr_opponent);
                        return;
                    }

                    int useEmptySignal = sowingSeeds.sowing(position, p1, p2);
                    //if useEmptySignal == 1, it means the pit player choose is empty.
                    if (useEmptySignal == 1) {
                        io.println("House is empty. Move again.");
                    }
                }
            } else if (p1.getNextTurn() == 0 && p2.getNextTurn() == 1) {
                while (p1.getNextTurn() == 0 && p2.getNextTurn() == 1) {
                    showBoard.showBoard(io, p1, p2);
                    io.println("Player P2");
                    position = getChoice.readFromKeyboard("Choice:", io);

                    //when readFromKeyBoard = n, position = -1
                    if (position == -1) {
                        invoker.setCommand(commandNewGame);
                        invoker.action(io, p1, p2, cr_player, cr_opponent);
                        break;
                    }
                    //when readFromKeyBoard = s, position = -2
                    else if (position == -2){
                        invoker.setCommand(commandSaveGame);
                        invoker.action(io, p1, p2, cr_player, cr_opponent);
                        break;
                    }
                    //when readFromKeyBoard = l, position = -3
                    else if(position == -3){
                        // use memento to store the save state that denotes wether the user save the board or not
                        if (!cr_player.getMemento().getState() && !cr_opponent.getMemento().getState()) {
                            io.println("No saved game");
                            break;
                        }
                        invoker.setCommand(commandLoadGame);
                        invoker.action(io, p1, p2, cr_player, cr_opponent);
                         break;
                    }
                    //when readFromKeyBoard = q, position = -4
                    else if (position == -4){
                        invoker.setCommand(commandQuit);
                        invoker.action(io, p1, p2, cr_player, cr_opponent);
                        return;
                    }

                    int useEmptySignal = sowingSeeds.sowing(position, p2, p1);
                    //if useEmptySignal == 1, it means the pit player choose is empty.
                    if (useEmptySignal == 1) {
                        io.println("House is empty. Move again.");
                    }
                }
            }
        }


        showBoard.showBoard(io, p1, p2);
        io.println("Game over");

        if (sowingSeeds.mostSeeds() == p1) {
            showBoard.showBoard(io, p1, p2);
            io.println("\tplayer 1:" + p1.totalSeeds(p1));
            io.println("\tplayer 2:" + p2.totalSeeds(p2));
            io.println("Player 1 wins!");
        } else if (sowingSeeds.mostSeeds() == p2) {
            showBoard.showBoard(io, p1, p2);
            io.println("\tplayer 1:" + p1.totalSeeds(p1));
            io.println("\tplayer 2:" + p2.totalSeeds(p2));
            io.println("Player 2 wins!");
        } else if (sowingSeeds.mostSeeds() == null) {
            showBoard.showBoard(io, p1, p2);
            io.println("\tplayer 1:" + p1.totalSeeds(p1));
            io.println("\tplayer 2:" + p2.totalSeeds(p2));
            io.println("A tie!");
        }
    }



}
