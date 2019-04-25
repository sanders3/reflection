package net.buildbox.pluralsight.reflection.util;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import net.buildbox.pluralsight.reflection.util.fixture.Person;
import org.junit.Test;

import java.util.List;

public class MetamodelWithoutNamesTest {

    private final Metamodel<Person> metamodel = Metamodel.of(Person.class);

    @Test
    public void testPrimaryKey() {
        Metamodel.PrimaryKeyField primaryKey = metamodel.getPrimaryKey();
        assertThat(primaryKey.getName(), equalTo("id"));
        assertThat(primaryKey.getType(), equalTo(long.class));

        String string = primaryKey.toString();
        assertThat(string, containsString("PrimaryKeyField{"));
        assertThat(string, containsString("name=id"));
        assertThat(string, containsString("type=long"));
    }

    @Test
    public void testNameColumnFields() {
        List<Metamodel.ColumnField> columnFieldList = metamodel.getColumns();
        assertThat(columnFieldList.size(), is(2));

        Metamodel.ColumnField columnField = columnFieldList.get(0);
        assertThat(columnField.getName(), equalTo("name"));
        assertThat(columnField.getType(), equalTo(String.class));

        String string = columnField.toString();
        assertThat(string, containsString("ColumnField{"));
        assertThat(string, containsString("name=name"));
        assertThat(string, containsString("type=class java.lang.String"));
    }

    @Test
    public void testAgeColumnFields() {
        List<Metamodel.ColumnField> columnFieldList = metamodel.getColumns();
        assertThat(columnFieldList.size(), is(2));

        Metamodel.ColumnField columnField = columnFieldList.get(1);
        assertThat(columnField.getName(), equalTo("age"));
        assertThat(columnField.getType(), equalTo(int.class));

        String string = columnField.toString();
        assertThat(string, containsString("ColumnField{"));
        assertThat(string, containsString("name=age"));
        assertThat(string, containsString("type=int"));
    }
}

