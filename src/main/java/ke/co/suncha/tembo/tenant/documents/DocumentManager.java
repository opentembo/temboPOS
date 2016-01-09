package ke.co.suncha.tembo.tenant.documents;

import ke.co.suncha.tembo.tenant.helpers.request.RestPageRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by maitha.manyala on 11/15/15.
 */
@Service
public class DocumentManager {

    public Document create(DocumentObject documentObject, Long userId, Document document) {
        return documentObject.create(userId, document);
    }

    public Document update(DocumentObject documentObject, Integer documentType, Long userId, Long recordId, Document document) {
        return documentObject.update(userId, documentType, recordId, document);
    }

    public Document findByDocNumber(DocumentObject documentObject, Long userId, Integer documentType, String docNumber) {
        return documentObject.findByDocNumber(userId, documentType, docNumber);
    }

    public Page<Document> findAll(DocumentObject documentObject, Long userId, Integer documentType, RestPageRequest pageRequest) {
        return documentObject.findAll(userId, documentType, pageRequest);
    }

    public Page<Document> findAll(DocumentObject documentObject,Long userId, Long businessPartnerId, Integer businessPartnerType, Integer documentType, RestPageRequest pageRequest) {
        return documentObject.findAll(userId, businessPartnerId, businessPartnerType, documentType, pageRequest);
    }

    public List<Document> getAll(DocumentObject documentObject, Long userId, Integer documentType) {
        return documentObject.getAll(userId, documentType);
    }

    public Document findOne(DocumentObject documentObject, Long userId, Integer documentType, Long recordId) {
        return documentObject.findOne(userId, documentType, recordId);
    }

    public Document changeDocumentStatus(DocumentObject documentObject, Integer documentType, Long userId, Long recordId, DocumentAction documentAction) {
        return documentObject.changeDocumentStatus(userId, documentType, recordId, documentAction);
    }

    public Page<Document> findAll(DocumentObject documentObject, Long userId, Long parentId, Integer documentType, RestPageRequest pageRequest) {
        return documentObject.findAll(userId, parentId, documentType, pageRequest);


    }
}
