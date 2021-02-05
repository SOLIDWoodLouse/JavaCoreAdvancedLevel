package lesson03;

import java.util.HashMap;
import java.util.HashSet;

public class Phonebook {

    private final HashMap<String, HashSet<String>> phonebook = new HashMap<>();

    public void add(String name, String phoneNumber) {
        HashSet<String> numbers = phonebook.getOrDefault(name, new HashSet<>());
        numbers.add(phoneNumber);
        phonebook.put(name, numbers);
    }

    public void get(String name) {
        System.out.println(name + " " + phonebook.getOrDefault(name, new HashSet<>()));
    }

}
