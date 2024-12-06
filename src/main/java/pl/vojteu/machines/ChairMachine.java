package pl.vojteu.machines;

import pl.vojteu.interfaces.Movable;

public class ChairMachine extends Machine implements Movable {

    private static final Integer workStation = 1;

    public ChairMachine(Long id, String name, String status) {
        super(id, name, status);
    }

    @Override
    public void build() {
        System.out.println("build chair");
    }
}
