package repro;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.build.event.BuildEventsListenerRegistry;

import javax.inject.Inject;

public abstract class ReproPlugin implements Plugin<Project> {
    @Inject
    public abstract BuildEventsListenerRegistry getEventsListenerRegistry();

    @Override
    public void apply(Project target) {
        var extension = target.getExtensions().create("repro", ReproExtension.class);

        getEventsListenerRegistry().onTaskCompletion(target.provider(() -> {
            var type = extension.getErrorType().get();
            if (type.equals("error")) {
                throw new Error("error");
            } else {
                throw new RuntimeException("runtime exception!");
            }
        }));
    }
}
