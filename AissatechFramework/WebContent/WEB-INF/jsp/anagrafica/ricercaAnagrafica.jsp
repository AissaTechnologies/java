<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>	
	<title><s:text name="ricAnag.head.title" /></title>
	<s:head theme="ajax" />
</head>

<body>
<s:form action="ricercaAnagrafica" validate="false">
<div class="base_template">		
	<div class="template">			
		<div class="header"><jsp:include page="/WEB-INF/jsp/layout/header.jsp" /></div>		
		<div class="page_content">				
			<div class="menu"><jsp:include page="/WEB-INF/jsp/layout/menu.jsp" /></div>
			<div class="button">				
				<s:submit align="left" title="Ricerca anagrafica" id="ricerca" name="ricerca" type="image" src="images/search.png" />
			</div>
			<div class="title"><s:text name="ricercaAnagrafica.title"/></div>	
			<div id="content">
				<table>
					<tr>
						<td><s:textfield id="ricCogn" label="Cognome" name="cognome" /></td>
					</tr>
					<tr>
						<td><s:textfield id="ricMatr" label="Matricola" name="matricola" /></td>
					</tr>
				</table>								
			</div>									
		</div>		
	</div>	
	<div class="footer"><jsp:include page="/WEB-INF/jsp/layout/footer.jsp" /></div>
</div>
</s:form>	
</body>
</html>