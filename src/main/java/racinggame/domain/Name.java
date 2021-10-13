package racinggame.domain;

import racinggame.domain.exception.NameEmptyOrNullException;
import racinggame.util.StringUtil;

import java.util.Objects;

public final class Name {

    private final String name;

    private Name(final String name) {
        validate(name);
        this.name = name;
    }

    public static Name from(final String name) {
        return new Name(name);
    }

    public String value() {
        return name;
    }

    private void validate(final String name) {
        if (StringUtil.isEmptyOrNull(name)) {
            throw new NameEmptyOrNullException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
