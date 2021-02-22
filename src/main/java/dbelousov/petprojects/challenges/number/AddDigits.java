package dbelousov.petprojects.challenges.number;

public class AddDigits {

    public static long addDigits(long num) {
        var sumOfDigits = 0;
        return addDigitsInternal(num, sumOfDigits);
    }

    private static long addDigitsInternal(long num, long sumOfDigits) {
        if (num > 0) {
            sumOfDigits += num % 10;
            return addDigitsInternal(num / 10, sumOfDigits);
        }

        return sumOfDigits;
    }
}
