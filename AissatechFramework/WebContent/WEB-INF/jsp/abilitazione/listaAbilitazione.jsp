<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="java.util.List"%>
<%@page import="com.aissa.aissatech.pojo.Abilitazione"%>

<html>
<head>
</head>

<body>
<div class="base_template">		
	<div class="template">			
		<div class="header"><jsp:include page="/WEB-INF/jsp/layout/header.jsp" /></div>
		<div class="page_content">				
			<div class="menu"><jsp:include page="/WEB-INF/jsp/layout/menu.jsp" /></div>
			<div class="button"><a href="<s:url action='inserisciAbilitazione.action' />"><img src="images/insert.png" align="left" border="0" title="Inserisci abilitazione" ></a></div>
			<div class="title"><s:text name="listaAbilitazione.title"/></div>				
			<div id="content">
				<s:if test="listaAbilitazione != null">						
					<jsp:include page="/WEB-INF/jsp/includePages/gridAbilitazione.jsp"></jsp:include>							
				</s:if>				
			</div>				
		</div>
	</div>	
	<div class="footer"><jsp:include page="/WEB-INF/jsp/layout/footer.jsp" /></div>
</div>
</body>
</html>
