<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="java.util.List"%>
<%@page import="com.aissa.aissatech.pojo.Abilitazione"%>
<%@page import="com.aissa.aissatech.pojo.Profilo"%>


<html>
<head>
	<title><s:text name="modAbil.head.title" /></title>
</head>

<body>
<%
 	List<Profilo> listaProfili = (List<Profilo>)request.getAttribute("listaProf");
	Abilitazione abil = (Abilitazione)request.getAttribute("abil");
	System.out.println("jsp, listaProfili size = " + listaProfili.size() + ", profilo selected = " + abil.getProfilo().getFlagTipoProfilo() + ", abil selected = " + abil.getAbilitato());
%>
<s:form action="aggiornaAbilitazione.action" validate="false">	
<div class="base_template">		
	<div class="template">			
		<div class="header"><jsp:include page="/WEB-INF/jsp/layout/header.jsp" /></div>
		<div class="page_content">				
			<div class="menu"><jsp:include page="/WEB-INF/jsp/layout/menu.jsp" /></div>
			<div class="button">				
				<s:submit align="left" type="image" name="conferma" id="conferma" src="images/confirm.png" title="Conferma"/>				
			</div>
			<div class="title"><s:text name="modificaAbilitazione.title"/></div>				
			<div id="content">
				<table id="table">
					<tr>
						<td>
							<s:textfield id="id" label="Id" name="id" value="%{abilitazione.id}" readonly="true" />
						</td>						
					</tr>
					<tr>
						<td>
							<s:textfield id="funzMod" label="Path" name="pathMod" value="%{abilitazione.funzione.path}" readonly="true"/>
						</td>						
					</tr>
					<tr>
						<td>
							<label>Profilo: </label>
						</td>
						<td>
							<select id="selProf" name="selProf" style="align: bottom;">
								<%
									for(Profilo prof : listaProfili) {
										if(abil.getProfilo().getFlagTipoProfilo() == prof.getFlagTipoProfilo()) {
								%>
										<option value="<%= prof.getFlagTipoProfilo()%>" selected="selected"><%= prof.getDescrizione()%></option>
								<%			
										}
										else {
								%>
									<option value="<%= prof.getFlagTipoProfilo()%>"><%= prof.getDescrizione()%></option>
								<%	
										}
									} 
								%>							
							</select>
						</td>						
					</tr>
					<tr>
						<td>
							<label>Abilitato: </label>
						</td>
						<td>
							<select id="selAbil" name="selAbil" style="width:50px;">
								<%								
									if(abil.getAbilitato() == 0) {
								%>
									<option value="0" selected="selected">NO</option>
									<option value="1">SI</option>
								<%			
									}
									if(abil.getAbilitato() == 1) {
								%>
									<option value="1" selected="selected">SI</option>
									<option value="0">NO</option>
								<%	
									}								
								%>							
							</select>
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