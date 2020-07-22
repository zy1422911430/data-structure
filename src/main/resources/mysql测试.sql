
	SELECT
		c.NAME AS companyName,
		item.CODE AS itemCode,
		item.NAME AS itemName,
		inv.QTY_PACKAGE_NAME AS unitName,
		(
		SELECT
			sum( i.QTY_PACK_QTY ) 
		FROM
			wms_inventory i
			LEFT JOIN wms_location l ON l.id = i.LOCATION_ID
		WHERE
			( (l.type = 'ST' AND i.OPERATION_STATUS = 'N' )
				or
				(l.type = 'RV' AND i.OPERATION_STATUS = 'O')
			)
			AND i.SKU_ITEM_ID = inv.SKU_ITEM_ID 
			AND i.QTY_PACKAGE_UNIT_ID = inv.QTY_PACKAGE_UNIT_ID
		  AND i.QTY_BASE_QTY>0
		  AND l.PICK_STORE_AREA_ID not in ( select area.id from wms_store_area area where area.`NAME` = '退货仓') 
		) AS ky,
		(
		SELECT
			sum( i.QTY_PACK_QTY ) 
		FROM
			wms_inventory i
			LEFT JOIN wms_location l ON l.id = i.LOCATION_ID 
		WHERE
			l.type = 'ST' 
			AND i.OPERATION_STATUS = 'O' 
			AND i.SKU_ITEM_ID = inv.SKU_ITEM_ID 
			AND i.QTY_PACKAGE_UNIT_ID = inv.QTY_PACKAGE_UNIT_ID 
			AND i.QTY_BASE_QTY>0
			AND l.PICK_STORE_AREA_ID not in ( select area.id from wms_store_area area where area.`NAME` = '退货仓') 
		) AS yfp,
		(
		SELECT
			sum( ptd.QTY_PACK_QTY - ptd.ALLOACTED_QTY / ptd.QTY_CONVERT_FIGURE ) 
		FROM
			wms_pick_ticket_detail ptd
			LEFT JOIN wms_pick_ticket pt on  ptd.PICK_TICKET_ID=pt.id 
		WHERE
			ptd.ITEM_ID = inv.SKU_ITEM_ID 
			AND ptd.QTY_PACKAGE_UNIT_ID = inv.QTY_PACKAGE_UNIT_ID
			AND pt.`STATUS` IN ('EN','OP') 
		) AS dfp 
	FROM
		wms_inventory inv
		LEFT JOIN wms_company c ON c.id = inv.COMPANY_ID
		LEFT JOIN wms_item item ON item.id = inv.SKU_ITEM_ID
		LEFT JOIN wms_location l ON l.id = inv.LOCATION_ID 
	WHERE
		1 = 1 
-- AND (c.id = ? or ? is null)

		AND l.PICK_STORE_AREA_ID not in ( select area.id from wms_store_area area where area.`NAME` = '退货仓') ;
		
set profiling = 1;


SELECT
			sum( i.QTY_PACK_QTY ) 
		FROM
			wms_inventory i
			LEFT JOIN wms_location l ON l.id = i.LOCATION_ID
		WHERE
			( (l.type = 'ST' AND i.OPERATION_STATUS = 'N' )
				or
				(l.type = 'RV' AND i.OPERATION_STATUS = 'O')
			)
		  AND i.QTY_BASE_QTY>0
			AND l.PICK_STORE_AREA_ID not in ( select area.id from wms_store_area area where area.`NAME` = '退货仓') 
			group by i.SKU_ITEM_ID, i.QTY_PACKAGE_UNIT_ID;

SELECT
			sum( i.QTY_PACK_QTY ) 
		FROM
			wms_inventory i
			LEFT JOIN wms_location l ON l.id = i.LOCATION_ID
		WHERE
			( (l.type = 'ST' AND i.OPERATION_STATUS = 'N' )
				or
				(l.type = 'RV' AND i.OPERATION_STATUS = 'O')
			)
			AND EXISTS (select 1 from wms_store_area area where area.id = l.PICK_STORE_AREA_ID and area.`NAME` != '退货仓') 
		  AND i.QTY_BASE_QTY>0
			group by i.SKU_ITEM_ID, i.QTY_PACKAGE_UNIT_ID;



SHOW PROFILES;

SET @query_id = 11;

SELECT STATE, SUM(DURATION) AS Total_R,ROUND(100 * SUM(DURATION) /(SELECT SUM(DURATION) FROM INFORMATION_SCHEMA.PROFILING WHERE QUERY_ID = @query_id), 2) AS Pct_R,COUNT(*) AS Calls,SUM(DURATION) / COUNT(*) AS "R/Call"
FROM INFORMATION_SCHEMA.PROFILING
WHERE QUERY_ID = @query_id
GROUP BY STATE
ORDER BY Total_R DESC;

FLUSH STATUS;
SELECT
			sum( i.QTY_PACK_QTY ) 
		FROM
			wms_inventory i
			LEFT JOIN wms_location l ON l.id = i.LOCATION_ID
		WHERE
			( (l.type = 'ST' AND i.OPERATION_STATUS = 'N' )
				or
				(l.type = 'RV' AND i.OPERATION_STATUS = 'O')
			)
		  AND i.QTY_BASE_QTY>0
		  AND l.PICK_STORE_AREA_ID not in ( select area.id from wms_store_area area where area.`NAME` = '退货仓') 
			group by i.SKU_ITEM_ID, i.QTY_PACKAGE_UNIT_ID;

SHOW STATUS WHERE Variable_name LIKE 'Handler%' OR Variable_name LIKE 'Created%';

mysqladmin ext -i1 | awk '/Queries/{q=$4-qp;qp=$4}/Threads_connected/{tc=$4}/Threads_running/{printf "%5d %5d %5d\n", q, tc, $4}'