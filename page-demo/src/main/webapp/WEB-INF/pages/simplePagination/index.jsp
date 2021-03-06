<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/commons/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>simplePagination.js分页</title>
<%@include file="/WEB-INF/pages/commons/inc.jsp"%>
<!-- 引入simplePagination.css -->
<link href="${ctx}/resources/css/jquery/simplePagination.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h2>simplePagination.js分页示例</h2>
			<a href="${ctx}/index.jsp">返回分页汇总</a>
		</div>
		<form id="listForm" role="form" action="${ctx}/simplePagination/list" method="post">
			<div class="form-group">
				<label for="userName">User Name</label> <input id="userName" name="userName" type="text" class="form-control" style="width: 400px;" value="${userForm.userName}" placeholder="Enter user name" />
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
			<button type="reset" class="btn btn-default">Reset</button>
			<table class="table table-striped">
				<thead>
					<th data-name="id">id</th>
					<th data-name="username">user name</th>
					<th class="sort" data-name="phone">phone</th>
					<th class="sort" data-name="create_time">create time</th>
				</thead>
				<tbody>
					<c:forEach var="user" items="${pager.list}">
						<tr>
							<td>${user.id}</td>
							<td>${user.userName}</td>
							<td>${user.phone}</td>
							<td><fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<%@include file="/WEB-INF/pages/simplePagination/pager.jsp"%>
		</form>
	</div>
	<%@include file="/WEB-INF/pages/commons/incjs.jsp"%>
	<!-- 引入jquery.simplePagination.js -->
	<script src="${ctx}/resources/js/jquery/jquery.simplePagination.js" type="text/javascript"></script>
	<!-- 引入index.js 此为自定义的jquery.simplePagination.js辅助类库 -->
	<script src="${ctx}/resources/js/simplePagination/index.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(function() {
			// 初始化分页控件
			pager.init({
				totalCount : '${pager.totalCount}',
				pageSize : '${pager.pageSize}',
				totalPages : '${pager.pageCount}',
				currentPage : '${pager.pageNumber}'
			});
		});
	</script>
</body>
</html>
