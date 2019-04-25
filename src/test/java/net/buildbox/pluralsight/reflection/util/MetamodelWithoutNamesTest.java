package net.buildbox.pluralsight.reflection.util;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import java.util.List;

public class MetamodelWithoutNamesTest {

    private Metamodel<Person> metamodel = Metamodel.of(Person.class);

    @Test
    public void testPrimaryKey() {
        Metamodel.PrimaryKeyField primaryKeyField = metamodel.getPrimaryKey();
        assertThat(primaryKeyField.getName(), equalTo("id"));
        assertThat(primaryKeyField.getType(), equalTo(long.class));
    }

    @Test
    public void testColumnFields() {
        List<Metamodel.ColumnField> columnFieldList = metamodel.getColumns();
        assertThat(columnFieldList.size(), is(2));

        Metamodel.ColumnField nameColumnField = columnFieldList.get(0);
        assertThat(nameColumnField.getName(), equalTo("name"));
        assertThat(nameColumnField.getType(), equalTo(String.class));

        Metamodel.ColumnField ageColumnField = columnFieldList.get(1);
        assertThat(ageColumnField.getName(), equalTo("age"));
        assertThat(ageColumnField.getType(), equalTo(int.class));
    }

}
