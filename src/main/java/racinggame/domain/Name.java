package racinggame.domain;

import racinggame.domain.exception.NameEmptyOrNullException;
import racinggame.domain.exception.NameLengthOutOfRangeException;
import racinggame.util.StringUtil;

import java.util.Objects;

public class Name {

    private static final int MAX_LENGTH = 5;

    private final String name;

    private Name(String name) {
        validate(name);
        this.name = name;
    }

    public static Name from(String name) {
        return new Name(name);
    }

    public String value() {
        return name;
    }

    private void validate(String name) {
        if (StringUtil.isEmptyOrNull(name)) {
            throw new NameEmptyOrNullException();
        }
        if (name.length() > MAX_LENGTH) {
            throw new NameLengthOutOfRangeException();
            // System.out.println("[ERROR] 이름은 5글자 이하로 입력해주세요.");
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
