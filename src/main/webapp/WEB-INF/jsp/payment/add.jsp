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
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/xadmin/lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/xadmin/js/xadmin.js"></script>
</head>
<body>
	<div class="layui-fluid">
		<div class="layui-row">
			<form class="layui-form" method="post" action="add" id='form'>

				<div class="layui-form-item">
					<label for="L_theme" class="layui-form-label"> <span
						class="x-red">*</span>工资报表主题
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_theme" name="theme"
							required="" lay-verify="theme" autocomplete="off"
							class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label for="L_month" class="layui-form-label"> <span
						class="x-red">*</span>所属月份
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_month" name="month" required=""
							lay-verify="month" autocomplete="off" class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label for="L_startDate" class="layui-form-label"> <span
						class="x-red">*</span>开始日期
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_startDate" name="startDate"
							required="" lay-verify="startDate" autocomplete="off"
							class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label for="L_endDate" class="layui-form-label"> <span
						class="x-red">*</span>结束日期
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_endDate" name="endDate"
							required="" lay-verify="endDate" autocomplete="off"
							class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label for="L_editor" class="layui-form-label"> <span
						class="x-red">*</span>编辑人
					</label>
					<div class="layui-input-inline">
						<select name="editor" lay-search lay-verify="editor">
							<c:choose>
								<c:when test="${empty users }">
									<option value="0">暂无可选</option>
								</c:when>
								<c:otherwise>
									<option value="${user.name}">请选择编辑人</option>
									<c:forEach items="${users }" var="user">
										<option value="${user.username }">${user.username }</option>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</select>
					</div>
				</div>

				
				<div class="layui-form-item">
					<label for="L_editorDate" class="layui-form-label"> <span
						class="x-red">*</span>编辑日期
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_editorDate" name="editorDate"
							required="" lay-verify="editorDate" autocomplete="off"
							class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label for="L_repass" class="layui-form-label"></label>
					<button class="layui-btn" lay-filter="add" lay-submit="">增加</button>
				</div>
			</form>
		</div>
	</div>
	<script>
		layui.use('laydate', function(){
		  var laydate = layui.laydate;
		  laydate.render({
		    elem: '#L_month',
		    type: 'month'
		  });
		});
		layui.use('laydate', function(){
			  var laydate = layui.laydate;
			  laydate.render({
			    elem: '#L_startDate'
			  });
			});
		layui.use('laydate', function(){
			  var laydate = layui.laydate;
			  laydate.render({
			    elem: '#L_endDate'
			  });
			});
		layui.use('laydate', function(){
			  var laydate = layui.laydate;
			  laydate.render({
			    elem: '#L_editorDate' 
			  });
			});
		layui.use([ 'form', 'layer', 'jquery' ], function() {
			$ = layui.jquery;
			var form = layui.form, layer = layui.layer;
			
			//自定义验证规则
			form.verify({
				theme : function(value) {
					if (value.length < 1) {
						return '主题不能为空';
					}
					var json;
					$.ajax({
						url : "verifytheme",
						type : 'post',
						async : false,
						data : {'theme' : value},
						success : function(ajaxObj) {
							json = JSON.parse(ajaxObj);
						}
					});
					if (json.result == 0) {
						return json.msg;
					}
				},
				month : function(value){
					if (value.length < 1) {
						return '所属月份不能为空';
					}
				},
				startDate : function(value){
					if (value.length < 1) {
						return '开始日期不能为空';
					}
				},
				endDate : function(value){
					if (value.length < 1) {
						return '结束日期不能为空';
					}
				},
				editorDate : function(value){
					if (value.length < 1) {
						return '编辑日期不能为空';
					}
				},
			});
			
			//监听提交
			form.on('submit(add)', function(data) {
				$.post("add", data.field, function() {
					layer.alert("增加成功", {
						icon : 6
					}, function() {
						//关闭当前frame
						xadmin.close();
						// 可以对父窗口进行刷新 
						xadmin.father_reload();
					});
				});
				return false;
			});

		});
	</script>

</body>

</html>