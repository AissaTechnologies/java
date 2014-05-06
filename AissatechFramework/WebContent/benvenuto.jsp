<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title><s:text name="welcome.head.title" /></title>
	</head>
	
	<body>
		<div class="base_template">
		<!-- BASE TEMPLATE -->
			<div class="template">
			<!-- TEMPLATE -->
				<div class="header"><jsp:include page="/WEB-INF/jsp/layout/header.jsp" /></div>
				<div class="page_content">
				<!-- PAGE CONTENT -->
					<div class="menu"><jsp:include page="/WEB-INF/jsp/layout/menu.jsp" /></div>
					<div class="button"><!-- BUTTON --></div>
					<div class="title"><!-- TITLE --></div>
					<div class="content"><!-- CONTENT -->
						<table id="benvenuto">
							<tr><td>			
							<br><br>
								<div id="welcome" align="center"><s:text name="welcome"/>
									 : <%= request.getSession().getAttribute("username") %>
								</div>
							</td></tr>
							<tr><td>			
							<br><br>
								<div id="choose" align="center"><s:text name="choose"/></div>
							</td></tr>				
						</table>
					</div>	
				</div>
			</div>	
			<div class="footer"><jsp:include page="/WEB-INF/jsp/layout/footer.jsp" /></div>
		</div>	
	</body>
</html>





