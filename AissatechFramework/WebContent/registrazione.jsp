<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
	<title><s:text name="registration.head.title" /></title>
</head>

<body>
<div class="base_template">		
	<div class="template">			
		<div class="header"><jsp:include page="/WEB-INF/jsp/layout/header.jsp" /></div>		
		<div class="page_content">				
			<div class="menu"></div>
			<div class="button"></div>
			<div class="title"><s:text name="registrazione.title"/></div>	
			<div id="content">
				<table style="align:center;">
					<tr>
						<td>Utente non registrato</td>
					</tr>
					<tr>
						<td>Procedi con la <a href='<s:url action="inserisciUtente" />'>registrazione</a></td>
					</tr>
					<tr>
						<td>
							<a href='<s:url action="logout" />'>Annulla</a>
						</td>
					</tr>
				</table>								
			</div>									
		</div>		
	</div>	
	<div class="footer"><jsp:include page="/WEB-INF/jsp/layout/footer.jsp" /></div>
</div>
</body>
</html>