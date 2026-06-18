package problems;

public class EncodeNumber {
    public String encode(int num) {
        return Integer.toBinaryString(num + 1).substring(1);
    }
}
