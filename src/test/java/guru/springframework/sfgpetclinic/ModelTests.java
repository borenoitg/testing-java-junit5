package guru.springframework.sfgpetclinic;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

/**
 * @author : eanani
 * @project : testing-java-junit5
 * @created : 28/02/2022
 **/
@Tag("model")
public interface ModelTests {

    @BeforeEach
    default void beforeEachConsoleOutputer(@NotNull TestInfo testInfo) {
        System.out.println("Running Test - " + testInfo.getDisplayName());
    }
}
