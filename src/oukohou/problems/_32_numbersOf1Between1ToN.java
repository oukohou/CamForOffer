package oukohou.problems;

/**
 * Created by oukohou on 2017/9/7.
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 * problem:
 * 统计从 1 到 n 的整数中， 其十进制表示共有多少个1.
 * 如输入12， 有1,10,11,12，共5个1.
 * tips：
 * 个位、十位、百位。。。依次统计。
 * 如 ：534 = （53*1+1）+（5*10+10）+（0*100+100）= 214
 */
public class _32_numbersOf1Between1ToN {

    public int findNumberOf1(int n) {
        if (n == 0) {
            return 0;
        }
        int sum = 0;
        int base = 1;
        int unitsDigit = 0;
        int counter = n;

        while (counter > 0) {
            unitsDigit = counter % 10;
            counter = counter / 10;
            sum = sum + counter * base;

            if (unitsDigit == 1) {
                sum = sum + n % base + 1;
            } else if (unitsDigit > 1) {
                sum = sum + base;
            }
            base = base * 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new _32_numbersOf1Between1ToN().findNumberOf1(12));
    }
}
