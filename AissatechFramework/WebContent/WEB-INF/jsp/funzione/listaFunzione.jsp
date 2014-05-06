<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
	<title><s:text name="listFunz.head.title" /></title>
</head>

<body>
<div class="base_template">		
	<div class="template">			
		<div class="header"><jsp:include page="/WEB-INF/jsp/layout/header.jsp" /></div>
		<div class="page_content">				
			<div class="menu"><jsp:include page="/WEB-INF/jsp/layout/menu.jsp" /></div>
			<div class="button"><a href="<s:url action='inserisciFunzione.action' />"><img src="images/insert.png" align="left" border="0" title="Inserisci funzione" /></a></div>			
			<div class="title"><s:text name="listaFunzione.title"/></div>				
			<div id="content">				
				<s:if test="listaFunzione != null">					
					<jsp:include page="/WEB-INF/jsp/includePages/gridFunzione.jsp"></jsp:include>						
				</s:if>
			</div>				
		</div>
	</div>	
	<div class="footer"><jsp:include page="/WEB-INF/jsp/layout/footer.jsp" /></div>
</div>
</body>
</html>
