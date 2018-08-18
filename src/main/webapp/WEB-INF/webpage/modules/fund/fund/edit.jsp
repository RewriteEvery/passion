<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <title>基金列表</title>
    <meta name="decorator" content="form"/>
    <html:css name="bootstrap-fileinput" />
    <html:css name="simditor,jqgrid" />
</head>

<body class="white-bg"  formid="fundForm" beforeSubmit="beforeSubmit">
    <form:form id="fundForm" modelAttribute="data"  method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<table  class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>基金名称:</label>
		            </td>
					<td class="width-35">
						<form:input path="fundName" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>基金代码:</label>
		            </td>
					<td class="width-35">
						<form:input path="fundCode" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>英文长名:</label>
		            </td>
					<td class="width-35">
						<form:input path="fundEnLongName" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>英文短名:</label>
		            </td>
					<td class="width-35">
						<form:input path="fundEnSortName" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>基金类型:</label>
		            </td>
					<td class="width-35">
						<form:select path="fundType" htmlEscape="false" class="form-control"        />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>创建时间:</label>
		            </td>
					<td class="width-35">
						<form:input path="createTime" htmlEscape="false" class="form-control layer-date" placeholder="YYYY-MM-DD hh:mm:ss" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"       />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>更新时间:</label>
		            </td>
					<td class="width-35">
						<form:input path="updateTime" htmlEscape="false" class="form-control layer-date" placeholder="YYYY-MM-DD hh:mm:ss" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"       />
						<label class="Validform_checktip"></label>
					</td>
					<%-- <td  class="width-15 active text-right">	
		              <label>行业:</label>
		            </td>
					<td class="width-35">
						<form:input path="industry" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td> --%>
				</tr>
		      
		   </tbody>
		</table>   
	</form:form>
	<div class="row">
        <div class="tabs-container">
            <ul class="nav nav-tabs">
            </ul>
            <div class="tab-content">
          
            </div>
        </div>
    </div>
<html:js name="bootstrap-fileinput" />
<html:js name="simditor,jqgrid,jqGrid_curdtools,jqGrid_curdtools_inline" />
<script>
	$(document).ready(function () {
	    $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
	    	 resizeGrid();
		});
	});
	$(function(){
	   $(window).resize(function(){   
		   resizeGrid();
	   });
	});
	function resizeGrid(){
	}

	/**
	*提交回调方法
	*/
	function beforeSubmit(curform){
		 //这里最好还是使用JSON提交，控制器改变提交方法，并使用JSON方式来解析数
		 //通过判断，如果有问题不提交
		 return true;
	}
	
	function initGridFormData(curform,gridId){
		 var rowDatas =getRowDatas(gridId+"Grid");
		 var rowJson = JSON.stringify(rowDatas);
		 if(rowJson.indexOf("editable") > 0&&rowJson.indexOf("inline-edit-cell") )
	     {
	    	 return false;
	     }
		 var gridListJson=$('#'+gridId+"ListJson").val();
		 if(gridListJson==undefined||gridListJson==''){
			 var rowInput = $('<input id="'+gridId+'ListJson" type="hidden" name="'+gridId+'ListJson" />');  
			 rowInput.attr('value', rowJson);  
			 // 附加到Form  
			 curform.append(rowInput); 
		 }else{
			 $('#'+gridId+"ListJson").val(rowJson);
		 }
		 return true;
	}
</script>
</body>
</html>