package ladder.domain;

import ladder.utils.ValidationUtils;

public class Person {
    private String name;

    public Person(String name) {
        ValidationUtils.validName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
