package net.buildbox.pluralsight.reflection.util;

import static java.util.stream.Collectors.toList;

import net.buildbox.pluralsight.reflection.annotation.Column;
import net.buildbox.pluralsight.reflection.annotation.PrimaryKey;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Stream;

public class Metamodel<T> {

    private final Class<T> targetClass;

    private Metamodel(Class<T> targetClass) {
        this.targetClass = targetClass;
    }

    public static <T> Metamodel<T> of(Class<T> targetClass) {
        return new Metamodel<>(targetClass);
    }

    public String getTableName() {
        return targetClass.getSimpleName().toLowerCase();
    }

    public PrimaryKeyField getPrimaryKey() {
        return Stream.of(targetClass.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(PrimaryKey.class))
                .findFirst()
                .map(PrimaryKeyField::new)
                .orElseThrow(() -> new IllegalArgumentException(
                        "No primary key found on " + targetClass.getSimpleName()));
    }

    public List<ColumnField> getColumns() {
        return Stream.of(targetClass.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Column.class))
                .map(ColumnField::new)
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

        public Class<?> getType() {
            return field.getType();
        }

        @Override
        public String toString() {
            return "PrimaryKeyField{"
                    + "name=" + getName()
                    + ", type=" + getType()
                    + '}';
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
            return "ColumnField{"
                    + "name=" + getName()
                    + ", type=" + getType()
                    + '}';
        }
    }
}
