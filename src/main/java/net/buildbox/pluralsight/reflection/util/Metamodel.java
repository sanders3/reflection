package net.buildbox.pluralsight.reflection.util;

import static java.util.stream.Collectors.toList;

import net.buildbox.pluralsight.reflection.annotation.Column;
import net.buildbox.pluralsight.reflection.annotation.PrimaryKey;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Stream;

public class Metamodel<T> {

    private final Class<T> targetClass;

    public Metamodel(Class<T> targetClass) {
        this.targetClass = targetClass;
    }

    public static <T> Metamodel of(Class<T> targetClass) {
        return new Metamodel(targetClass);
    }

    public String getTableName() {
        return targetClass.getSimpleName().toLowerCase();
    }

    public PrimaryKeyField getPrimaryKey() {
        return Stream.of(targetClass.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(PrimaryKey.class))
                .findFirst()
                .map(f -> new PrimaryKeyField(f))
                .orElseThrow(() -> new IllegalArgumentException(
                        "No primary key found on " + targetClass.getSimpleName()));
    }

    public List<ColumnField> getColumns() {
        return Stream.of(targetClass.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Column.class))
                .map(f -> new ColumnField(f))
                .collect(toList());
    }

    public static class PrimaryKeyField {
        private final Field field;
        private final PrimaryKey annotation;

        private PrimaryKeyField(final Field field) {
            this.field = field;
            this.annotation = this.field.getAnnotation(PrimaryKey.class);
        }

        public String getName() {
            if (annotation.name().isEmpty()) {
                return field.getName();
            } else {
                return annotation.name();
            }
        }

        @Override
        public String toString() {
            return "PrimaryKeyField{" + "field=" + field.getName() + '}';
        }

        public Class<?> getType() {
            return field.getType();
        }
    }

    public static class ColumnField {
        private final Field field;
        private final Column annotation;

        private ColumnField(Field field) {
            this.field = field;
            this.annotation = this.field.getAnnotation(Column.class);
        }

        public String getName() {
            if (annotation.name().isEmpty()) {
                return field.getName();
            } else {
                return annotation.name();
            }
        }

        public Class<?> getType() {
            return field.getType();
        }

        @Override
        public String toString() {
            return "ColumnField{" + "field=" + field.getName() + '}';
        }
    }
}
