public class Programmer {
    private ProgrammingLanguage language;
    private String name;
    private double salary;
    private boolean workFromHome;

    public Programmer(ProgrammingLanguage language, String name, double salary, boolean workFromHome) {
        this.language = language;
        this.name = name;
        this.salary = salary;
        this.workFromHome = workFromHome;
    }

    public ProgrammingLanguage getLanguage() {
        return language;
    }

    public void setLanguage(ProgrammingLanguage language) {
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isWorkFromHome() {
        return workFromHome;
    }

    public void setWorkFromHome(boolean workFromHome) {
        this.workFromHome = workFromHome;
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "language=" + language +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", workFromHome=" + workFromHome +
                '}' + "\n";
    }
}
