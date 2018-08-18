<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title>基金列表列表</title>
  <meta name="decorator" content="list"/>
</head>
<body title="基金列表">
<grid:grid id="fundGridId" url="${adminPath}/fund/fund/ajaxList">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
	<grid:button title="sys.common.delete"  groupname="opt" function="delObj" outclass="btn-danger" innerclass="fa-trash" url="${adminPath}/fund/fund/delete" />
    <grid:column label="基金代码"  name="fundCode"  query="true"  queryModel="input"  condition="prefixLike" />
 	<grid:column label="基金名称"  name="fundName"  query="true"  queryModel="input"  condition="like" />    <grid:column label="英文短名"  name="fundEnSortName"  query="true"  queryModel="input"  condition="prefixLike" />
    <grid:column label="基金类型"  name="fundType"  query="true"  queryModel="select"  condition="like" dict="fundType" />
    <grid:column label="更新时间"  name="updateTime"  query="true"  queryModel="date"  condition="between" />
   <%--  <grid:column label="行业"  name="industry"  query="true"  queryModel="input"  condition="like" /> --%>
	<grid:toolbar function="create"/>
	<grid:toolbar function="update"/>
	<grid:toolbar function="delete"/>
	<grid:toolbar title="同步基金库" btnclass="btn-warning"  icon="fa-anchor" tipMsg="你确定要同步基金库信息么?"  function="normalConfirm" url="${adminPath}/fund/fund/updateFund"  />
	<grid:toolbar function="search"/>
	<grid:toolbar function="reset"/>
</grid:grid>
</body>
</html>