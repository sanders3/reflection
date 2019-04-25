package net.buildbox.pluralsight.reflection.util;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

public class MetamodelTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testNoPrimaryKey() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("No primary key found on PersonNoPrimaryKey");

        Metamodel<PersonNoPrimaryKey> metamodel = Metamodel.of(PersonNoPrimaryKey.class);
        metamodel.getPrimaryKey();
    }

}
