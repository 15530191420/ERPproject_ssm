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
			<form class="layui-form" method="post" action="update" id='form'>
				<!-- 隐藏ID -->
				<input type="hidden" name="id" value="${performance.id }" />
				<div class="layui-form-item">
					<label for="L_progTheme" class="layui-form-label"> <span
						class="x-red">*</span>计划主题
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_progTheme" name="progTheme"
							required="" value="${performance.progTheme }" lay-verify="progTheme" autocomplete="off"
							class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label for="L_creater" class="layui-form-label"> <span
						class="x-red">*</span>创建人
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_creater" name="creater"
							required="" value="${performance.creater }" lay-verify="creater" autocomplete="off"
							class="layui-input">
					</div>
					<div class="layui-form-mid layui-word-aux">
						<span class="x-red">*</span>不可更改
					</div>
				</div>

				<div class="layui-form-item">
					<label for="L_createDate" class="layui-form-label"> <span
						class="x-red">*</span>创建时间
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_createDate" name="createDate"
							required="" value="${performance.createDate }" lay-verify="createDate" autocomplete="off"
							class="layui-input">
					</div>
					<div class="layui-form-mid layui-word-aux">
						<span class="x-red">*</span>不可更改
					</div>
				</div>

				<div class="layui-form-item">
					<label for="L_repass" class="layui-form-label"></label>
					<button class="layui-btn" lay-filter="update" lay-submit="">更新</button>
				</div>
			</form>
		</div>
	</div>
	<script>
		
		layui.use([ 'form', 'layer', 'jquery' ], function() {
			$ = layui.jquery;
			var form = layui.form, layer = layui.layer;

			//自定义验证规则
			form.verify({
				progTheme : function(value){
					if (value.length < 1) {
						return '所属月份不能为空';
					}
				},
				creater : function(value){
					if (value.length < 1) {
						return '所属月份不能为空';
					}
				},
			});
			
			//监听提交
			form.on('submit(update)', function(data) {
				$.post("update", data.field, function() {
					layer.alert("修改成功", {
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