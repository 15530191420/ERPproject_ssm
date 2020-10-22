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
				<input type="hidden" name="id" value="${leave.id }" />
				<div class="layui-form-item">
					<label for="L_leavename" class="layui-form-label"> <span
						class="x-red">*</span>申请人
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_leavename" name="leavename" required="" readonly="readonly"
							value="${leave.leavename }" lay-verify="leavename" autocomplete="off" class="layui-input">
					</div> 
					<div class="layui-form-mid layui-word-aux">
						<span class="x-red">*</span>不可更改
					</div>  
				</div>

				<div class="layui-form-item">
					<label for="L_startDate" class="layui-form-label"> <span
						class="x-red">*</span>申请时间
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_startDate" name="startDate" required=""
							value="${leave.startDate }" lay-verify="startDate" autocomplete="off" class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label for="L_belongDept" class="layui-form-label"> <span
						class="x-red">*</span>部门
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_belongDept" name="belongDept" readonly="readonly"
							required="" value="${leave.belongDept }" lay-verify="belongDept" autocomplete="off"
							class="layui-input">
					</div>
					<div class="layui-form-mid layui-word-aux">
						<span class="x-red">*</span>不可更改
					</div> 
				</div>

				<div class="layui-form-item">
					<label for="L_post" class="layui-form-label"> <span
						class="x-red">*</span>岗位
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_post" name="post"
							required="" value="${leave.post }" lay-verify="post" autocomplete="off"
							class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label for="L_arrivalDate" class="layui-form-label"> <span
						class="x-red">*</span>到职日期
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_arrivalDate" name="arrivalDate"
							required="" value="${leave.arrivalDate }" lay-verify="arrivalDate" autocomplete="off"
							class="layui-input">
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
	layui.use('laydate', function(){
		  var laydate = layui.laydate;
		  laydate.render({
		    elem: '#L_arrivalDate' //指定元素
		  });
		});
	layui.use('laydate', function(){
		  var laydate = layui.laydate;
		  laydate.render({
		    elem: '#L_startDate' //指定元素
		  });
		});
		layui.use([ 'form', 'layer', 'jquery' ], function() {
			$ = layui.jquery;
			var form = layui.form, layer = layui.layer;

			//监听提交
			form.on('submit(update)', function(data) {
						$.post("update",data.field,function(){
							layer.alert("修改成功", {
								icon : 6
							},function(){
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