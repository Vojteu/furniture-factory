package pl.vojteu;

public class Department {
    private Long id;
    private String name;
    private Employees[]  employees;

    public Department(String name) {
        this.name = name;
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

    public Employees[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employees[] employees) {
        this.employees = employees;
    }
}
