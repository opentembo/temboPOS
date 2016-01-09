package ke.co.suncha.tembo.tenant.documents;


import ke.co.suncha.tembo.tenant.helpers.request.RestPageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by maitha.manyala on 11/15/15.
 */
@Service
public abstract class DocumentObject {
    @Autowired
    DocumentService documentService;

    public abstract Document create(Long userId, Document document);

    public abstract Document update(Long userId, Integer documentType, Long recordId, Document document);

    public abstract Document changeDocumentStatus(Long userId, Integer documentType, Long recordId, DocumentAction documentAction);

    public abstract void addPermissions();

    public Document findByDocNumber(Long userId, Integer documentType, String docNumber) {
        return documentService.findByDocNumber(userId, documentType, docNumber);
    }

    public Page<Document> findAll(Long userId, Integer documentType, RestPageRequest pageRequest) {
        return documentService.findAll(userId, documentType, pageRequest);
    }

    public List<Document> getAll(Long userId, Integer documentType) {
        return documentService.getAll(userId, documentType);
    }

    public Document findOne(Long userId, Integer documentType, Long recordId) {
        return documentService.findOne(userId, documentType, recordId);
    }

    public Page<Document> findAll(Long userId, Long businessPartnerId, Integer businessPartnerType, Integer documentType, RestPageRequest pageRequest) {
        return documentService.findAll(userId, businessPartnerId, businessPartnerType, documentType, pageRequest);
    }


    public Double getBusinessPartnerBalance(Long userId, Long businessPartnerId) {
        return documentService.getBusinessPartnerBalance(userId, businessPartnerId);
    }


    public Double getDocumentAmount(Long userId, Long documentId) {
        return documentService.getDocumentAmount(userId, documentId);
    }

    public Double getAmountByDocumentByBusinessPartner(Long userId, Long businessPartnerId, Integer documentType, Integer childDocumentType) {
        return documentService.getAmountByDocumentByBusinessPartner(userId, businessPartnerId, documentType, childDocumentType);
    }

    public Double getInvoicePaymentsTotal(Long userId, Long businessPartnerId, Integer documentType, Integer childDocumentType, Long parentId) {
        return documentService.getInvoicePaymentsTotal(userId, businessPartnerId, documentType, childDocumentType, parentId);
    }

    public Page<Document> findAll(Long userId, Long parentId, Integer documentType, RestPageRequest pageRequest) {
        return documentService.findAll(userId, parentId, documentType, pageRequest);
    }
}
