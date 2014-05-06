<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
	<title><s:text name="insAbil.head.title" /></title>
</head>

<body>
<s:form action="salvaAbilitazione.action" validate="false">	
<div class="base_template">		
	<div class="template">			
		<div class="header"><jsp:include page="/WEB-INF/jsp/layout/header.jsp" /></div>
		<div class="page_content">				
			<div class="menu"><jsp:include page="/WEB-INF/jsp/layout/menu.jsp" /></div>
			<div class="button">				
				<s:submit align="left" type="image" name="conferma" id="conferma" src="images/confirm.png" title="Conferma"/>				
			</div>
			<div class="title"><s:text name="inserimentoAbilitazione.title"/></div>				
			<div id="content">
				<table id="table">
					<tr><td colspan="2"><s:actionmessage cssClass="actionMessage"/></td></tr>					
					<tr>
						<td>						
							<s:select	
								id="selFunz"							
								name="funzione.id"
								label="Funzione"								
								list="listaFunzione"								
								listKey="id"
								listValue="path"													
							/>						
						</td>
					</tr>
					<tr>
						<td>																					
							<s:select
								id="selProf"								
								name="profilo.id"
								label="Profilo"								
								list="listaProfilo"								 
								listKey="id"
								listValue="descrizione"																
							/>					
						</td>
					</tr>
					<tr>
						<td>																		
							<s:select
								id="selAbil"
								cssStyle="width:50px;" 
								name="abilitato"
								label="Abilitato"								
								list="#{'0':'NO', '1':'SI'}" 								
							/>
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