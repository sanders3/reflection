package net.buildbox.pluralsight.reflection.persist;

public interface EntityManager<T> {
    void persist(T t);
    T read(Class<?> targetClass, long primaryKey);
}
