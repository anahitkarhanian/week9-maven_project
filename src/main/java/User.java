import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.*;

public class User {
    private static final Faker instance = Faker.instance();
    private static final Random random = new Random();


    public static Person makePerson() {
        int ageInt = 10 + random.nextInt(65);
        String age = Integer.toString(ageInt);
        Person person = new Person(instance.name().firstName(), instance.name().lastName(), instance.phoneNumber().phoneNumber(),
                instance.address().fullAddress(), age, instance.internet().emailAddress());

        return person;
    }

    public static List<Person> getUsers() {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            people.add(makePerson());
        }

        return people;
    }
}
