<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
	<title><s:text name="insAnag.head.title" /></title>
</head>

<body>
<s:form action="salvaAnagrafica.action" validate="false">	
<div class="base_template">		
	<div class="template">			
		<div class="header"><jsp:include page="/WEB-INF/jsp/layout/header.jsp" /></div>
		<div class="page_content">				
			<div class="menu"><jsp:include page="/WEB-INF/jsp/layout/menu.jsp" /></div>
			<div class="button">				
				<s:submit align="left" type="image" name="conferma" id="conferma" src="images/confirm.png" title="Conferma"/>				
			</div>
			<div class="title"><s:text name="inserisciAnagrafica.title"/></div>				
			<div id="content">
				<table id="table">
					<tr>
						<td>
							<s:textfield id="nomeIns" label="Nome" name="nome"></s:textfield>
							<s:textfield id="cognIns" label="Cognome" name="cognome"></s:textfield>
							<s:textfield id="cfIns" label="CF" name="codiceFiscale"></s:textfield>							
							<s:textfield id="valIns" label="Validità" name="dataValidita"></s:textfield>
							<s:textfield id="scadIns" label="Scadenza" name="dataScadenza"></s:textfield>							
							<s:select
								name="new java.lang.String(anagrafica.flagTipoCollab)"
								label="Tipo Collab." 
								headerKey="0"
								headerValue="-- Seleziona tipo collab --"
								list="listaProfilo" 
								listKey="id"
								listValue="flagTipoProfilo"/>
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