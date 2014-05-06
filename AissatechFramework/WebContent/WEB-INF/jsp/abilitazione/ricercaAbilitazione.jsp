<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>	
</head>

<body>
<s:form action="ricercaAbilitazione" validate="false">
<div class="base_template">		
	<div class="template">			
		<div class="header"><jsp:include page="/WEB-INF/jsp/layout/header.jsp" /></div>				
		<div class="page_content">				
			<div class="menu"><jsp:include page="/WEB-INF/jsp/layout/menu.jsp" /></div>
			<div class="button">				
				<s:submit align="left" title="Ricerca abilitazione" id="ricerca" name="ricerca" type="image" src="images/search.png" />
			</div>
			<div class="title"><s:text name="ricercaAbilitazione.title"/></div>						
			<div id="content" style="width:300px;">	
				<table id="table">
					<tr>
						<td>			
							<s:select
								cssStyle="width:50px;" 
								label="Abilitato" 					
								id="abil" 
								name="abilitato" 
								list="#{'':'--','0':'NO', '1':'SI'}" 
							/>
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