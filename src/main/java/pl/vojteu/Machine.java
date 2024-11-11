package pl.vojteu;


public class Machine {
    private Long id;
    private String name;
    private String machineType;
    private String status;

    public Machine(String name, String machineType, String status) {
        this.name = name;
        this.machineType = machineType;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
