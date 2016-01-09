package ke.co.suncha.tembo.tenant.utils.timezones;

import java.io.Serializable;

/**
 * Created by maitha.manyala on 10/12/15.
 */

public class TemboTimeZone  implements Serializable {
    private long timeZoneId;
    private String name;
    private String zoneOffset;

    public long getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(long timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZoneOffset() {
        return zoneOffset;
    }

    public void setZoneOffset(String zoneOffset) {
        this.zoneOffset = zoneOffset;
    }
}
