<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.aissa.aissatech.pojo.Profilo"%>
<html>
<head>
	<title><s:text name="aggProfilo.head.title" /></title>
</head>

<body>
<s:form action="aggiornaProfilo.action" validate="false">	
<div class="base_template">		
	<div class="template">			
		<div class="header"><jsp:include page="/WEB-INF/jsp/layout/header.jsp" /></div>
		<div class="page_content">				
			<div class="menu"><jsp:include page="/WEB-INF/jsp/layout/menu.jsp" /></div>
			<div class="button">				
				<s:submit align="left" type="image" name="conferma" id="conferma" src="images/confirm.png" title="Conferma"/>				
			</div>
			<div class="title"><s:text name="aggiornamentoProfilo.title"/></div>				
			<div id="content">
				<table id="table">
					<tr>
						<td>
							<s:textfield readonly="true" id="id" label="Id" name="id" value="%{profilo.id}"></s:textfield>
							<s:textfield id="descMod" label="Profilo" name="descMod" value="%{profilo.descrizione}"></s:textfield>								
						</td>
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