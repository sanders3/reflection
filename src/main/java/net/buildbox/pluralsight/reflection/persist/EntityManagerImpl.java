package net.buildbox.pluralsight.reflection.persist;

import static java.util.stream.Collectors.joining;

import net.buildbox.pluralsight.reflection.util.Metamodel;

import java.util.ArrayList;
import java.util.List;

public class EntityManagerImpl<T> implements EntityManager<T> {

    @Override
    public void persist(T t) {
        final List<String> columns = new ArrayList<>();

        final Metamodel metamodel = Metamodel.of(t.getClass());
        final Metamodel.PrimaryKeyField primaryKeyField = metamodel.getPrimaryKey();
        columns.add(primaryKeyField.getName());

        final List<Metamodel.ColumnField> columnFields = metamodel.getColumns();
        for (Metamodel.ColumnField columnField : columnFields) {
            columns.add(columnField.getName());
        }

        final String statement = buildStatement(columns, metamodel);


    }

    private String buildStatement(List<String> columns, Metamodel metamodel) {
        final String names = columns.stream().collect(joining(", "));
        final String placeholders = columns.stream().map(c -> "?").collect(joining(", "));

        final StringBuilder statement = new StringBuilder();
        return statement.append("INSERT INTO ").append(metamodel.getTableName())
                .append(" (").append(names).append(")")
                .append(" VALUES (").append(placeholders).append(")")
                .toString();
    }

    @Override
    public T read(Class<?> targetClass, long primaryKey) {
        return null;
    }
}
