package ke.co.suncha.tembo.tenant.helpers;

import org.springframework.stereotype.Service;

/**
 * Created by maitha.manyala on 10/18/15.
 */

public class TemboConfig {
    public static final String EMAIL_QUEUE = "EMAIL_QUEUE";
    public static final String RABBITMQ_HOST = "localhost";
    public static final String APP_NAME = "OpenTembo POS";
    public static final Integer APP_VERSION = 1;

    public static String getAppName() {
        return APP_NAME + " v" + APP_VERSION;
    }
}
