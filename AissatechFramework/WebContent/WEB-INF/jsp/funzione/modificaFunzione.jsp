<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.aissa.aissatech.pojo.Funzione"%>

<html>
<head>
	<title><s:text name="modFunz.head.title" /></title>
</head>

<body>
<s:actionmessage />
<s:form action="aggiornaFunzione.action" validate="false">
<div class="base_template">		
	<div class="template">			
		<div class="header"><jsp:include page="/WEB-INF/jsp/layout/header.jsp" /></div>
		<div class="page_content">				
			<div class="menu"><jsp:include page="/WEB-INF/jsp/layout/menu.jsp" /></div>
			<div class="button">				
				<s:submit align="left" type="image" name="conferma" id="conferma" src="images/confirm.png" title="Conferma"/>				
			</div>
			<div class="title"><s:text name="modificaFunzione.title"/></div>				
			<div id="content">
				<table id="table">
					<tr>
						<td>						
							<s:textfield readonly="true" id="id" label="Id" name="id" value="%{funzione.id}" />
							<s:textfield id="codMod" label="Codice" name="codMod" value="%{funzione.codice}" />
							<s:textfield id="descMod" label="Descrizione" name="descMod" value="%{funzione.descrizione}" />
							<s:textfield id="pathMod" label="Path" name="pathMod" value="%{funzione.path}"></s:textfield>							
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