<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<form class="layui-form" method="post" action="addInput" id='form'>
				<div class="layui-form-item">
					<label for="L_name" class="layui-form-label"> <span
						class="x-red">*</span>部门名称
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_name" name="name" required=""
							lay-verify="name" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label for="L_desc" class="layui-form-label"> <span
						class="x-red">*</span>部门介绍
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_desc" name="desc" required=""
							lay-verify="desc" autocomplete="off" class="layui-input">
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
		layui.use([ 'form', 'layer', 'jquery' ], function() {
			$ = layui.jquery;
			var form = layui.form, layer = layui.layer;

			//自定义验证规则
			form.verify({
				name : function(value) {
					if (value.length < 2) {
						return '部门名称至少得2个字符啊';
					}
				},
			});

			//监听提交
			form.on('submit(addInput)', function(data) {
				$.post("addInput",data.field,function(){
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