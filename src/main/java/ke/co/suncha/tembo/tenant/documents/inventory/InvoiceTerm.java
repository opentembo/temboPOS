package ke.co.suncha.tembo.tenant.documents.inventory;

/**
 * Created by maitha.manyala on 1/5/16.
 */
public class InvoiceTerm {
    /**
     * the invoice will be generated with the next run of the automated generation of invoices regardless of whether any shipment of ordered products took place or not.
     */
    public static final Integer IMMEDIATE = 1;

    /*
    products of the sales order are invoiced as soon as they are shipped, for example, if there is partial shipment of the order it is invoiced. In this case several sales invoices might be created for one sales order corresponding to all goods shipped before each invoicing run.
     */
    public static final Integer AFTER_DELIVERY = 2;

    //the invoice will be generated after all products on the sales order have been shipped, so one order - one invoice.
    public static final Integer AFTER_ORDER_DELIVERED = 3;

    //instead of sending out invoices each time any sales order product gets delivered, - one invoice is created that is combining the different deliveries for a certain customer according to the defined schedule (weekly or monthly on a particular day)
    public static final Integer CUSTOMER_SCHEDULE_AFTER_DELIVERY = 4;
}
