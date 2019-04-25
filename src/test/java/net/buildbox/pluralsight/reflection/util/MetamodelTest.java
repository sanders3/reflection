package net.buildbox.pluralsight.reflection.util;

import net.buildbox.pluralsight.reflection.util.fixture.PersonNoPrimaryKey;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MetamodelTest {

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void testNoPrimaryKey() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("No primary key found on PersonNoPrimaryKey");

        Metamodel<PersonNoPrimaryKey> metamodel = Metamodel.of(PersonNoPrimaryKey.class);
        metamodel.getPrimaryKey();
    }

}
