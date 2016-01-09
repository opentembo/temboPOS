package ke.co.suncha.tembo.tenant.documents.SalesOrder;

import ke.co.suncha.tembo.tenant.documents.*;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;

/**
 * Created by maitha.manyala on 11/16/15.
 */
@Service
public class SalesOrder extends DocumentObject {
    @Override
    public Document create(Long userId, Document document) {
        return null;
    }

    @Override
    public Document update(Long userId, Integer documentType, Long recordId, Document document) {
        return null;
    }

    @Override
    public Document changeDocumentStatus(Long userId, Integer documentType, Long recordId, DocumentAction documentAction) {
        return null;
    }

    @Override
    public void addPermissions() {

    }
}
