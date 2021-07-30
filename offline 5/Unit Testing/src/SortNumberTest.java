import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortNumberTest {


    boolean ALterCheck(List<Integer> SortedList, List<Integer> UnSortedList){
        for(int i = 0 ; i < UnSortedList.size(); i++){
            int count = 1;
            for(int j = 0 ; j < UnSortedList.size(); j++) {
                if (i != j && UnSortedList.get(i) == UnSortedList.get(j))
                    count++;
            }
            for(int j = 0 ; j < SortedList.size(); j++) {
                if (SortedList.get(j) == UnSortedList.get(i))
                    count--;
            }
            if(count != 0)
                return false;
        }
        return true;
    }

    boolean SortCheck(List<Integer> SortedList){
        if(SortedList.size() > 1){
            for(int i = 0 ; i < SortedList.size(); i++){
                if(i != SortedList.size()-1){
                    if(SortedList.get(i+1) < SortedList.get(i))
                        return false;
                }
            }
        }
        return true;
    }

    @Test
    void sortNumber1() {          //blank array
        SortNumber sortnumber = new SortNumber();
        List<Integer> blankarray = new ArrayList<>();
        List<Integer> UnSortedList = new ArrayList<>();
        UnSortedList = blankarray;
        System.out.println(UnSortedList);
        List<Integer> SortedList = sortnumber.sortNumber(blankarray);
        System.out.println(SortedList);
        assertEquals(true,SortCheck(SortedList));
        assertEquals(true,ALterCheck(SortedList,UnSortedList));
    }

    @Test
    void sortNumber2() {          //single element array
        SortNumber sortnumber = new SortNumber();
        List<Integer> singleelementarray = new ArrayList<>(Arrays.asList(5));
        List<Integer> UnSortedList = new ArrayList<>();
        UnSortedList = singleelementarray;
        System.out.println(UnSortedList);
        List<Integer> SortedList = sortnumber.sortNumber(singleelementarray);
        System.out.println(SortedList);
        assertEquals(true,SortCheck(SortedList));
        assertEquals(true,ALterCheck(SortedList,UnSortedList));
    }

    @Test
    void sortNumber3() {          //double element array
        SortNumber sortnumber = new SortNumber();
        List<Integer> doubleelementarray = new ArrayList<>(Arrays.asList(12,7));
        List<Integer> UnSortedList = new ArrayList<>();
        UnSortedList = doubleelementarray;
        System.out.println(UnSortedList);
        List<Integer> SortedList = sortnumber.sortNumber(doubleelementarray);
        System.out.println(SortedList);
        assertEquals(true,SortCheck(SortedList));
        assertEquals(true,ALterCheck(SortedList,UnSortedList));
    }

    @Test
    void sortNumber4() {          //random size array
        SortNumber sortnumber = new SortNumber();
        List<Integer> randomsizearray = new ArrayList<>();
        int size = (int) (Math.random() * 100);
        for(int i = 0; i < size; i++)
            randomsizearray.add(size - i + 2);
        List<Integer> UnSortedList = new ArrayList<>();
        UnSortedList = randomsizearray;
        System.out.println(UnSortedList);
        List<Integer> SortedList = sortnumber.sortNumber(randomsizearray);
        System.out.println(SortedList);
        assertEquals(true,SortCheck(SortedList));
        assertEquals(true,ALterCheck(SortedList,UnSortedList));
    }

    @Test
    void sortNumber5() {          //random element array
        SortNumber sortnumber = new SortNumber();
        List<Integer> randomelementarray = new ArrayList<>();
        for(int i = 0; i < 15; i++)
            randomelementarray.add(10 + (int) (Math.random() * 100));
        List<Integer> UnSortedList = new ArrayList<>();
        UnSortedList = randomelementarray;
        System.out.println(UnSortedList);
        List<Integer> SortedList = sortnumber.sortNumber(randomelementarray);
        System.out.println(SortedList);
        assertEquals(true,SortCheck(SortedList));
        assertEquals(true,ALterCheck(SortedList,UnSortedList));
    }

    @Test
    void sortNumber6() {          //sorted in ascenging order array
        SortNumber sortnumber = new SortNumber();
        List<Integer> sortedAscendingarray = new ArrayList<>();
        int randomNumber = (int) (Math.random() * 100);
        for(int i = 0; i < 16; i++)
            sortedAscendingarray.add(randomNumber + i + 5);
        List<Integer> UnSortedList = new ArrayList<>();
        UnSortedList = sortedAscendingarray;
        System.out.println(UnSortedList);
        List<Integer> SortedList = sortnumber.sortNumber(sortedAscendingarray);
        System.out.println(SortedList);
        assertEquals(true,SortCheck(SortedList));
        assertEquals(true,ALterCheck(SortedList,UnSortedList));
    }

    @Test
    void sortNumber7() {          //sorted in descenging order array
        SortNumber sortnumber = new SortNumber();
        List<Integer> sortedDescendingarray = new ArrayList<>();
        int randomNumber = (int) (Math.random() * 100);
        for(int i = 0; i < 12; i++)
            sortedDescendingarray.add(randomNumber - i + 5);
        List<Integer> UnSortedList = new ArrayList<>();
        UnSortedList = sortedDescendingarray;
        System.out.println(UnSortedList);
        List<Integer> SortedList = sortnumber.sortNumber(sortedDescendingarray);
        System.out.println(SortedList);
        assertEquals(true,SortCheck(SortedList));
        assertEquals(true,ALterCheck(SortedList,UnSortedList));
    }

    @Test
    void sortNumber8() {          //equal element array
        SortNumber sortnumber = new SortNumber();
        List<Integer> equalarray = new ArrayList<>();
        int randomNumber = (int) (Math.random() * 100);
        for(int i = 0; i < 14; i++)
            equalarray.add(randomNumber);
        List<Integer> UnSortedList = new ArrayList<>();
        UnSortedList = equalarray;
        System.out.println(UnSortedList);
        List<Integer> SortedList = sortnumber.sortNumber(equalarray);
        System.out.println(SortedList);
        assertEquals(true,SortCheck(SortedList));
        assertEquals(true,ALterCheck(SortedList,UnSortedList));
    }

    @Test
    void sortNumber9() {          //all positive element array
        SortNumber sortnumber = new SortNumber();
        List<Integer> positivearray = new ArrayList<>();
        for(int i = 0; i < 14; i++)
            positivearray.add((int) (Math.random() * 100));
        List<Integer> UnSortedList = new ArrayList<>();
        UnSortedList = positivearray;
        System.out.println(UnSortedList);
        List<Integer> SortedList = sortnumber.sortNumber(positivearray);
        System.out.println(SortedList);
        assertEquals(true,SortCheck(SortedList));
        assertEquals(true,ALterCheck(SortedList,UnSortedList));
    }

    @Test
    void sortNumber10() {          //all negative element array
        SortNumber sortnumber = new SortNumber();
        List<Integer> negativearray = new ArrayList<>();
        for(int i = 0; i < 14; i++)
            negativearray.add((int) (-Math.random() * 100));
        List<Integer> UnSortedList = new ArrayList<>();
        UnSortedList = negativearray;
        System.out.println(UnSortedList);
        List<Integer> SortedList = sortnumber.sortNumber(negativearray);
        System.out.println(SortedList);
        assertEquals(true,SortCheck(SortedList));
        assertEquals(true,ALterCheck(SortedList,UnSortedList));
    }

    @Test
    void sortNumber11() {          //negative+positive element array
        SortNumber sortnumber = new SortNumber();
        List<Integer> array = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            array.add((int) (Math.random() * 100));
            array.add((int) (-Math.random() * 100));
        }
        List<Integer> UnSortedList = new ArrayList<>();
        UnSortedList = array;
        System.out.println(UnSortedList);
        List<Integer> SortedList = sortnumber.sortNumber(array);
        System.out.println(SortedList);
        assertEquals(true,SortCheck(SortedList));
        assertEquals(true,ALterCheck(SortedList,UnSortedList));
    }
}
