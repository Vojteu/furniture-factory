package pl.vojteu.machines;

public class ChairMachine extends Machine{
    public ChairMachine(Long id, String name, String status) {
        super(id, name, status);
    }

    @Override
    public void build() {
        System.out.println("build chair");
    }
}
