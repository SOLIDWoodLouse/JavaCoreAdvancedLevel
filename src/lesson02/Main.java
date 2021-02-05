package lesson02;

public class Main {

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {

        String[][] strings = {{"1", "1", "1", "1"}, {"2", "2", "2"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};

        ArraySummation arraySummation = new ArraySummation();

        System.out.println(arraySummation.arraySummationResult(strings));

    }
}
