<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<jsp:scriptlet>
   pageContext.setAttribute("tableclass", "simple");
</jsp:scriptlet>

<!-- INIZIO DISPLAYTAG -->	
<s:set name="utenti" value="listaUtente" scope="request"/>
<s:div id="displayTag">
<display:table id="utentiList" name="utenti" class="table" requestURI="listaUtente.action" export="true" pagesize="10" sort="list" excludedParams="*">	
	<display:column media="html" property="username" title="Username" sortable="true" headerClass="sortable" titleKey="utente.username"/>
	<display:column media="html" property="password" title="Password" sortable="true" headerClass="sortable" titleKey="utente.password"/>	
</display:table>
</s:div>
<!-- FINE DISPLAYTAG -->