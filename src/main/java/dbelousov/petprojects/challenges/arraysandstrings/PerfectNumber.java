package dbelousov.petprojects.challenges.arraysandstrings;

public class PerfectNumber {

    public static boolean isPerfectNumber(int num) {
        if (num < 0) {
            return false;
        }

        var originalNum = num;

        var divisorsSize = (int) Math.ceil(Math.log(num) / Math.log(2));
        var divisors = new int[divisorsSize];
        for (var i = 0; i < divisorsSize; i++) {
            num = (num + 2 - 1) / 2;
            divisors[i] = num;
        }

        var sumOfDivisors = 0;
        for (var div : divisors) {
            sumOfDivisors += div;
        }
        return sumOfDivisors == originalNum;
    }
}
