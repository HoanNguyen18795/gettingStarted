package com.h.crawler.repository.product;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.h.crawler.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	
	@Query(value = "SELECT P.ID  ,P.IMG, P.IMG1, P.IMG2, P.IMG3, P.IMG4, P.NAME  ,P.CATEGORY  ,P.MANUFACTURER  ,P.DESCRIPTION  ,P.PRICE  ,P.TOTAL  ,P.DEL_FLG  ,P.INS_DATE  ,P.UPD_DATE  FROM(  SELECT   P.ID  ,P.IMG, P.IMG1, P.IMG2, P.IMG3, P.IMG4, P.NAME  ,P.CATEGORY  ,P.MANUFACTURER  ,P.DESCRIPTION  ,P.PRICE  ,P.TOTAL  ,P.DEL_FLG  ,P.INS_DATE  ,P.UPD_DATE  ,SUM(P_ORDER.QUANTITY) AS SOLD  FROM  PRODUCT_ORDER P_ORDER  INNER JOIN  PRODUCT P  ON  P_ORDER.PRODUCT_ID = P.ID  INNER JOIN  ORDERS O  ON  P_ORDER.ID = O.ID  and  O.PURCHASE_DATE is not NULL  GROUP BY  P.ID  ,P.IMG, P.IMG1, P.IMG2, P.IMG3, P.IMG4, P.NAME  ,P.CATEGORY  ,P.MANUFACTURER  ,P.DESCRIPTION  ,P.PRICE  ,P.TOTAL  ,P.DEL_FLG  ,P.INS_DATE  ,P.UPD_DATE  ORDER BY SOLD DESC  ) P  WHERE ROWNUM <=10", nativeQuery = true)
	public List<Product> getFeatureProduct();
	
	public Product findById (long id);
}
