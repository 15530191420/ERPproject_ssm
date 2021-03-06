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
			<form class="layui-form" method="post" action="updateInput" id='form'>
				<!-- 隐藏ID -->
				<input type="hidden" name="id" value="${user.id }" />
				<div class="layui-form-item">
					<label for="L_username" class="layui-form-label"> <span
						class="x-red">*</span>用户名
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_username" name="username" required=""
							readonly="readonly" lay-verify="username"
							value="${user.username }" autocomplete="off" class="layui-input">
					</div>
					<div class="layui-form-mid layui-word-aux">
						<span class="x-red">*</span>不可更改
					</div>
				</div>
				<div class="layui-form-item">
					<label for="L_nickname" class="layui-form-label"> <span
						class="x-red">*</span>昵称
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_nickname" name="nickname" required=""
							value="${user.nickname }" lay-verify="nickname"
							autocomplete="off" class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label for="L_pass" class="layui-form-label"> <span
						class="x-red">*</span>密码
					</label>
					<div class="layui-input-inline">
						<input type="password" id="L_pass" name="password" required=""
							value="${user.password }" lay-verify="pass" autocomplete="off"
							class="layui-input">
					</div>
					<div class="layui-form-mid layui-word-aux">6到16个字符</div>
				</div>
				<div class="layui-form-item">
					<label for="L_repass" class="layui-form-label"> <span
						class="x-red">*</span>确认密码
					</label>
					<div class="layui-input-inline">
						<input type="password" id="L_repass" name="repass" required=""
							value="${user.password }" lay-verify="repass" autocomplete="off"
							class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label for="L_dept" class="layui-form-label"> <span
						class="x-red">*</span>所属部门
					</label>
					<div class="layui-input-inline">
						<!-- 					遍历所有部门,并默认选择当前部门 -->
						<select name="dept_id" lay-search>
							<c:choose>
								<c:when test="${empty depts }">
									<option value="0">暂无可选部门</option>
								</c:when>
								<c:otherwise>
									<c:forEach items="${depts }" var="dept">
										<c:choose>
											<c:when test="${user.dept.id eq dept.id }">
												<option value="${dept.id }" selected="selected">${dept.name }</option>
											</c:when>
											<c:otherwise>
												<option value="${dept.id }">${dept.name }</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</select>
					</div>
				</div>

				<div class="layui-form-item">
					<label for="L_age" class="layui-form-label"> <span
						class="x-red">*</span>年龄
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_age" name="age" required=""
							value="${user.age }" lay-verify="age" autocomplete="off"
							class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label for="L_sex" class="layui-form-label"> <span
						class="x-red">*</span>性别
					</label>
					<div class="layui-input-block">
						<c:if test="${user.sex eq 1 }">
							<input type="radio" name="sex" value="1" title="男" checked="">
							<input type="radio" name="sex" value="0" title="女">
						</c:if>
						<c:if test="${user.sex eq 0 }">
							<input type="radio" name="sex" value="1" title="男">
							<input type="radio" name="sex" value="0" title="女" checked="">
						</c:if>
					</div>
				</div>

				<div class="layui-form-item">
					<label for="L_repass" class="layui-form-label"></label>
					<button class="layui-btn" lay-filter="updateInput" lay-submit="">更新</button>
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
			
				nickname : function(value) {
					if (value.length < 5) {
						return '昵称至少得5个字符啊';
					}
				},
				pass : [ /(.+){6,12}$/, '密码必须6到12位' ],
				repass : function(value) {
					if ($('#L_pass').val() != $('#L_repass').val()) {
						return '两次密码不一致';
					}
				},
				age : function(value) {
					if (value.length < 1) {
						return '年龄不能为空';
					}
					// 隐式转换,可以直接把string转换为整数
					value -=0;
					// 判断是否是NaN
					if(isNaN(value)){
						return "请输入纯数字";
					}
					if(value <=0 || value > 150){
						return '年龄不合法';
					}
				},
			});

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