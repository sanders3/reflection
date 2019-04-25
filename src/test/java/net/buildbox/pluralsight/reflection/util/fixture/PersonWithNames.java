package net.buildbox.pluralsight.reflection.util.fixture;

import net.buildbox.pluralsight.reflection.annotation.Column;
import net.buildbox.pluralsight.reflection.annotation.PrimaryKey;

@SuppressWarnings("unused")
public class PersonWithNames {

    @PrimaryKey(name = "person_id")
    private long id;

    @Column(name = "person_name")
    private String name;

    @Column(name = "person_age")
    private int age;

    public PersonWithNames() {
    }

    public PersonWithNames(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
