<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
	<title><s:text name="listAnag.head.title" /></title>
</head>

<body>
	<div class="base_template">		
		<div class="template">			
			<div class="header"><jsp:include page="/WEB-INF/jsp/layout/header.jsp" /></div>
			<div class="page_content">				
				<div class="menu"><jsp:include page="/WEB-INF/jsp/layout/menu.jsp" /></div>
				<div class="button"><a href="<s:url action='inserisciAnagrafica.action' />"><img src="images/insert.png" align="left" border="0" title="Inserisci anagrafica" /></a></div>
				<div class="title"><s:text name="listaAnagrafica.title"/></div>				
				<div id="content">
					<s:if test="listaAnagrafica != null">						
						<jsp:include page="/WEB-INF/jsp/includePages/gridAnagrafica.jsp"></jsp:include>							
					</s:if>	
				</div>				
			</div>
		</div>	
		<div class="footer"><jsp:include page="/WEB-INF/jsp/layout/footer.jsp" /></div>
	</div>
</body>
</html>
