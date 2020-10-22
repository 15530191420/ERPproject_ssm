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
					<label for="L_leavename" class="layui-form-label"> <span
						class="x-red">*</span>申请人
					</label>
					<div class="layui-input-inline">
						<select name="leavename" lay-search lay-verify="leavename" >
							<c:choose>
								<c:when test="${empty users }">
									<option value="0">暂无申请人</option>
								</c:when>
								<c:otherwise>
									<option value="${user.name}">请选择申请人</option>
									<c:forEach items="${users }" var="user">
										<option value="${user.username }">${user.username }</option>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</select>
					</div>
				</div>

				<div class="layui-form-item">
					<label for="L_startDate" class="layui-form-label"> <span
						class="x-red">*</span>申请时间
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_startDate" name="startDate" required=""
							lay-verify="startDate" autocomplete="off" class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label for="L_belongDept" class="layui-form-label"> <span
						class="x-red">*</span>部门
					</label>
					<div class="layui-input-inline">
						<select name="belongDept" lay-search>
							<c:choose>
								<c:when test="${empty depts }">
									<option value="0">暂无可选部门</option>
								</c:when>
								<c:otherwise>
									<option value="${dept.name }">请选择部门</option>
									<c:forEach items="${depts }" var="dept">
										<option value="${dept.name}">${dept.name }</option>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</select>
					</div>   
				</div>

				<div class="layui-form-item">
					<label for="L_post" class="layui-form-label"> <span
						class="x-red">*</span>岗位
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_post" name="post"
							required="" lay-verify="post" autocomplete="off"
							class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label for="L_arrivalDate" class="layui-form-label"> <span
						class="x-red">*</span>到职日期
					</label>
					<div class="layui-input-inline" >
						<input type="text" id="L_arrivalDate" name="arrivalDate" 
							required="" lay-verify="arrivalDate"  autocomplete="off"
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
			
			//自定义验证规则
			form.verify({
				leavename : function(value) {
					if (value.length < 2) {
						return '姓名至少得2个字符啊';
					}
					var json;
					$.ajax({
						url : "verifyLeavename",
						type : 'post',
						async : false,
						data : {
							'leavename' : value
						},
						success : function(ajaxObj) {
							json = JSON.parse(ajaxObj);

						}
					});
					if (json.result == 0) {
						return json.msg;
					}
				},
				post : function(value){
					if (value.length < 1) {
						return '岗位不能为空';
					}
				},
				arrivalDate : function(value){
					if (value.length < 1) {
						return '岗位不能为空';
					}
				},
				startDate : function(value){
					if (value.length < 1) {
						return '申请时间不能为空';
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