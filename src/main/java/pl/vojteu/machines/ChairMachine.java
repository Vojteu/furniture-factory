package pl.vojteu.machines;

import pl.vojteu.Location;
import pl.vojteu.interfaces.Movable;

public class ChairMachine extends Machine implements Movable {
    public ChairMachine(Long id, String name, String status) {
        super(id, name, status);
    }

    @Override
    public void moveProductTo(Location location) {

    }

    @Override
    public void moveMachineTo(Location location) {

    }

    @Override
    public void build() {
        System.out.println("build chair");
    }
}
