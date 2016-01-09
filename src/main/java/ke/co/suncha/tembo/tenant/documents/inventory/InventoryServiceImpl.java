package ke.co.suncha.tembo.tenant.documents.inventory;

import ke.co.suncha.tembo.tenant.helpers.request.RestPageRequest;
import ke.co.suncha.tembo.tenant.organization.warehousing.Warehouse;
import ke.co.suncha.tembo.tenant.products.Product;
import ke.co.suncha.tembo.tenant.products.attributes.set.instance.values.AttributeValueInstance;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by maitha.manyala on 1/7/16.
 */
@Service
public class InventoryServiceImpl implements InventoryService {
    @Override
    public Inventory create(Long userId, Integer documentType, Long documentId, Inventory inventory) {
        return null;
    }

    @Override
    public Inventory update(Long userId, Inventory inventory) {
        return null;
    }

    @Override
    public Inventory findOne(Long userId, Long recordId) {
        return null;
    }

    @Override
    public List<Warehouse> getByProduct(Long userId, Long productId) {
        return null;
    }

    @Override
    public TemboPage<Product> getByWarehouse(Long userId, Long warehouseId, RestPageRequest pageRequest) {
        return null;
    }

    @Override
    public Page<Inventory> findAll(Long userId, Integer documentType, Long documentId, RestPageRequest pageRequest) {
        return null;
    }

    @Override
    public Page<Inventory> findAll(Long userId, RestPageRequest pageRequest) {
        return null;
    }

    @Override
    public Boolean removeLine(Long userId, Long documentId, Inventory inventory) {
        return null;
    }

    @Override
    public Inventory updateAttributeValues(Long userId, Long inventoryId, List<AttributeValueInstance> attributeValueInstances) {
        return null;
    }

    @Override
    public Integer getNextDocumentLineNumber(Long userId, Long documentId) {
        return null;
    }

    @Override
    public Double getSumTaxAmount(Long userId, Long document_id) {
        return null;
    }

    @Override
    public Integer getDocumentLineQuantity(Long userId, Long document_id) {
        return null;
    }

    @Override
    public Double getSumTaxAndAmount(Long userId, Long document_id) {
        return null;
    }

    @Override
    public Double getSumAmount(Long userId, Long document_id) {
        return null;
    }

    @Override
    public void updateDocumentTotals(Long userId, Integer documentType, Long documentId) {

    }

    @Override
    public Integer getInventoryOnHand(Long userId, Long warehouseId, Long productId) {
        return null;
    }

    @Override
    public Integer getInventoryAvailable(Long userId, Long warehouseId, Long productId) {
        return null;
    }

    @Override
    public Integer getInventoryReserved(Long userId, Long warehouseId, Long productId) {
        return null;
    }

    @Override
    public Integer getDocumentProductBookedQuantity(Long userId, Long documentId, Long productId) {
        return null;
    }

    @Override
    public Page<Inventory> getAvailableStorageInventory(Long userId, Long warehouseLocatorId, Long productId, Boolean sold, Integer documentType, RestPageRequest pageRequest) {
        return null;
    }

    @Override
    public List<Inventory> getAvailableStorageInventory(Long userId, Long warehouseLocatorId, Long productId, Boolean sold, Integer documentType) {
        return null;
    }

    @Override
    public Inventory getInventoryByInstanceSet(Long userId, Long warehouseLocatorId, Boolean sold, Long attributeSetInstanceId, Integer documentType) {
        return null;
    }

    @Override
    public void updateLineStatus(Long userId, Boolean line_valid, Long document_id, Long inventory_id) {

    }
}
