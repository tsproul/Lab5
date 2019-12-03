import java.util.Scanner;

public class NumericConversion {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        boolean quit = true;

        do {
            System.out.println("Decoding Menu \n -------------" + // starts the menu for the user to see
                    "\n 1. Decode hexadecimal " +
                    "\n 2. Decode binary" +
                    "\n 3. Convert binary to hexadecimal " +
                    "\n 4. Quit");
            System.out.print("Please enter an option: ");

            int numericChoice = scanner.nextInt(); // allows the user to put in the input to choose the option
            String input;

            switch (numericChoice) { // switches through the different options for the user to choose
                case 1:
                    System.out.println("Please enter the numeric string to convert: ");
                    input = scanner.next();

                    System.out.println("Result: " + hexStringDecode(input)); // converts to hexadecimal
                    break;

                case 2:
                    System.out.println("Please enter the numeric string to convert: ");
                    input = scanner.next();

                    System.out.println("Result: " + binaryStringDecode(input)); // converts to binary
                    break;
                case 3:
                    System.out.println("Please enter the numeric string to convert: ");
                    input = scanner.next();

                    System.out.println("Result: " + binaryToHex(input)); // converts from binary to hexadecimal
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    quit = false; // leaves the while loop
            }



        }while(quit == true);

    }

public static long hexStringDecode(String hex) {

        long output = 0;
        int counting = 0;
        if (hex.substring(0, 2).equals("0x")) { // ignores the 0x in front of some hexadecimal function
            hex = hex.substring(2); // starts the counting to numbers past the 0x
        }


        for(int i = hex.length() - 1; i >= 0; i--) {
            output += (Math.pow(16, i) * hexCharDecode(hex.charAt(counting))); // puts the decimal into the 16th power for every character
            // also converts the number into hexadecimal form with letters A-F
            counting++;
        }
        return output; // returns the new decimal number



}

public static short hexCharDecode(char digit) { //converts regular numbers into hexadecimal characters
    short numberHex = 0;
    digit = Character.toUpperCase(digit);

    switch (digit) { // uses a switch case to convert each individual number into hexadecimal form
        case '0':
            numberHex = 0;
            break;
        case '1':
            numberHex = 1;
            break;
        case '2':
            numberHex  = 2;
            break;
        case '3':
            numberHex = 3;
            break;
        case '4':
            numberHex = 4;
            break;
        case '5':
            numberHex = 5;
            break;
        case '6':
            numberHex = 6;
            break;
        case '7':
            numberHex = 7;
            break;
        case '8':
            numberHex = 8;
            break;
        case '9':
            numberHex = 9;
            break;
        case 'A':
            numberHex = 10;
            break;
        case 'B':
            numberHex = 11;
            break;
        case 'C':
            numberHex = 12;
            break;
        case 'D':
            numberHex = 13;
            break;
        case 'E' :
            numberHex = 14;
            break;
        case 'F':
            numberHex = 15;
            break;
        }
        return numberHex; // returns the new hexadecimal digit
    }


public static short binaryStringDecode(String binary) { // method converts from binary to decimal
    if (binary.substring(0, 2).equals("0b")) { // skips the 0b in front of binary numbers, starts past the 0b
        binary = binary.substring(2);
    }

    short value = 0;
    short anotherSum = 0;


    for (int j = 1; j <= binary.length(); j++) { // find the binary number at the point
        value = (short) Character.getNumericValue(binary.charAt(binary.length() - j)); // gets the number at that point starting from right to left
        anotherSum += (short) (value * Math.pow(2, j - 1)); // multiplies the number by 2 to the specific power at that number
         // System.out.println(anotherSum); tested the loop to see if it worked
    }


    return Short.parseShort(String.valueOf(anotherSum)); // returns the decimal number
    }

public static String binaryToHex (String binary) { // converts from binary to hexadecimal
    int length = 4;
    String hexConverter = ("0123456789ABCDEF"); // pulls out the specific character at the char value
    String hexadecimal = "";
    int quadSum = 0;
    int start = 0;
    int end = 0;
    String finalHex = "";
    String total = "";


    if (binary.length() % 4 != 0) { // adds extra zeroes to make the number in group of 4s
        int count = 0;
        int bin = binary.length() % 4;
        while (count < (length - bin)) {
            binary = "0" + binary;
            count++; // adds zeros until the binary can be grouped in four
        }
    }

    int group = binary.length() / 4; // calculates how many groups there are in a number


    finalHex = "";
    for (int i = 1; i <= group; i++) { // does the loop for as many groups of 4 there are
        start = (4 * i) - 4;
        end = (4 * i);
        total = (binary.substring(start, end)); // reverses the start of counting to go from right to left
        quadSum = 0;
        int placeValue = 0;

        for (int j = 1; j <= total.length(); j++) { // calculates the hexadecimal for each group of four
            placeValue = Character.getNumericValue(total.charAt(4 - j)); // gets the value of the digit at that place from right to left
            quadSum += (int) (placeValue * Math.pow(2, j - 1)); // multiplies the number at that place by the specific power of 2 in that group
        }

        hexadecimal = String.valueOf(hexConverter.charAt(quadSum)); // converts the number from regular to hexadecimal format
        finalHex += String.valueOf(new StringBuilder().append(hexadecimal)); // adds each individual character together into one string

    }
    return finalHex; // returns the new hexadecimal digit

} }



