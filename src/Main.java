import java.util.Arrays;

public class Main {

    // Rotate and array to the right by k
    //    Input: nums = [1,2,3,4,5,6,7], k = 3
    //    Output: [5,6,7,1,2,3,4]
    //    Explanation:
    //    rotate 1 steps to the right: [7,1,2,3,4,5,6]
    //    rotate 2 steps to the right: [6,7,1,2,3,4,5]
    //    rotate 3 steps to the right: [5,6,7,1,2,3,4]

    // naive solution using a temp int[] to store values
    // time complexity - O(n)
    public static void rotate1(int[] nums, int k) {
        // if k == nums.length -> no rotation is needed
        k = k % nums.length;
        int[] temp = new int[k];
        int numsIndex = nums.length - 1 - k;

        // since we rotate te array to right
        // we store the last k elements int temp int[]
        for (int i = 0; i < k; i++) {
            temp[i] = nums[nums.length - k + i];
        }

        // we copy the remaining elements starting from the last index
        for (int i = nums.length - 1 - k; i >= 0; i--) {
            nums[i + k] = nums[i];
        }

        // we insert the elements k stored in temp int[]
        // to the begining of the array
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }

    // naive solution - rotate the array by one for k times
    // Time complexity O(n^2)
    public static void rotate2(int[] nums, int k) {
        // if k == nums.length -> no rotation is needed
        k = k % nums.length;

        for (int i = 0; i < k; i++) {
            rotateOneTime(nums);
        }
    }

    // helper method to rotate the array to right by one
    public static void rotateOneTime(int[] array) {
        int n = array.length - 1;
        int temp = array[n];

        for (int i = n; i > 0; i--) {
            array[i] = array[i - 1];
        }

        array[0] = temp;
    }

    // the efficient solution
    // Time complexity O(n)
    public static void rotate3(int[] array, int k) {
        int n = array.length - 1;
        k = k % array.length;

        // reverse the hole array
        reverse(array, 0, n);

        // reverse the first k element;
        reverse(array, 0, k - 1);

        //reverse the remaining elements
        reverse(array, k, n);
    }

    // helper method to reverse an array from start to end
    public static void reverse(int[] array, int start, int end) {
        int n = array.length - 1;
        int temp = 0;

        while (start <= end) {
            temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        int k = 3;

        int[] array1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println("Array to rotate to the right by " + k + " steps: " + Arrays.toString(array1));

        System.out.println("First rotate method: ");
        rotate1(array1, k);
        System.out.println(Arrays.toString(array1));

        System.out.println("Second rotate method: ");
        int[] array2 = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate2(array2, k);
        System.out.println(Arrays.toString(array2));

        System.out.println("Third rotate method: ");
        int[] array3 = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate3(array3, k);
        System.out.println(Arrays.toString(array3));
    }
}