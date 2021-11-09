package com.triad.ocp.repository.sale;

import com.triad.ocp.domain.sale.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository  extends JpaRepository<Sale, Integer> {
}
