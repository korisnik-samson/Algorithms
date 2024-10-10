package lib;

import org.jetbrains.annotations.NotNull;

public class RandomString {

    public static @NotNull String randomString(int capacity) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(capacity);

        for (int i = 0; i < capacity; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }

}
