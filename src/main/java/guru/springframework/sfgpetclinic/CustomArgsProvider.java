package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

/**
 * @author : eanani
 * @project : testing-java-junit5
 * @created : 28/02/2022,
 **/
public class CustomArgsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                Arguments.of("FL", 7, 10),
                Arguments.of("OH", 11, 42),
                Arguments.of("MI", 44, 77)
        );
    }
}
