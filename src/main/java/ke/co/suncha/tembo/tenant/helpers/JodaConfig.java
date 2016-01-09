package ke.co.suncha.tembo.tenant.helpers;

import org.joda.time.DateTimeZone;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by maitha.manyala on 11/7/15.
 */
@Service
public class JodaConfig {

    @PostConstruct
    public void setDefaultTimeZone() {
        DateTimeZone.setDefault(DateTimeZone.UTC);
    }
}
