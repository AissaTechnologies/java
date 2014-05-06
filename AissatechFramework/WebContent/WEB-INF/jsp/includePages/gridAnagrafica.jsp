<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<jsp:scriptlet>
   pageContext.setAttribute("tableclass", "simple");
</jsp:scriptlet>

<!-- INIZIO DISPLAYTAG -->	
<s:set name="anagrafiche" value="listaAnagrafica" scope="request"/>
<s:div id="displayTag">
<display:table id="anagraficaList" name="anagrafiche" class="table" requestURI="listaAnagrafica.action" export="true" pagesize="10" sort="list" excludedParams="*">	
	<display:column media="html" property="id" title="Id" sortable="true" headerClass="sortable" titleKey="anagrafica.id"/>
	<display:column media="html" property="nome" title="Nome" sortable="true" headerClass="sortable" titleKey="anagrafica.nome"/>
	<display:column media="html" property="cognome" title="Cognome" sortable="true" headerClass="sortable" titleKey="anagrafica.cognome"/>
	<display:column media="html" property="matricola" title="Matricola" sortable="true" headerClass="sortable" titleKey="anagrafica.matricola"/>
	<display:column media="html" property="codiceFiscale" title="Codice Fiscale" sortable="true" headerClass="sortable" titleKey="anagrafica.codiceFiscale"/>
	<display:column media="html" property="dataValidita" format="{0,date,dd-MM-yyyy}" title="Data Validita" sortable="true" headerClass="sortable" titleKey="anagrafica.dataValidita"/>
	<display:column media="html" property="dataScadenza" format="{0,date,dd-MM-yyyy}" title="Data Scadenza" sortable="true" headerClass="sortable" titleKey="anagrafica.dataScadenza"/>
	<display:column media="html" property="flagTipoCollab" title=" Tipo Collab." sortable="true" headerClass="sortable" titleKey="anagrafica.flagTipoCollab"/>
	<display:column decorator="com.aissa.aissatech.util.ImageWrapper" media="html" href="modificaAnagrafica.action" 
		paramProperty="id" paramId="id" title="" value="edit.png" autolink="true"/>	
	<display:column decorator="com.aissa.aissatech.util.ImageWrapper" media="html" href="cancellaAnagrafica.action" 
		paramProperty="id" paramId="id" title="" value="remove.png" autolink="true"/>	
</display:table>
</s:div>
<!-- FINE DISPLAYTAG -->