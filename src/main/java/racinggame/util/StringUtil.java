package racinggame.util;

public final class StringUtil {

    public static boolean isEmptyOrNull(final String str) {
        return str == null || str.isEmpty() || str.trim().isEmpty();
    }

}
