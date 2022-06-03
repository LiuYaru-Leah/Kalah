package kalah;

import com.qualitascorpus.testsupport.IO;

public class GetChoice{
    public int readFromKeyboard(String prompt, IO io){
        io.println("    (1-6) - house number for move");
        io.println("    N - New game");
        io.println("    S - Save game");
        io.println("    L - Load game");
        io.println("    q - Quit");

        String input = io.readFromKeyboard(prompt);
        int position = 0;
        switch(input){
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
                position =  Integer.parseInt(input);
                break;
            case "n":
                position = -1;
                break;
            case "s":
                position = -2;
                break;
            case "l":
                position = -3;
                break;
            case "q":
                position = -4;
                break;
            default:

                break;
        }
        return position;
    }

}
