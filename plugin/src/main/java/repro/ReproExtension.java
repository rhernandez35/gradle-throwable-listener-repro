package repro;

import org.gradle.api.provider.Property;

public interface ReproExtension {
    Property<String> getErrorType();
}
