package pl.vojteu.interfaces;

import pl.vojteu.Location;

public interface Adjustable {
    void swing(Location location, double speed);
    void massage(int mode); // slow,medium,fast
}
