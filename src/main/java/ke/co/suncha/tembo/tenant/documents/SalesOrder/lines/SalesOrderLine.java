package ke.co.suncha.tembo.tenant.documents.SalesOrder.lines;

import ke.co.suncha.tembo.tenant.documents.inventory.Inventory;
import ke.co.suncha.tembo.tenant.documents.inventory.InventoryObject;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by maitha.manyala on 11/16/15.
 */
@Service
public class SalesOrderLine extends InventoryObject {
    @Override
    public Inventory create(Long userId, Long documentId, Inventory inventory) {
        return null;
    }

    @Override
    public void updateLineItemValidity(Long userId, Long inventoryId) {

    }

    @Override
    public Inventory updateLineItem(Long userId, Long inventoryId, Inventory inventory) {
        return null;
    }
}
