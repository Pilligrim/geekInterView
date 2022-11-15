package builder;

public class RunBuilder {
    public static void main(String[] args) {
        Person person = Person.builder().address("Street 1").age(30).country("Russia").phone("377-02-77")
                .firstName("Test").middleName("Testovich").lastName("Testov").build();
        System.out.println(person);
    }
}
