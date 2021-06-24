public class Main {
    public static void main(String[] args) {
        CsvFileWriter.writeCsvFile("AllUsers.csv", User.getUsers());
        CsvFileWriter.groupPeopleInFilesByLetters(CSVParser.parse());
    }
}
