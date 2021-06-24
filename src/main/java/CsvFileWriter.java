import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CsvFileWriter {
    private static final String NEW_LINE_SEPARATOR = "\n";

    private static final Object [] FILE_HEADER = {"firstName","lastName","phone","address","age", "email"};

    public static void groupPeopleInFilesByLetters(Map<Character,List<Person>> mapOfUsers){
        mapOfUsers.keySet().forEach(key->{
            writeCsvFile(key.toString()+".csv",mapOfUsers.get(key));
        });
    }

    public static void writeCsvFile(String fileName, List<Person> people) {
        FileWriter fileWriter = null;

        CSVPrinter csvFilePrinter = null;

        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);

        try {
            fileWriter = new FileWriter(fileName);

            csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);

            csvFilePrinter.printRecord(FILE_HEADER);

            for (int i = 0; i < people.size(); i++) {
                List<String> list = new ArrayList<>();
                list.add(people.get(i).getName());
                list.add(people.get(i).getSurname());
                list.add(people.get(i).getPhone());
                list.add(people.get(i).getAddress());
                list.add(people.get(i).getAge());
                list.add(people.get(i).getEmail());
                csvFilePrinter.printRecord(list);
            }
            System.out.println("CSV file was created successfully !!!");
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
                csvFilePrinter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter/csvPrinter !!!");
                e.printStackTrace();
            }
        }

    }

}
