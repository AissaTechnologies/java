<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<jsp:scriptlet>
   pageContext.setAttribute("tableclass", "simple");
</jsp:scriptlet>

<!-- INIZIO DISPLAYTAG -->	
<s:set name="profili" value="listaProfilo" scope="request"/>
<s:div id="displayTag">
<display:table id="profiloList" name="profili" class="table" requestURI="listaProfilo.action" export="true" pagesize="10" sort="list" excludedParams="*">	
	<display:column media="html" property="id" title="Id" sortable="true" headerClass="sortable" titleKey="profilo.id"/>
	<display:column media="html" property="descrizione" title="Descrizione" sortable="true" headerClass="sortable" titleKey="profilo.descrizione"/>
	<display:column media="html" property="flagTipoProfilo" title="Flag Tipo Profilo" sortable="true" headerClass="sortable" titleKey="profilo.flagTipoProfilo"/>
	<display:column decorator="com.aissa.aissatech.util.ImageWrapper" media="html" href="modificaProfilo.action" 
		paramProperty="id" paramId="id" title="" value="edit.png" autolink="true"/>	
	<display:column decorator="com.aissa.aissatech.util.ImageWrapper" media="html" href="cancellaProfilo.action" 
		paramProperty="id" paramId="id" title="" value="remove.png" autolink="true"/>
</display:table>
</s:div>
<!-- FINE DISPLAYTAG -->