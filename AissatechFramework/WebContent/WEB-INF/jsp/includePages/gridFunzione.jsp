<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<jsp:scriptlet>
   pageContext.setAttribute("tableclass", "simple");
</jsp:scriptlet>

<!-- INIZIO DISPLAYTAG -->	
<s:set name="funzioni" value="listaFunzione" scope="request"/>
<s:div id="displayTag">
<display:table id="funzioniList" name="funzioni" class="table" requestURI="listaFunzione.action" export="true" pagesize="10" sort="list" excludedParams="*">	
	<display:column media="html" property="id" title="Id" sortable="true" headerClass="sortable" titleKey="funzione.id"/>
	<display:column media="html" property="codice" title="Codice" sortable="true" headerClass="sortable" titleKey="funzione.codice"/>
	<display:column media="html" property="descrizione" title="Descrizione" sortable="true" headerClass="sortable" titleKey="funzione.descrizione"/>
	<display:column media="html" property="path" title="Path" sortable="true" headerClass="sortable" titleKey="funzione.path"/>
	<display:column decorator="com.aissa.aissatech.util.ImageWrapper" media="html" href="modificaFunzione.action" 
		paramProperty="id" paramId="id" title="" value="edit.png" autolink="true"/>	
	<display:column decorator="com.aissa.aissatech.util.ImageWrapper" media="html" href="cancellaFunzione.action" 
		paramProperty="id" paramId="id" title="" value="remove.png" autolink="true"/>	
</display:table>
</s:div>
<!-- FINE DISPLAYTAG -->