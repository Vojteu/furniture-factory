package pl.vojteu.interfaces;

import pl.vojteu.Location;

public interface Adjustable {
    void adjustHeight(double height);
    void swing(Location location, double speed);
}
