<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
	<title><s:text name="modPwdUtente.head.title" /></title>
</head>

<body>
<s:form action="modPwdUtente.action" validate="false">
<div class="base_template">	
	<div class="template">			
		<div class="header"><jsp:include page="/WEB-INF/jsp/layout/header.jsp" /></div>
		<div class="page_content">
			<div class="menu"><jsp:include page="/WEB-INF/jsp/layout/menu.jsp" /></div>
			<div class="button"></div>			
			<div class="title"><s:text name="modPwdUtente.title"/></div>				
			<div id="content">				
				<table id="table">					
					<!-- <tr>
						<td>
							<s:textfield label="PASSWORD" name="pwd" value="utente.pwd" ></s:textfield>
						</td>
					</tr> -->
					<tr>
						<td>
							<s:password label="Nuova" name="newPwd"></s:password>
						</td>
					</tr>
					<tr>
						<td>
							<s:password label="Ripeti" name="ripPwd"></s:password>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>	
					<tr>
						<td>
							<s:submit align="center" type="image" name="confirm" id="confirm" src="images/confirm.png" title="Conferma" />
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