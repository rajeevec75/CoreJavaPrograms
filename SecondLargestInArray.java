public class SecondLargestInArray {
    public static void main(String[] args) {
        int[] arr = {5, 12, 8, 20, 3};

        if (arr.length < 2) {
            System.out.println("Array must contain at least two elements.");
            return;
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("There is no second largest element (all elements might be equal).");
        } else {
            System.out.println("Second largest element is: " + secondLargest);
        }
    }
}
