package ke.co.suncha.tembo;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by maitha.manyala on 1/7/16.
 */
public class TemboServiceFactory {
    static AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ke.co.suncha.tembo.Application.class);

    public static <T> T getService(Class<T> cls) {
        return ctx.getBean(cls);
    }

    public static void init() {

    }
}
