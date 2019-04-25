package net.buildbox.pluralsight.reflection.util;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import net.buildbox.pluralsight.reflection.util.Metamodel.ColumnField;
import net.buildbox.pluralsight.reflection.util.Metamodel.PrimaryKeyField;

import net.buildbox.pluralsight.reflection.util.fixture.PersonWithNames;
import org.junit.Test;

import java.util.List;

public class MetamodelWithNamesTest {

    private final Metamodel<PersonWithNames> metamodel = Metamodel.of(PersonWithNames.class);

    @Test
    public void testPrimaryKey() {
        PrimaryKeyField primaryKey = metamodel.getPrimaryKey();
        assertThat(primaryKey.getName(), equalTo("person_id"));
        assertThat(primaryKey.getType(), equalTo(long.class));

        String string = primaryKey.toString();
        assertThat(string, containsString("PrimaryKeyField{"));
        assertThat(string, containsString("name=person_id"));
        assertThat(string, containsString("type=long"));
    }

    @Test
    public void testNameColumnFields() {
        List<ColumnField> columnFieldList = metamodel.getColumns();
        assertThat(columnFieldList.size(), is(2));

        ColumnField columnField = columnFieldList.get(0);
        assertThat(columnField.getName(), equalTo("person_name"));
        assertThat(columnField.getType(), equalTo(String.class));

        String string = columnField.toString();
        assertThat(string, containsString("ColumnField{"));
        assertThat(string, containsString("name=person_name"));
        assertThat(string, containsString("type=class java.lang.String"));
    }

    @Test
    public void testAgeColumnFields() {
        List<ColumnField> columnFieldList = metamodel.getColumns();
        assertThat(columnFieldList.size(), is(2));

        ColumnField columnField = columnFieldList.get(1);
        assertThat(columnField.getName(), equalTo("person_age"));
        assertThat(columnField.getType(), equalTo(int.class));

        String string = columnField.toString();
        assertThat(string, containsString("ColumnField{"));
        assertThat(string, containsString("name=person_age"));
        assertThat(string, containsString("type=int"));
    }

}
