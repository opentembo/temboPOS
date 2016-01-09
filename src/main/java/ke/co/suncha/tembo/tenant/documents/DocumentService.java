package ke.co.suncha.tembo.tenant.documents;

import ke.co.suncha.tembo.tenant.helpers.request.RestPageRequest;
import org.joda.time.DateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by maitha.manyala on 11/15/15.
 */
public interface DocumentService {
    Document create(Long userId, Document document);

    Document update(Long userId, Document document);

    Page<Document> findAll(Long userId, Integer documentType, RestPageRequest pageRequest);

    Page<Document> findAll(Long userId, Long parentId, Integer documentType, RestPageRequest pageRequest);

    Page<Document> findAll(Long userId, Long businessPartnerId, Integer businessPartnerType, Integer documentType, RestPageRequest pageRequest);

    List<Document> getAll(Long userId, Integer documentType);

    Document findOne(Long userId, Integer documentType, Long recordId);

    Document findOne(Long userId, Long recordId);

    Document findByDocNumber(Long userId, Integer documentType, String docNumber);

    Document findByOrderRefNumber(Long userId, Integer documentType, String orderRefNumber);

    Document findByDocNumber(Long userId, Integer documentType, Integer childDocumentType, String docNumber);

    void updateAmounts(Double totalTax, Double amountWithoutTax, Double totalAll, Integer quantity, Long userId, Long documentId);

    Double getBusinessPartnerBalance(Long userId, Long businessPartnerId);

    Double getDocumentAmount(Long userId, Long documentId);

    Double getAmountByDocumentByBusinessPartner(Long userId, Long businessPartnerId, Integer documentType, Integer childDocumentType);

    Double getInvoicePaymentsTotal(Long userId, Long businessPartnerId, Integer documentType, Integer childDocumentType, Long parentId);

    void updateDocumentBalance(Long userId, Long documentId);

    Double getSumByTenant(Long userId, Integer documentType, Integer status);

    Double getSumByTenantByDate(Long userId, Integer documentType, Integer status, DateTime startDate, DateTime endDate);

    Integer getQuantityByTenantByDate(Long userId, Integer documentType, Integer status, DateTime startDate, DateTime endDate);

    Double getSumByTenantByDateByBusinessUnit(Long userId, Integer documentType, Integer status, DateTime startDate, DateTime endDate,Long businessUnitId);

    Integer getQuantityByTenantByDateByBusinessUnit(Long userId, Integer documentType, Integer status, DateTime startDate, DateTime endDate,Long businessUnitId);

    Long countByTenant(Long userId, Integer documentType, Integer status);
}
