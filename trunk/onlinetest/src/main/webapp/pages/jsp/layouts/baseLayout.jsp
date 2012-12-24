<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%> 


<html>
    <head>
            <title><tiles:insertAttribute name="title" ignore="true" /></title>
            <tiles:insertAttribute name="style-sheet" ignore="true" />
    </head>
    <body>
    	<div id="wrapper"> 
    		<div id="header">
    			<tiles:insertAttribute name="header" />
    		</div>
    		<div id="menu">
  				<tiles:insertAttribute name="menu-bar" />
  			</div>
  			<div id="content-container">
  				<tiles:insertAttribute name="body" />
  			</div>
    	</div>
    </body>
</html>
