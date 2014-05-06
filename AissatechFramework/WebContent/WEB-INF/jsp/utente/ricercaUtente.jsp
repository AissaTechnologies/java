<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>	
	<title><s:text name="ricUtente.head.title" /></title>
</head>

<body>
<s:form action="ricercaUtente" validate="false">
<div class="base_template">		
	<div class="template">			
		<div class="header"><jsp:include page="/WEB-INF/jsp/layout/header.jsp" /></div>
		
		<div class="page_content">				
			<div class="menu"><jsp:include page="/WEB-INF/jsp/layout/menu.jsp" /></div>
			<div class="button">				
				<s:submit align="left" title="Ricerca Utente" id="ricerca" name="ricerca" type="image" src="images/search.png" />
			</div>
			<div class="title"><s:text name="ricercaUtente.title"/></div>	
			<p style="height:100px;"></p>			
			<div id="content" style="width:300px;">				
				<s:textfield id="userRic" label="Username" name="username" />								
			</div>									
		</div>		
	</div>	
	<div class="footer"><jsp:include page="/WEB-INF/jsp/layout/footer.jsp" /></div>
</div>
</s:form>	
</body>
</html>