<%@ taglib prefix="s" uri="/struts-tags"%>
<s:form action="doUserAction" method="POST" theme="simple">
<s:hidden theme="simple" id="userDto.actionName" name="userDto.actionName" value="addUser"></s:hidden>
<s:fielderror />
<table>
	<tr><td>First Name</td><td><s:textfield id="userDto.firstName" name="userDto.firstName" theme="simple" required="true"></s:textfield></td></tr>
	<tr><td>Middle Name</td><td><s:textfield id="userDto.middleName" name="userDto.middleName" theme="simple" required="true"></s:textfield></td></tr>
	<tr><td>Last Name</td><td><s:textfield id="userDto.lastName" name="userDto.lastName" theme="simple" required="true"></s:textfield></td></tr>
	<tr><td>Class</td><td><s:select id="userDto.classId" name="userDto.classId" headerKey="-1" headerValue="Select" listKey="id" listValue="name" list="userDto.userClasses" theme="simple"/></td></tr>
	<tr><td colspan="2"><s:submit label="Save" theme="simple"></s:submit></td></tr>
</table>
</s:form>