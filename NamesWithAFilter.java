import java.util.Arrays;
import java.util.List;

public class NamesWithAFilter {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Rajeev", "Ankit", "Sumit", "Aman", "Neha", "Rohit");
        List<String> names1 = Arrays.asList("Rajeev", "Ankit", "Sumit", "Aman", "Neha", "Rohit");

        System.out.println("Names containing 'a':");

        names.stream()
                .filter(name -> name.toLowerCase().contains("a"))
                .forEach(System.out::println);

        names1.stream()
        .filter(names4 -> names4.toLowerCase().contains("a")).forEach(System.out::println);

        names1.stream()
                .filter(name -> name.toLowerCase().contains("a"))
                .forEach(System.out::println);

    }
}
