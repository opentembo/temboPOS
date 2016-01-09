package ke.co.suncha.tembo.tenant.organization;

import ke.co.suncha.tembo.tenant.Tenant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by maitha.manyala on 8/23/15.
 */
public interface BusinessUnitRepository extends PagingAndSortingRepository<BusinessUnit, Long> {
    BusinessUnit findByTenantAndName(Tenant tenant, String name);

    BusinessUnit findByTenantAndBusinessUnitId(Tenant tenant, Long businessUnitId);

    List<BusinessUnit> findAllByTenant(Tenant tenant);

    List<BusinessUnit> findAllByTenantAndIsDefault(Tenant tenant, Boolean isDefault);

    List<BusinessUnit> findAllByTenantAndBusinessUnitId(Tenant tenant, Long businessUnitId);

    Page<BusinessUnit> findAllByTenant(Tenant tenant, Pageable pageable);

    Page<BusinessUnit> findAllByTenantAndNameContaining(Tenant tenant, String filter, Pageable pageable);

    Long countByTenantAndActive(Tenant tenant, Boolean active);
}
