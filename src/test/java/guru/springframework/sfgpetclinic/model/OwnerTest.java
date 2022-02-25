package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("model")
class OwnerTest {

    @Test
    void dependentAssertions() {

        Owner owner = new Owner(1L, "Joe", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("12341231234");

        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Joe", owner.getFirstName(), "Firs Name didn't match"),
                        () -> assertEquals("Buck", owner.getLastName(), "Last Name didn't match")),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Key West", owner.getCity(), "City didn't match"),
                        () -> assertEquals("12341231234", owner.getTelephone(), "Telephone didn't match"))
        );

        assertThat(owner.getCity(), is("Key West"));
    }
}