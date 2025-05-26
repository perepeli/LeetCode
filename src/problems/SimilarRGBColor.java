package problems;

public class SimilarRGBColor {
    public String similarRGB(String color) {
        StringBuilder similar = new StringBuilder();
        similar.append("#");
        for (int i = 1; i < 6; i+=2) {
            similar.append(similarColorHelper(color.substring(i, i+2)));
        }

        return similar.toString();
    }

    String similarColorHelper(String color){
        return Integer.toHexString(Math.round((float) Integer.parseInt(color, 16) / 17)).repeat(2);
    }
}
