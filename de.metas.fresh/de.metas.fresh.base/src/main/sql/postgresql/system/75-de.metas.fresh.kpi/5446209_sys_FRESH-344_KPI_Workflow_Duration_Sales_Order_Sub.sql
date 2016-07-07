--order sales
DROP FUNCTION IF EXISTS de_metas_fresh_kpi.KPI_Workflow_Duration_Sales_Order_Sub (IN startdate DATE, IN enddate DATE);
CREATE OR REPLACE FUNCTION de_metas_fresh_kpi.KPI_Workflow_Duration_Sales_Order_Sub (IN startdate DATE, IN enddate DATE)
RETURNS TABLE 
(
table_id numeric,
record_id numeric,
created timestamp with time zone,
duration interval,
duration_perline interval,
average_duration interval,
average_duration_perline interval
)
AS
$$
SELECT ad_table_id, Record_ID, Created,Duration , Duration_PerLine,avg(Duration) over() AS average_duration, avg(Duration_PerLine) over() AS average_duration_perline
FROM(
SELECT ad_table_id, Record_ID, Created,Duration , linenos, maxline,
(case when linenos is null or linenos=0 then null else  duration / linenos end) as Duration_PerLine

FROM
(
select 
wfp.ad_table_id, wfp.Record_ID, wfp.Created, 
 (wfp.Updated - wfp.Created) as Duration,
 count(ol.c_orderline_id) as linenos,
 max(count(ol.c_orderline_id)) over() as maxline

from AD_WF_Process wfp 
JOIN C_Order o ON o.C_Order_ID = wfp.Record_ID
JOIN C_OrderLine ol ON ol.C_Order_ID = o.C_Order_ID

WHERE wfp.AD_Table_ID = get_Table_ID('C_Order')
	AND wfp.created::date >=$1 and wfp.created::date <= $2
	AND
	exists (
		select 1
		  from AD_WF_Activity wfa
		  inner join AD_WF_Node n on (n.AD_WF_Node_ID=wfa.AD_WF_Node_ID)
		  where wfa.AD_WF_Process_ID=wfp.AD_WF_Process_ID
	          and n.Value='(DocComplete)'
               ) 
	AND o.issotrx='Y'
GROUP BY wfp.ad_table_id, wfp.Record_ID, wfp.Created, 
 (wfp.Updated - wfp.Created)
 )lines

 where linenos >= floor((maxline - (((maxline * 25)::float)/100))::float)
 limit 10
 )i
$$
LANGUAGE sql STABLE;
