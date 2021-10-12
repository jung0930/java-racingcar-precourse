package racinggame.domain;

import racinggame.domain.exception.NamesDuplicateException;
import racinggame.domain.exception.NamesNotDualException;

import java.util.*;

public final class Names {

    private static final String COMMA = ",";
    private static final int MIN_SIZE = 2;

    private final List<Name> names;

    private Names(final String names) {
        validate(names);
        this.names = convertCarNames(names);
    }

    public static Names from(final String names) {
        return new Names(names);
    }

    private void validate(final String names) {
        String[] splitedNames = names.split(COMMA);
        if (splitedNames.length < MIN_SIZE) {
            throw new NamesNotDualException();
        }
        validateDuplicate(splitedNames);
    }

    private void validateDuplicate(final String[] splitedNames) {
        List<String> namesList = Arrays.asList(splitedNames);
        Set<String> namesSet = new HashSet<>(namesList);
        if (namesList.size() != namesSet.size()) {
            throw new NamesDuplicateException();
        }
    }

    private List<Name> convertCarNames(final String carNames) {
        List<Name> names = new ArrayList<>();
        for (String name : carNames.split(COMMA)) {
            names.add(Name.from(name));
        }
        return names;
    }

    public List<Name> value() {
        return names;
    }

}
