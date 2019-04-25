package net.buildbox.pluralsight.reflection;

import net.buildbox.pluralsight.reflection.model.Person;
import net.buildbox.pluralsight.reflection.util.Metamodel;
import net.buildbox.pluralsight.reflection.util.Metamodel.ColumnField;
import net.buildbox.pluralsight.reflection.util.Metamodel.PrimaryKeyField;

import java.util.List;

public class PlayWithMetamodel {
    public static void main(String ... args) {
        Metamodel metamodel = Metamodel.of(Person.class);
        Metamodel.PrimaryKeyField primaryKeyField = metamodel.getPrimaryKey();
        System.out.println("primary key field: " + primaryKeyField.getName()
                + " with type " + primaryKeyField.getType());

        List<ColumnField> columnFields = metamodel.getColumns();
        System.out.println("column fields: ");
        for (ColumnField columnField : columnFields) {
            System.out.println(columnField.getName() + " with type " + columnField.getType());
        }

    }
}
