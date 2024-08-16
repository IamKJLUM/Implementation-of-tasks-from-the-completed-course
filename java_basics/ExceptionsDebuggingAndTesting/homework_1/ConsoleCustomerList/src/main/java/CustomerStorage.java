import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws IncorrectMail, IncorrectName, IncorrectPhoneNumber, IncorrectNumberOfArguments{
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;
        final String PHONE_REGULAR = "((\\+7|8)(\\s|-)?" +
                "((([\\d]{3})(\\s|-)?){2}" +
                "((\\d){2}(\\s|-)?(\\d){2})|((\\d){4})))";
        final String NAME_SURNAME_REGULAR = "((([a-zA-Z]|[а-яА-Я])\\s*)+){2}";
        final String MAIL_REGEX = "(([a-zA-Z])(-|.)?){1,20}@([a-zA-Z]){1,20}\\.([a-zA-Z]){2,8}";

        String[] components = data.split("\\s+");
        if (components.length <= 3 || components.length > 4) throw new IncorrectNumberOfArguments("Incorrect number of arguments");

        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];

        if (name.matches(NAME_SURNAME_REGULAR)) {
            String phoneNumber = components[INDEX_PHONE];
            if (phoneNumber.matches(PHONE_REGULAR)) {
                String mail = components[INDEX_EMAIL];
                if (mail.matches(MAIL_REGEX)) {
                    storage.put(name, new Customer(name, phoneNumber, mail));
                    return;
                }
                throw new IncorrectMail("the specified mail is incorrect");
            }
            throw new IncorrectPhoneNumber("The specified phone number is incorrect");
        }
        throw new IncorrectName("The specified name is incorrect");
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}