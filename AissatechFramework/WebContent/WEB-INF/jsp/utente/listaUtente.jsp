<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
</head>

<body>
<div class="base_template">		
	<div class="template">			
		<div class="header"><jsp:include page="/WEB-INF/jsp/layout/header.jsp" /></div>
		<div class="page_content">				
			<div class="menu"><jsp:include page="/WEB-INF/jsp/layout/menu.jsp" /></div>
			<div class="button"></div>
			<div class="title"><s:text name="listaUtente.title"/></div>				
			<div id="content">
				<s:if test="listaUtente != null">					
					<jsp:include page="/WEB-INF/jsp/includePages/gridUtente.jsp"></jsp:include>						
				</s:if>	
			</div>				
		</div>
	</div>	
	<div class="footer"><jsp:include page="/WEB-INF/jsp/layout/footer.jsp" /></div>
</div>
</body>
</html>
