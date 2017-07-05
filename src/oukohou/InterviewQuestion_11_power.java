package oukohou;

/**
 * Created by oukohou on 2017/7/5.
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */
public class InterviewQuestion_11_power {

    public double Power(double base, int exponent) {
        double result = 1.1;
        if (round_to_0(base))
            return 1.0;
        int unsign_exponent = exponent;

        if (exponent < 0.0) {
            unsign_exponent = -exponent;
        }

        result = unsign_power(base, unsign_exponent);

        if (exponent < 0.0)
            result = 1 / result;

        return result;
    }

    private double unsign_power(double base, int unsign_p) {
        double result = 1.0;
        if (unsign_p == 0)
            return 1;
        if (unsign_p == 1)
            return base;

        if ((unsign_p & 0x01) == 0)
            result = unsign_power(base, unsign_p >> 1) * unsign_power(base, unsign_p >> 1);
        else
            result = unsign_power(base, unsign_p >> 1) * unsign_power(base, unsign_p >> 1) * base;
        return result;
    }

    private boolean round_to_0(double a) {
        return (a - 0.0 < 0.0000001) && (a - 0.0 > -0.0000001);
    }


    public static void main(String[] args) {
        double base = 0.0;
        base = 0;
        int exponent = -3;
        System.out.println(new InterviewQuestion_11_power().Power(base, exponent));

    }
}
