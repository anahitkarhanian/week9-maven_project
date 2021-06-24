import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CSVParser {
    public static Map<Character, List<Person>> parse() {
        Map<Character, List<Person>> collect = null;
        try {
            CSVReader reader =
                    new CSVReaderBuilder(new FileReader("C:\\Users\\Anahit\\IdeaProjects\\Maven_Project\\AllUsers.csv")).
                            withSkipLines(1).
                            build();
            collect = reader.readAll().stream().map(data -> {
                Person person = new Person(data[0], data[1], data[2], data[3], data[4], data[5]);
                return person;
            }).sorted(new MyComparator()).collect(Collectors.groupingBy(person1 -> person1.getSurname().charAt(0)));
            collect.forEach((key, value) -> System.out.println(key + " " + value));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return collect;
    }
}
