package net.buildbox.pluralsight.reflection;

import net.buildbox.pluralsight.reflection.model.Person;
import net.buildbox.pluralsight.reflection.persist.EntityManagerImpl;

public class PlayWithEntityManager {
    public static void main(String[] args) {
        Person person = Person.of("Bill", 47);

        EntityManagerImpl<Person> em = new EntityManagerImpl<>();
        em.persist(person);

    }

}
