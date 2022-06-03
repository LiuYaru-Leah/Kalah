package kalah;

import com.qualitascorpus.testsupport.IO;

//implement command
public class Invoker {
    private Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    public void action(IO io, Player player, Player opponent, CareTaker cr_player, CareTaker cr_opponent){
        this.command.execute(io, player, opponent, cr_player, cr_opponent);
    }

}
