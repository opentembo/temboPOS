package ke.co.suncha.tembo.tenant.documents;

import ke.co.suncha.tembo.tenant.helpers.request.RestPageRequest;
import org.joda.time.DateTime;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by maitha.manyala on 1/7/16.
 */
@Service
public class DocumentServiceImpl implements DocumentService {
    @Override
    public Document create(Long userId, Document document) {
        return null;
    }

    @Override
    public Document update(Long userId, Document document) {
        return null;
    }

    @Override
    public Page<Document> findAll(Long userId, Integer documentType, RestPageRequest pageRequest) {
        return null;
    }

    @Override
    public Page<Document> findAll(Long userId, Long parentId, Integer documentType, RestPageRequest pageRequest) {
        return null;
    }

    @Override
    public Page<Document> findAll(Long userId, Long businessPartnerId, Integer businessPartnerType, Integer documentType, RestPageRequest pageRequest) {
        return null;
    }

    @Override
    public List<Document> getAll(Long userId, Integer documentType) {
        return null;
    }

    @Override
    public Document findOne(Long userId, Integer documentType, Long recordId) {
        return null;
    }

    @Override
    public Document findOne(Long userId, Long recordId) {
        return null;
    }

    @Override
    public Document findByDocNumber(Long userId, Integer documentType, String docNumber) {
        return null;
    }

    @Override
    public Document findByOrderRefNumber(Long userId, Integer documentType, String orderRefNumber) {
        return null;
    }

    @Override
    public Document findByDocNumber(Long userId, Integer documentType, Integer childDocumentType, String docNumber) {
        return null;
    }

    @Override
    public void updateAmounts(Double totalTax, Double amountWithoutTax, Double totalAll, Integer quantity, Long userId, Long documentId) {

    }

    @Override
    public Double getBusinessPartnerBalance(Long userId, Long businessPartnerId) {
        return null;
    }

    @Override
    public Double getDocumentAmount(Long userId, Long documentId) {
        return null;
    }

    @Override
    public Double getAmountByDocumentByBusinessPartner(Long userId, Long businessPartnerId, Integer documentType, Integer childDocumentType) {
        return null;
    }

    @Override
    public Double getInvoicePaymentsTotal(Long userId, Long businessPartnerId, Integer documentType, Integer childDocumentType, Long parentId) {
        return null;
    }

    @Override
    public void updateDocumentBalance(Long userId, Long documentId) {

    }

    @Override
    public Double getSumByTenant(Long userId, Integer documentType, Integer status) {
        return null;
    }

    @Override
    public Double getSumByTenantByDate(Long userId, Integer documentType, Integer status, DateTime startDate, DateTime endDate) {
        return null;
    }

    @Override
    public Integer getQuantityByTenantByDate(Long userId, Integer documentType, Integer status, DateTime startDate, DateTime endDate) {
        return null;
    }

    @Override
    public Double getSumByTenantByDateByBusinessUnit(Long userId, Integer documentType, Integer status, DateTime startDate, DateTime endDate, Long businessUnitId) {
        return null;
    }

    @Override
    public Integer getQuantityByTenantByDateByBusinessUnit(Long userId, Integer documentType, Integer status, DateTime startDate, DateTime endDate, Long businessUnitId) {
        return null;
    }

    @Override
    public Long countByTenant(Long userId, Integer documentType, Integer status) {
        return null;
    }
}
