package OldMcDonald;

import java.util.Random;

public class Chick implements Animal{
    private String myType;
    private String mySound1, mySound2;

    Chick(String type, String sound) {
        myType = type;
        mySound1 = sound;
        mySound2 = null;
    }
    Chick(String type, String sound1, String sound2) {
        myType = type;
        mySound1 = sound1;
        mySound2 = sound2;
    }

    public String getSound() {
        if(mySound2 != null) {
            if(Math.random() > 0.5) {
                return mySound1;
            }
            else {
                return mySound2;
            }
        }
        return mySound1;
    }

    public String getType() {
        return myType;
    }
}
