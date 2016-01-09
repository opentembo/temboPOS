package ke.co.suncha.tembo.tenant.documents.inventory;

import ke.co.suncha.tembo.tenant.documents.Document;
import ke.co.suncha.tembo.tenant.documents.DocumentObject;
import ke.co.suncha.tembo.tenant.helpers.request.RestPageRequest;
import ke.co.suncha.tembo.tenant.products.attributes.set.instance.values.AttributeValueInstance;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by maitha.manyala on 11/15/15.
 */
@Service
public class InventoryManager {

    public Inventory create(InventoryObject inventoryObject, Long userId, Long documentId, Inventory inventory) {
        return inventoryObject.create(userId, documentId, inventory);
    }

    public Inventory updateAttributeValues(InventoryObject inventoryObject, Long userId, Long inventoryId, List<AttributeValueInstance> attributeValueInstances) {
        return inventoryObject.updateAttributeValues(userId, inventoryId, attributeValueInstances);
    }

    public Boolean removeLine(InventoryObject inventoryObject, Long userId, Long recordId, Inventory inventory) {
        return inventoryObject.removeLine(userId, recordId, inventory);
    }

    public Page<Inventory> findAll(InventoryObject inventoryObject, Long userId, Integer documentType, Long documentId, RestPageRequest pageRequest) {
        return inventoryObject.findAll(userId, documentType, documentId, pageRequest);
    }

    public Page<Inventory> getAvailableStorageInventory(InventoryObject inventoryObject, Long userId, Long warehouseLocatorId, Long productId, RestPageRequest pageRequest) {
        return inventoryObject.getAvailableStorageInventory(userId, warehouseLocatorId, productId, pageRequest);
    }
}
