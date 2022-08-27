import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;

public class HW34MainClass {
    public static void main(String[] args) {
        // Programmers creating
        Programmer programmer1 = new Programmer(ProgrammingLanguage.JAVA, "Daniel", 120000, true);
        Programmer programmer2 = new Programmer(ProgrammingLanguage.SWIFT, "John", 80000, false);
        Programmer programmer3 = new Programmer(ProgrammingLanguage.PYTHON, "Julia", 130000, true);
        Programmer programmer4 = new Programmer(ProgrammingLanguage.JS, "Angela", 95000, true);
        Programmer programmer5 = new Programmer(ProgrammingLanguage.JAVA, "Max", 100000, false);
        Programmer programmer6 = new Programmer(ProgrammingLanguage.JS, "Jennet", 98000, true);
        Programmer programmer7 = new Programmer(ProgrammingLanguage.PYTHON, "Michael", 105000, false);
        ArrayList<Programmer> programmers = new ArrayList<>();
        programmers.add(programmer1);
        programmers.add(programmer2);
        programmers.add(programmer3);
        programmers.add(programmer4);
        programmers.add(programmer5);
        programmers.add(programmer6);
        programmers.add(programmer7);

        // Total amount of workers, max, min and average salary sizes
        DoubleSummaryStatistics salaryList = programmers.stream()
                .collect(Collectors.summarizingDouble(x -> x.getSalary()));
        System.out.println("The amount of workers: " + salaryList.getCount());
        System.out.println("Max salary size: $" + salaryList.getMax());
        System.out.println("Min salary size: $" + salaryList.getMin());
        System.out.println("Average salary size: $" + salaryList.getAverage());

        // Distance-workers
        ArrayList<String> programmersFromHome = new ArrayList(programmers.stream()
                .filter(x -> x.isWorkFromHome() == true)
                .map(x -> x.getName())
                .collect(Collectors.toList()));
        System.out.println("Programmer, works from home: " + programmersFromHome);

        // Java coders
        int javaProgrammers = (int) programmers.stream()
                .filter(x -> x.getLanguage() == ProgrammingLanguage.JAVA)
                .count();
        System.out.println("The amount of java programmers: " + javaProgrammers);

        // Python from home
        ArrayList<String> pythonFromHomeProgrammers = new ArrayList(programmers.stream()
                .filter(x -> x.getLanguage() == ProgrammingLanguage.PYTHON && x.isWorkFromHome() == true)
                .map(x -> x.getName()).collect(Collectors.toList()));
        System.out.println("Python programmer, works from home: " + pythonFromHomeProgrammers);

        // Max JS salary size
        Comparator<Programmer> salaryComparator = new Comparator<Programmer>() {
            @Override
            public int compare(Programmer o1, Programmer o2) {
                return new Integer((int) ((o1.getSalary() - o2.getSalary()) * 100));
            }
        };
        double maxSalaryJS = programmers.stream()
                .filter(x -> x.getLanguage() == ProgrammingLanguage.JS)
                .max(salaryComparator)
                .get().getSalary();
        System.out.println("Max JS salary size: $" + maxSalaryJS);
    }
}
