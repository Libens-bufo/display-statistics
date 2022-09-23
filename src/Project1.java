import java.util.Arrays;
import java.util.Scanner;


public class Project1 {
    //globals


    public static String[] readList(){
        Scanner in = new Scanner(System.in);

        // Read user input
        String input = in.nextLine();

        //Convert string input into usable integer array
        String[] inputSplit = input.split(" ");
        return inputSplit;

    }
    public static int[] getNums(String[] str, int length){
        int[] arr = new int[length];
        Scanner stdin = new Scanner(System.in);
        for (int i = 0; i < length; i++){
           arr[i] = Integer.parseInt(str[i]);
       }
        return arr;
    }
    static void selectOptions(int[] arr){

    }

    /**
     * Displays the statistics
     * @param arr The user inputs
     */
    public static void displayStats(int[] arr){


    }

    /**
     * Updates global variables containing the statistics
     * @param arr The array of user inputs
     */
    public static void getStats(int[] arr){


        //Math.round((variance(arr)) * 100.0) / 100.0;
    }

    /**
     * Returns the count of user inputs
     * @param arr The array of inputs
     * @return the count of elements(inputs)
     */
    public static int count (int[] arr){
        return arr.length;
    }

    /**
     *This function calculates the mean of an array of integers.
     * @param arr The array of inputs
     * @return the mean of the inputs
     */
    public static double mean(int[] arr){
        double total = 0;
        for(int i = 0; i <  arr.length; i++){
            total += arr[i];
        }
        return total / arr.length;
    }

    /**
     * Calculates the median of the user inputted integers
     *
     * @param arr The user inputs
     * @return the median
     */
    public static double median(int[] arr){
        double med;
        int mid = arr.length / 2;
        Arrays.sort(arr);

        if ((arr.length % 2) == 0){
            med = (arr[mid] + arr[mid-1]) / 2.0;
        }else{
            med = arr[mid];
        }
        return med;
    }

    /**
     * Determines if there is a mode
     *
     * @param arr The user inputs
     * @return Index of the mode, or -1 if no mode.
     */
    public static int mode(int[] arr){
        int maxCount = 1;
        int count;
        int index = -1;
        for(int i = 0; i <= arr.length - 1; i++){
            count = 0;
            for(int j = 0; j < arr.length; j++){
                if (arr[j] == arr[i]) count++;
            }
            if (count > maxCount){
                maxCount = count;
                index = i;
            }
        }
        return index;

    }

    public static int max(int[] arr){
        int maximum = arr[0];
        for(int el : arr){
            maximum = Math.max(el, maximum);
        }
        return maximum;
    }
    public static int min(int[] arr){
        int minimum = arr[0];
        for(int el : arr){
            minimum = Math.min(el, minimum);
        };
        return minimum;
    }

    public static int range(int[] arr){
        int minimum = min(arr), maximum = max(arr);
        if (minimum > -1) return maximum - minimum;
        else return maximum + Math.abs(minimum);

    };

    public static double variance(int[] arr){
        double result = 0;
        double mean = mean(arr);
        for(int i = 0; i < arr.length; i++){
            result += Math.pow(arr[i] - mean, 2);
        }
        return result / arr.length;
    }

    public static double stDev(int[] arr){
        return Math.pow(variance(arr), .5);
        //return Math.ceil(Math.pow(variance(arr), .5) * 100.0) / 100.0;
    };
    public static void main(String[] args) {

        String[] input; //user input
        int[] inputs;   //array of integers parsed from input

        int count, mode, min, max, range, even, odd, prime; //Integer variables
        double mean, median, variance, stdev;               //Floating point variables

        //Take user input to analyze
        input = readList();

        //Parses inputs to an integer array
        inputs = getNums(input, input.length);


        //Assigns proper values to variables
        count = count(inputs);
        mean = mean(inputs);
        median = median(inputs);
        mode = (mode(inputs) > -1) ? inputs[mode(inputs)] : -1;
        min = min(inputs);
        max = max(inputs);
        range = range(inputs);
        variance = variance(inputs);
        stdev = stDev(inputs);


        //Print Menu
        System.out.printf("\n" +
                "Please make a selection: \n" +
                "1) Display List Statistics\n" +
                "2) Display List Ordered\n" +
                "3) Number of Odd/Even\n" +
                "4) Check for Prime Numbers\n" +
                "5) Enter New List\n" +
                "exit) Quit Program\n"
        );

        //Gets Menu Option
        Scanner stdin = new Scanner(System.in);
        String selection = stdin.next();

        //Executes appropriate menu option selected by user
        if (selection.equals("1")) { //Display List Stats

            //Print statistics
            System.out.printf("" +
                    "Min: " + min + "\n" +
                    "Max: " + max + "\n" +
                    "Count: " + count + "\n" +
                    "Range: " + range + "\n" +
                    "Median " + median + "\n" +
                    "Mean: " + mean + "\n"
            );

            // Print mode
            if ((mode > -1)) {
                System.out.println("Mode: " + mode);
            } else {
                System.out.println("Mode: No Mode");
            }

            //Print Variance and Standard Deviation
            System.out.printf("" +
                            "Variance %.2f\n" +
                            "Standard Deviation %.2f\n",
                    variance,
                    stdev
            );
        }
        else if (selection.equals("2")){ // Display List Ordered
            displayOrderedList(inputs);
        }
        else if (selection.equals("3")){ //Number of Odd / Even

        }
        else if (selection.equals("4")){ //Check for primes

        }
        else if (selection.equals("5")){ //Enter a new list
            input = readList();
            inputs = getNums(input, input.length);
            for (int i = 0; i < inputs.length; i++){
                System.out.print("Num: " + inputs[i]+" ");
            }
        }
        else if (selection.equals("exit")){ //Exits program with status code 0
            System.out.print("Program Exiting");
            System.exit(0);

        }



    }

    private static void displayOrderedList(int[] arr) {
        Arrays.sort(arr);
        System.out.print("[");
        for (int i = 0; i < arr.length; i++ ){
            System.out.print("" + arr[i]);
            if (i != arr.length - 1) System.out.print(", ");
        };
        System.out.print("]");
    }


}
