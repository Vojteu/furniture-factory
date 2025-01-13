package pl.vojteu.furniturefactory.machines;

public class WardrobeMachine extends Machine {

    private static final Integer workStation = 2;

    public WardrobeMachine(Long id, String name, String status) {
        super(id, name, status);
    }

    @Override
    public void build() {
        System.out.println("build wardrobe");
    }
}
