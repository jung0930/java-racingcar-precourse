package racinggame.domain;

import racinggame.domain.exception.NamesDuplicateException;
import racinggame.domain.exception.NamesNotDualException;

import java.util.*;

public class Names {

    private static final String COMMA = ",";
    private static final int MIN_SIZE = 2;

    private final List<Name> names;

    private Names(String carNames){
        validate(carNames);
        this.names = convertCarNames(carNames);
    }

    public static Names from(String carNames) {
        return new Names(carNames);
    }

    private void validate(String carNames) {
        List<String> names = Arrays.asList(carNames.split(COMMA));
        Set<String> namesSet = new HashSet<>(names);
        if(names.size() < MIN_SIZE) {
            throw new NamesNotDualException();
        }
        if(names.size() != namesSet.size()) {
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
