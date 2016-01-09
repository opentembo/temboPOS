package ke.co.suncha.tembo.tenant.documents.inventory;

import ke.co.suncha.tembo.tenant.documents.DocumentType;
import ke.co.suncha.tembo.tenant.helpers.request.RestPageRequest;
import ke.co.suncha.tembo.tenant.organization.warehousing.Warehouse;
import ke.co.suncha.tembo.tenant.products.Product;
import ke.co.suncha.tembo.tenant.products.attributes.set.instance.values.AttributeValueInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by maitha.manyala on 11/15/15.
 */
@Service
public abstract class InventoryObject {
    @Autowired
    InventoryService inventoryService;

    public abstract Inventory create(Long userId, Long documentId, Inventory inventory);

    public abstract void updateLineItemValidity(Long userId, Long inventoryId);

    public abstract Inventory updateLineItem(Long userId, Long inventoryId, Inventory inventory);

    public Inventory findOne(Long userId, Long recordId) {
        return inventoryService.findOne(userId, recordId);
    }

    public List<Warehouse> getByProduct(Long userId, Long productId) {
        return inventoryService.getByProduct(userId, productId);
    }

    public TemboPage<Product> getByWarehouse(Long userId, Long warehouseId, RestPageRequest pageRequest) {
        return inventoryService.getByWarehouse(userId, warehouseId, pageRequest);
    }

    public Page<Inventory> findAll(Long userId, Integer documentType, Long documentId, RestPageRequest pageRequest) {
        return inventoryService.findAll(userId, documentType, documentId, pageRequest);
    }

    public Boolean removeLine(Long userId, Long documentId, Inventory inventory) {
        return inventoryService.removeLine(userId, documentId, inventory);
    }

    public Inventory updateAttributeValues(Long userId, Long inventoryId, List<AttributeValueInstance> attributeValueInstances) {
        return inventoryService.updateAttributeValues(userId, inventoryId, attributeValueInstances);
    }

    public Integer getNextDocumentLineNumber(Long userId, Long documentId) {
        return inventoryService.getNextDocumentLineNumber(userId, documentId);
    }

    public Page<Inventory> getAvailableStorageInventory(Long userId, Long warehouseLocatorId, Long productId, RestPageRequest pageRequest) {
        return inventoryService.getAvailableStorageInventory(userId, warehouseLocatorId, productId, false, DocumentType.GOODS_RECEIPT, pageRequest);
    }
}
