<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>   
    <script type="text/javascript" src="js/jquery.js"></script><!-- 1.8.3.min -->
    <script type="text/javascript" src="js/jquery-ui.js"></script><!-- 1.9.2.min -->
    <script type="text/javascript" src="js/jquery.datepick-it.js"></script>  
    <link type="text/css" rel="stylesheet" href="css/jquery-ui.css" />
    <link type="text/css" rel="stylesheet" href="css/base_template.css" />
    <link type="text/css" rel="stylesheet" href="css/template.css" />
    <link type="text/css" rel="stylesheet" href="css/global_page.css" />
    <link type="text/css" rel="stylesheet" href="css/displaytag.css" />
    <script>
	    $(document).ready(function() {
	        $("#accordion").accordion();
	    });
    </script>
</head>
<body>
<%
	//solo per la stampa dei profili sulla console
	/* String profilo = request.getSession().getAttribute("tipoProfilo").toString(); 
	System.out.println("profilo dalla request = " + profilo); */
%>
<div id="accordion">
    <h3 id="menu_accord"><img src="images/ul_anag.png">&nbsp;&nbsp;<s:text name="Gest.Anag"/></h3>
    <div>
        <ul>
            <li id="li_anag">
            	<a href='<s:url action="presentaAnagrafica" />'>
            		<s:text name="Anagrafica" />
            	</a>
            </li>           
        </ul>
    </div>   
    <h3 id="menu_accord"><img src="images/ul_tab.png">&nbsp;&nbsp;<s:text name="Gest.Tab"/></h3>
    <div>
        <ul><!-- <ul id="sottomenu_accord"> -->
            <li>            	            	 
            	<!-- <a href='<s:url action="A" />'> -->
            		<s:text name="Lista A" />
            	<!-- </a> -->
            </li>
            <li>
            	<!-- <a href='<s:url action="B" />'> -->
            		<s:text name="Lista B" />
            	<!-- </a> -->
            </li>
            <li>
            	<!-- <a href='<s:url action="C" />'> -->
            		<s:text name="Lista C" />
            	<!-- </a> -->
            </li>          
        </ul>
    </div>
    <h3 id="menu_accord"><img src="images/ul_sicur.png">&nbsp;&nbsp;<s:text name="Gest.Sicur"/></h3>
    <div>
    	<ul>
    		<s:if test="#session.tipoProfilo == 1">   		
            <li id="li_user">
            	<a href='<s:url action="presentaUtente" />'>
            		<s:text name="Utente" />
            	</a>
            </li>
            </s:if>
            <s:if test="#session.tipoProfilo != 1">   		
            <li id="li_user">
            	<a href='<s:url action="modPwdUtente" />'>
            		<s:text name="Mod.Pwd" />
            	</a>
            </li>
            </s:if>
            <li id="li_funz">
            	<a href='<s:url action="presentaFunzione" />'>
            		<s:text name="Funzione" />
            	</a>
            </li> 
            <li id="li_prof">
            	<a href='<s:url action="listaProfilo" />'>
            		<s:text name="Profilo" />
            	</a>
            </li>
            <s:if test="#session.tipoProfilo == 1">
            <li id="li_abil">
            	<a href='<s:url action="presentaAbilitazione" />'>
            		<s:text name="Abilitazione" />
            	</a>
            </li>
            </s:if>
            <!-- <li id="li_modPwd">
            	<a href='<s:url action="modificaPassword" />'>
            		<s:text name="Mod.Pwd" />
            	</a>
            </li> -->
        </ul>
    </div>
    <h3 id="menu_accord"><img src="images/ul_logout.png">&nbsp;&nbsp;<s:text name="Logout"/></h3>
    <div>
        <ul>
            <li id="li_out">
            	<a href='<s:url action="logout" />'>
            		<s:text name="Logout" />
            	</a>
            </li>                  
        </ul>
    </div>
</div> 
 
</body>
</html>