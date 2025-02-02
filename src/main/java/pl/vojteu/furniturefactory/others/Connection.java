package pl.vojteu.furniturefactory.others;

public class Connection {
    private static int idCounter = 1;
    private int id;

    public Connection() {
        this.id = idCounter++;
    }

    public String getName() {
        return "Connection-" + id;
    }
}
