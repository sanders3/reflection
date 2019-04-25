package net.buildbox.pluralsight.reflection.util;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import java.util.List;

public class MetamodelWithNamesTest {

    private Metamodel<PersonWithNames> metamodel = Metamodel.of(PersonWithNames.class);

    @Test
    public void testPrimaryKey() {
        Metamodel.PrimaryKeyField primaryKey = metamodel.getPrimaryKey();
        assertThat(primaryKey.getName(), equalTo("person_id"));
        assertThat(primaryKey.getType(), equalTo(long.class));
    }

    @Test
    public void testColumnFields() {
        List<Metamodel.ColumnField> columnFieldList = metamodel.getColumns();
        assertThat(columnFieldList.size(), is(2));

        Metamodel.ColumnField nameColumnField = columnFieldList.get(0);
        assertThat(nameColumnField.getName(), equalTo("person_name"));
        assertThat(nameColumnField.getType(), equalTo(String.class));

        Metamodel.ColumnField ageColumnField = columnFieldList.get(1);
        assertThat(ageColumnField.getName(), equalTo("person_age"));
        assertThat(ageColumnField.getType(), equalTo(int.class));
    }

}
