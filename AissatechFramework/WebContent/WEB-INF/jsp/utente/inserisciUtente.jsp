<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
	<title><s:text name="insUtente.head.title" /></title>
</head>

<body>
<s:form action="salvaUtente.action" validate="false">
<div class="base_template">	
	<div class="template">			
		<div class="header"><jsp:include page="/WEB-INF/jsp/layout/header.jsp" /></div>
		<div class="page_content">			
			<div class="title"><s:text name="nuovaReg.title"/></div>				
			<div id="content">				
				<table id="table">					
					<tr>
						<td>
							<s:textfield label="USERNAME" name="user"></s:textfield>
						</td>
					</tr>
					<tr>
						<td>
							<s:textfield label="PASSWORD" name="pwd"></s:textfield>
						</td>
					</tr>
					<tr>
						<td>
							<s:textfield label="CODICE FISCALE" name="cf"></s:textfield>
						</td>
					</tr>					
					<s:select
						name="idProfilo"
						label="PROFILO" 
						headerKey="0"
						headerValue="-- Seleziona il profilo --"
						list="listaProfilo" 
						listKey="id"
						listValue="descrizione"
					/>
					<tr>
						<td>&nbsp;</td>
					</tr>	
					<tr>
						<td>
							<s:submit />
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