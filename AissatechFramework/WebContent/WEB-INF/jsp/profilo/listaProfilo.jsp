<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
	<title><s:text name="listProf.head.title" /></title>
</head>

<body>
<div class="base_template">		
	<div class="template">			
		<div class="header"><jsp:include page="/WEB-INF/jsp/layout/header.jsp" /></div>
		<div class="page_content">				
			<div class="menu"><jsp:include page="/WEB-INF/jsp/layout/menu.jsp" /></div>
			<div class="button">
				<s:if test="#session.tipoProfilo == 1">				
					<a href="<s:url action='inserisciProfilo.action' />"><img src="images/add_prof.png" align="left" border="0" title="Inserisci profilo" /></a>
				</s:if>				
			</div>
			<div class="title"><s:text name="listaProfilo.title"/></div>				
			<div id="content">
				<s:if test="listaProfilo != null">					
					<jsp:include page="/WEB-INF/jsp/includePages/gridProfilo.jsp"></jsp:include>
					<!-- <a href="<s:url action='modificaProfilo.action' />"><img src="images/edit_prof.png" align="left" border="0"  title="Modifica profilo" /></a>				
					<a href="<s:url action='cancellaProfilo.action' />"><img src="images/del_prof.png" align="left" border="0"  title="Cancella profilo" /></a>	 -->			
				</s:if>	
			</div>				
		</div>
	</div>	
	<div class="footer"><jsp:include page="/WEB-INF/jsp/layout/footer.jsp" /></div>
</div>
</body>
</html>
