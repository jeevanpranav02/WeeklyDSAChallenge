public class NextPermutation {
    public static void main(String[] args) {
        int[] array = { 1, 4, 5, 7, 8, 3, 5, 4, 2 };
        nextPermutation(array);
        for(int i : array)
        {
            System.out.println(i);
        }
    }

    static void nextPermutation(int[] array) {
        if (array.length <= 2) {
            swap(array, 0, 1);
        } else {
            int i = array.length - 2;
            while (i >= 0 && array[i] >= array[i+1]) {i--;}
            if (i >= 0) {
                int j = array.length - 1;
                while (j > i && array[i] >= array[j]) {j--;}
                swap(array, i, j);
            }
            reverse(array, i+1, array.length - 1);
        }
    }
    
    static void swap(int[] array, int i, int j) {
        if (j < array.length) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
    
    
    static void reverse(int[] array, int i, int j) {
        while (i < j) swap(array, i++, j--);
    }
}
