<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="x-admin-sm">
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/xadmin/css/font.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/xadmin/css/xadmin.css">
<script
	src="<%=request.getContextPath()%>/resources/xadmin/lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/xadmin/js/xadmin.js"></script>
</head>
<body>
	<div class="x-nav">
		<span class="layui-breadcrumb"> <a href="">首页</a> <a href="">薪酬管理</a>
			<a> <cite>工资报表列表</cite></a>
		</span> <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			onclick="location.reload()" title="刷新"> <i
			class="layui-icon layui-icon-refresh" style="line-height: 30px"></i></a>
	</div>
	<div class="layui-fluid">
		<div class="layui-row layui-col-space15">
			<div class="layui-col-md12">
				<div class="layui-card">
					<div class="layui-card-body ">
						<form class="layui-form layui-col-space5" action="search" method="post">
							<div class="layui-inline layui-show-xs-block">
								<input type="text" name="theme" placeholder="请输入要查询的相关主题"
									autocomplete="off" class="layui-input">
							</div>
							<div class="layui-inline layui-show-xs-block">
								<button class="layui-btn" lay-submit="" lay-filter="sreach">
									<i class="layui-icon">&#xe615;</i>
								</button>
							</div>
						</form>
					</div>
					<div class="layui-card-header">
						<button class="layui-btn"
							onclick="xadmin.open('新建工资报表','addInput',800,600)">
							<i class="layui-icon"></i>新建工资报表
						</button>
					</div>
					<div class="layui-card-body layui-table-body layui-table-main">
						<table class="layui-table layui-form">
							<thead>
								<tr>
									<th>编号</th>
									<th>工资报表主题</th>
									<th>所属月份</th>
									<th>开始日期</th>
									<th>结束日期</th>
									<th>编辑人</th>
									<th>编辑日期</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${payments }" var="payment">
									<tr>
										<td>${payment.id }</td>
										<td>${payment.theme }</td>
										<td>${payment.month }</td>
										<td>${payment.startDate }</td>
										<td>${payment.endDate }</td>
										<td>${payment.editor }</td>
										<td>${payment.editorDate }</td>
										<td class="td-manage"><a title="编辑"
											onclick="xadmin.open('编辑','updateInput?id=${payment.id}',800,600)"
											href="javascript:;"> <i class="layui-icon">&#xe642;</i>
										</a> <a title="删除" onclick="member_del(this,${payment.id })"
											href="javascript:;"> <i class="layui-icon">&#xe640;</i>
										</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</body>
<script>
	layui.use([ 'laydate', 'form' ], function() {
		var laydate = layui.laydate;
		var form = layui.form;
	});
	//用户-删除
	function member_del(obj,id){
		layer.confirm('确认要删除吗?', function(index){
			//发异步删除数据
			$.post('delete',{"id":id},function(ajaxObj){
				//把返回的json格式的字符串转换为json对象
				var json = JSON.parse(ajaxObj);
				//1 是成功
				if(json.result == 1){
					//在页面中删除这个数据
					$(obj).parents("tr").remove();
					//提示信息
					layer.msg(json.msg,{
						icon:1,
						time:1000
					});
				}else{
					layer.msg("删除失败",{
						icon:2,
						time:1000
					});
				}
			});	
		});
	}
</script>
</html>