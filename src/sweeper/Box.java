package sweeper;

import java.awt.*;

/*1:40 12v it created */
public enum Box {
    //UNDERGROUND
    ZERO,
    NUM1,
    NUM2,
    NUM3,
    NUM4,
    NUM5,
    NUM6,
    NUM7,
    NUM8,
    BOMB,
    //above
    OPENED,
    CLOSED,
    FLAGED,
    BOMBED,
    NOBOMB;
    //added 14v
    public Object image; //changed in 2:30 14v Image --> Object
}
