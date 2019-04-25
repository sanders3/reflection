package net.buildbox.pluralsight.reflection.util.fixture;

import net.buildbox.pluralsight.reflection.annotation.Column;

@SuppressWarnings("unused")
public class PersonNoPrimaryKey {

    private long id;

    @Column
    private String name;

    @Column
    private int age;

    public PersonNoPrimaryKey() {
    }

    public PersonNoPrimaryKey(String name, int age) {
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
