package net.buildbox.pluralsight.reflection.persist;

import static java.util.stream.Collectors.joining;

import net.buildbox.pluralsight.reflection.util.Metamodel;
import net.buildbox.pluralsight.reflection.util.Metamodel.ColumnField;
import net.buildbox.pluralsight.reflection.util.Metamodel.PrimaryKeyField;

import java.util.ArrayList;
import java.util.List;

public class EntityManagerImpl<T> implements EntityManager<T> {

    @Override
    public void persist(T t) {
        final List<String> columns = new ArrayList<>();

        final Metamodel<T> metamodel = Metamodel.of(t.getClass());
        final PrimaryKeyField primaryKeyField = metamodel.getPrimaryKey();
        columns.add(primaryKeyField.getName());

        final List<ColumnField> columnFields = metamodel.getColumns();
        for (ColumnField columnField : columnFields) {
            columns.add(columnField.getName());
        }

        final String statement = buildStatement(columns, metamodel);


    }

    private String buildStatement(List<String> columns, Metamodel<T> metamodel) {
        final String names = String.join(", ", columns);
        final String placeholders = columns.stream().map(c -> "?").collect(joining(", "));

        return "INSERT INTO " + metamodel.getTableName() + " (" + names + ")"
                + " VALUES (" + placeholders + ")";
    }

    @Override
    public T read(Class<?> targetClass, long primaryKey) {
        return null;
    }
}
