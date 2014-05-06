<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<jsp:scriptlet>
   pageContext.setAttribute("tableclass", "simple");
</jsp:scriptlet>

<!-- INIZIO DISPLAYTAG -->	
<s:set name="abilitazioni" value="listaAbilitazione" scope="request"/>
<s:div id="displayTag">
<display:table id="abilitazioniList" name="abilitazioni" class="table" requestURI="ricercaAbilitazione.action" export="true" pagesize="10" sort="list" excludedParams="*">	
	<display:column media="html" property="id" title="Id" sortable="true" headerClass="sortable" titleKey="abilitazione.id"/>
	<display:column media="html" property="funzione.codice" title="Codice Funzione" sortable="true" headerClass="sortable" titleKey="abilitazione.funzione.codice"/>
	<display:column media="html" property="funzione.descrizione" title="Descrizione Funzione" sortable="true" headerClass="sortable" titleKey="abilitazione.funzione.descrizione"/>
	<display:column media="html" property="funzione.path" title="Path Funzione" sortable="true" headerClass="sortable" titleKey="abilitazione.funzione.path"/>
	<display:column media="html" property="profilo.descrizione" title="Descrizione Profilo" sortable="true" headerClass="sortable" titleKey="abilitazione.profilo.descrizione"/>	
	<display:column media="html" property="abilitato" title="Abilitato" sortable="true" headerClass="sortable" titleKey="abilitazione.abilitato"/>
		<display:column decorator="com.aissa.aissatech.util.ImageWrapper" media="html" href="modificaAbilitazione.action" 
		paramProperty="id" paramId="id" title="" value="edit.png" autolink="true"/>	
	<display:column decorator="com.aissa.aissatech.util.ImageWrapper" media="html" href="cancellaAbilitazione.action" 
		paramProperty="id" paramId="id" title="" value="remove.png" autolink="true"/>
</display:table>
</s:div>
<!-- FINE DISPLAYTAG -->