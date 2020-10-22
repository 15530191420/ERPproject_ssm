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
				<input type="hidden" name="id" value="${transfer.id }" />
				<div class="layui-form-item">
					<label for="L_applyname" class="layui-form-label"> <span
						class="x-red">*</span>申请人
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_applyname" name="applyname" required="" readonly="readonly"
							lay-verify="applyname" autocomplete="off" class="layui-input" value="${transfer.applyname }">
					</div>
					<div class="layui-form-mid layui-word-aux">
						<span class="x-red">*</span>不可更改
					</div>
				</div>

				<div class="layui-form-item">
					<label for="L_applyDate" class="layui-form-label"> <span
						class="x-red">*</span>申请时间
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_applyDate" name="applyDate" required="" readonly="readonly"
							value="${transfer.applyDate }" lay-verify="applyDate" autocomplete="off" class="layui-input">
					</div>
					<div class="layui-form-mid layui-word-aux">
						<span class="x-red">*</span>不可更改
					</div>
				</div>

				<div class="layui-form-item">
					<label for="L_currentDept" class="layui-form-label"> <span
						class="x-red">*</span>目前部门
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_currentDept" name="currentDept"
							required="" readonly="readonly" value="${transfer.currentDept }" lay-verify="currentDept" autocomplete="off"
							class="layui-input">
					</div>
					<div class="layui-form-mid layui-word-aux">
						<span class="x-red">*</span>不可更改
					</div>
				</div>

				<div class="layui-form-item">
					<label for="L_currentPosition" class="layui-form-label"> <span
						class="x-red">*</span>目前岗位
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_currentPosition" name="currentPosition"
							required="" value="${transfer.currentPosition }" lay-verify="currentPosition" autocomplete="off"
							class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label for="L_currentLevel" class="layui-form-label"> <span
						class="x-red">*</span>目前岗位职等
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_currentLevel" name="currentLevel"
							required="" value="${transfer.currentLevel }" lay-verify="currentLevel" autocomplete="off"
							class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label for="L_hopeDate" class="layui-form-label"> <span
						class="x-red">*</span>希望日期
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_hopeDate" name="hopeDate" required=""
						   value="${transfer.hopeDate }" lay-verify="hopeDate" autocomplete="off" class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label for="L_targetDept" class="layui-form-label"> <span
						class="x-red">*</span>调至部门
					</label>
					<div class="layui-input-inline">
						<select name="targetDept" lay-search>
							<c:choose>
								<c:when test="${empty depts }">
									<option value="0">暂无可选部门</option>
								</c:when>
								<c:otherwise>
									<option value="${dept.name}">请选择部门</option>
									<c:forEach items="${depts }" var="dept">
										<option value="${dept.name }">${dept.name }</option>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</select>
					</div>

				</div>

				<div class="layui-form-item">
					<label for="L_tatgetPosition" class="layui-form-label"> <span
						class="x-red">*</span>调至岗位
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_tatgetPosition" name="tatgetPosition"
							required="" value="${transfer.tatgetPosition }" lay-verify="tatgetPosition" autocomplete="off"
							class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label for="L_targetLevel" class="layui-form-label"> <span
						class="x-red">*</span>调至岗位职等
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_targetLevel" name="targetLevel"
							required="" value="${transfer.targetLevel }" lay-verify="targetLevel" autocomplete="off"
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
		    elem: '#L_hopeDate' //指定元素
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