package lesson03;

public class Main {

    private final static String[] words = {"apple", "orange", "pumpkin", "egg", "potato", "tomato", "apple", "dog", "cat", "monkey"};

    public static void main(String[] args) {

        UniqueWord uniqueWord = new UniqueWord();
        Phonebook phonebook = new Phonebook();

        System.out.println(uniqueWord.wordsHashMap(words));

        phonebook.add("Vasja", "123");
        phonebook.add("Petja", "1233");
        phonebook.add("Vasja", "12345");
        phonebook.add("Jenja", "123456");

        phonebook.get("Vasja");

    }

}
