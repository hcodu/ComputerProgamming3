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
            Random r = new Random(1);
            if(r.nextInt() == 0) {
                return mySound1;
            }
        }
        return mySound2;
    }

    public String getType() {
        return myType;
    }
}
