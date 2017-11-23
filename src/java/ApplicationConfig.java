import java.util.Set;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJaxbJsonProvider;

/**
 *
 * @author Niki
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends javax.ws.rs.core.Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        resources.add(JacksonFeature.class);
        resources.add(JacksonJaxbJsonProvider.class);
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * do not modify
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.example.rest.RestService.class);
    }
}
