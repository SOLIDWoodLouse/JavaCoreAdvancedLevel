package lesson02;

public class ArraySummation {

    public int arraySummationResult(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException("Массив должен быть 4х4");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException("Массив должен быть 4х4");
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum = sum + Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("В одной из ячеек не числовое значение. Номер ячейки: " + i + " " + j);
                }
            }
        }
        return sum;
    }

}
