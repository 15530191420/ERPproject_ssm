package com.tledu.wyb.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardUtil {
	public static void forward(HttpServletRequest request,
			HttpServletResponse response, String viewName)
			throws ServletException, IOException {
		// 所有页面必须放在/WEB-INF/jsp下 并且 后缀都是 .jsp
		// a/b/c/d
		// a/b/c/xxx
		request.getRequestDispatcher("/WEB-INF/jsp/" + viewName + ".jsp")
				.forward(request, response);
	}
}
