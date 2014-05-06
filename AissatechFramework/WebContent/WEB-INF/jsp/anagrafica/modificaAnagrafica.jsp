<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.aissa.aissatech.pojo.Anagrafica"%>
<%@page import="com.aissa.aissatech.util.DateUtil"%>
<%@page import="java.util.Date" %>

<html>
<head>
	<title><s:text name="modAnag.head.title" /></title>
	<s:head theme="ajax" />
</head>

<body>
<s:actionmessage />
<s:form action="aggiornaAnagrafica.action" validate="false">
<div class="base_template">		
	<div class="template">			
		<div class="header"><jsp:include page="/WEB-INF/jsp/layout/header.jsp" /></div>
		<div class="page_content">				
			<div class="menu"><jsp:include page="/WEB-INF/jsp/layout/menu.jsp" /></div>
			<div class="button">				
				<s:submit align="left" type="image" name="conferma" id="conferma" src="images/confirm.png" title="Conferma"/>				
			</div>
			<div class="title"><s:text name="modificaAnagrafica.title"/></div>				
			<div id="content">
				<table id="table">
					<tr>
						<td>							
							<s:textfield id="id" label="Id" name="id" value="%{anagrafica.id}" readonly="true"></s:textfield>
							<s:textfield id="nomeMod" label="Nome" name="nome" value="%{anagrafica.nome}"></s:textfield>
							<s:textfield id="cognMod" label="Cognome" name="cognome" value="%{anagrafica.cognome}"></s:textfield>
							<s:textfield id="mat" label="Matricola" name="matricola" value="%{anagrafica.matricola}" readonly="true"></s:textfield>
							<s:textfield id="cfMod" label="CF" name="codiceFiscale" value="%{anagrafica.codiceFiscale}" readonly="true"></s:textfield>
							<s:datetimepicker id="valid" label="Validita" name="validMod" value="%{anagrafica.dataValidita}" displayFormat="dd/MM/yy"/>							
							<s:datetimepicker id="scad" label="Scadenza" name="scadMod" value="%{anagrafica.dataScadenza}" displayFormat="dd/MM/yy"/>							
							<s:textfield id="tipoCollab" label="Collab." name="tipoCollabMod" value="%{anagrafica.flagTipoCollab}"></s:textfield>											
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