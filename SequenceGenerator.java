package Flatstack;

import java.util.ArrayList;

public class SequenceGenerator {
    private int number;
    private int height;

    public SequenceGenerator(int number, int height) {
        this.number = number;
        this.height = height;
    }

    public ArrayList<String> generate() {
        ArrayList<String> arrayList = new ArrayList<>();

        if (number < 0) {
            arrayList.add("-1");
        } else if (height <= 0) {
            arrayList.add("-2");
        } else {
            arrayList.add("" + number);
            for (int i = 1; i < height; i++) {
                char[] lastChars = arrayList.get(i - 1).toCharArray();
                StringBuilder stringBuilder = new StringBuilder();

                char newChar = lastChars[0];
                int count = 1;

                if (lastChars.length == 1) {
                    stringBuilder.append(count);
                    stringBuilder.append(newChar);
                }

                for (int j = 1; j < lastChars.length; j++) {
                    if (lastChars[j] == lastChars[j - 1]) {
                        count++;
                    } else {
                        stringBuilder.append(count);
                        stringBuilder.append(newChar);
                        newChar = lastChars[j];
                        count = 1;
                    }
                    if (j == lastChars.length - 1) {
                        stringBuilder.append(count);
                        stringBuilder.append(newChar);
                    }
                }
                arrayList.add(stringBuilder.toString());
            }
        }
        return arrayList;
    }
}
