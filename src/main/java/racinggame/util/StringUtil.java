package racinggame.util;

public class StringUtil {

    public static boolean isEmptyOrNull(final String str) {
        return str == null || str.isEmpty() || str.trim().isEmpty();
    }

}
