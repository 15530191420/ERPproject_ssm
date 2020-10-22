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
				<input type="hidden" name="id" value="${quality.id }" />
				<div class="layui-form-item">
					<label for="L_qualityTheme" class="layui-form-label"> <span
						class="x-red">*</span>质检申请单主题
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_qualityTheme" name="qualityTheme"
							readonly="readonly" value="${quality.qualityTheme }" required=""
							lay-verify="qualityTheme" autocomplete="off" class="layui-input">
					</div>
					<div class="layui-form-mid layui-word-aux">
						<span class="x-red">*</span>不可更改
					</div>
				</div>


				<div class="layui-form-item">
					<label for="L_originalType" class="layui-form-label"> <span
						class="x-red">*</span>源单类型
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_originalType" name="originalType"
							required="" value="${quality.originalType }"
							lay-verify="originalType" autocomplete="off" class="layui-input">
					</div>
				</div>
				
				<div class="layui-form-item">
					<label for="L_currentUnits" class="layui-form-label"> <span
						class="x-red">*</span>往来单位
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_currentUnits" name="currentUnits"
							required="" value="${quality.currentUnits }" lay-verify="currentUnits" autocomplete="off"
							class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label for="L_categ" class="layui-form-label"> <span
						class="x-red">*</span>往来单位大类
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_categ" name="categ" required="" value="${quality.categ }"
							lay-verify="categ" autocomplete="off" class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label for="L_inspectionMethods" class="layui-form-label"> <span
						class="x-red">*</span>检验方式
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_inspectionMethods" name="inspectionMethods" required="" value="${quality.inspectionMethods }"
							lay-verify="inspectionMethods" autocomplete="off" class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label for="L_inspectionPersonnel" class="layui-form-label">
						<span class="x-red">*</span>报检人员
					</label>
					<div class="layui-input-inline">
						<select name="inspectionPersonnel" lay-search 
							lay-verify="inspectionPersonnel">
							<c:choose>
								<c:when test="${empty users }">
									<option value="0">暂无可选</option>
								</c:when>
								<c:otherwise>
									<option value="${user.name}">请选择报检人员</option>
									<c:forEach items="${users }" var="user">
										<option value="${user.username }">${user.username }</option>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</select>
					</div>
				</div>

				<div class="layui-form-item">
					<label for="L_inspectionDept" class="layui-form-label"> <span
						class="x-red">*</span>报检部门
					</label>
					<div class="layui-input-inline">
						<select name="inspectionDept" lay-search value="${quality.inspectionDept }">
							<c:choose>
								<c:when test="${empty depts }">
									<option value="0">暂无可选部门</option>
								</c:when>
								<c:otherwise>
									<option value="${dept.name }">请选择目前部门</option>
									<c:forEach items="${depts }" var="dept">
										<option value="${dept.name}">${dept.name }</option>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</select>
					</div>
				</div>

				<div class="layui-form-item">
					<label for="L_inspectionDate" class="layui-form-label"> <span
						class="x-red">*</span>报检日期
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_inspectionDate" name="inspectionDate"
							value="${quality.inspectionDate }" required="" readonly="readonly"
							lay-verify="inspectionDate" autocomplete="off" class="layui-input">
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
		layui.use('laydate', function() {
			var laydate = layui.laydate;
			laydate.render({
				elem : '#L_inspectionDate'
			});
		});
		layui.use([ 'form', 'layer', 'jquery' ], function() {
			$ = layui.jquery;
			var form = layui.form, layer = layui.layer;

			//自定义验证规则
			form.verify({
				qualityTheme : function(value) {
					if (value.length < 1) {
						return '所属月份不能为空';
					}
				},
				originalType : function(value) {
					if (value.length < 1) {
						return '源单类型不能为空';
					}
				},
				inspectionMethods : function(value) {
					if (value.length < 1) {
						return '检验方式不能为空';
					}
				},
				inspectionPersonnel : function(value) {
					if (value.length < 1) {
						return '报检人员不能为空';
					}
				},
				inspectionDept : function(value) {
					if (value.length < 1) {
						return '报检部门不能为空';
					}
				},
				inspectionDate : function(value) {
					if (value.length < 1) {
						return '报检日期不能为空';
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