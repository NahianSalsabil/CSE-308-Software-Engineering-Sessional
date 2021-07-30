import java.util.List;

public class SortNumber {
    List<Integer> sortNumber(List<Integer> numbers) {
        int  currentvalue, j;
        for (int i = 1; i < numbers.size(); i++) {
            currentvalue = numbers.get(i);
            j = i - 1;
            while (j >= 0 && numbers.get(j) > currentvalue) {
                numbers.set(j + 1, numbers.get(j));
                j = j - 1;
            }
            numbers.set(j + 1, currentvalue);
        }
        return numbers;
    }
}
