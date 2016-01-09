package ke.co.suncha.tembo.tenant.documents.inventory;

import ke.co.suncha.tembo.tenant.Tenant;
import ke.co.suncha.tembo.tenant.helpers.request.RestPageRequest;
import ke.co.suncha.tembo.tenant.organization.warehousing.Warehouse;
import ke.co.suncha.tembo.tenant.organization.warehousing.locator.WarehouseLocator;
import ke.co.suncha.tembo.tenant.products.Product;
import ke.co.suncha.tembo.tenant.products.attributes.set.instance.AttributeSetInstance;
import ke.co.suncha.tembo.tenant.products.attributes.set.instance.values.AttributeValueInstance;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by maitha.manyala on 11/13/15.
 */
public interface InventoryService {
    Inventory create(Long userId, Integer documentType, Long documentId, Inventory inventory);

    Inventory update(Long userId, Inventory inventory);

    Inventory findOne(Long userId, Long recordId);

    List<Warehouse> getByProduct(Long userId, Long productId);

    TemboPage<Product> getByWarehouse(Long userId, Long warehouseId, RestPageRequest pageRequest);

    Page<Inventory> findAll(Long userId, Integer documentType, Long documentId, RestPageRequest pageRequest);

    Page<Inventory> findAll(Long userId, RestPageRequest pageRequest);

    Boolean removeLine(Long userId, Long documentId, Inventory inventory);

    Inventory updateAttributeValues(Long userId, Long inventoryId, List<AttributeValueInstance> attributeValueInstances);

    Integer getNextDocumentLineNumber(Long userId, Long documentId);

    Double getSumTaxAmount(Long userId, Long document_id);

    Integer getDocumentLineQuantity(Long userId, Long document_id);

    Double getSumTaxAndAmount(Long userId, Long document_id);

    Double getSumAmount(Long userId, Long document_id);

    void updateDocumentTotals(Long userId, Integer documentType, Long documentId);

    Integer getInventoryOnHand(Long userId, Long warehouseId, Long productId);

    Integer getInventoryAvailable(Long userId, Long warehouseId, Long productId);

    Integer getInventoryReserved(Long userId, Long warehouseId, Long productId);

    Integer getDocumentProductBookedQuantity(Long userId, Long documentId, Long productId);

    Page<Inventory> getAvailableStorageInventory(Long userId, Long warehouseLocatorId, Long productId, Boolean sold, Integer documentType, RestPageRequest pageRequest);

    List<Inventory> getAvailableStorageInventory(Long userId, Long warehouseLocatorId, Long productId, Boolean sold, Integer documentType);

    Inventory getInventoryByInstanceSet(Long userId, Long warehouseLocatorId, Boolean sold, Long attributeSetInstanceId, Integer documentType);

    void updateLineStatus(Long userId, Boolean line_valid, Long document_id, Long inventory_id);
}
