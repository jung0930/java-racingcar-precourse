package racinggame.domain;

import racinggame.domain.exception.NamesDuplicateException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Names {

    private static final String COMMA = ",";
    private static final int MIN_SIZE = 2;

    private Names(final String names) {
        validate(names);
    }

    public static Names from(final String names) {
        return new Names(names);
    }

    private void validate(final String names) {
        String[] splitedNames = names.split(COMMA);
        validateDuplicate(splitedNames);
    }

    private void validateDuplicate(final String[] splitedNames) {
        List<String> namesList = Arrays.asList(splitedNames);
        Set<String> namesSet = new HashSet<>(namesList);
        if (namesList.size() != namesSet.size()) {
            throw new NamesDuplicateException();
        }
    }

}
