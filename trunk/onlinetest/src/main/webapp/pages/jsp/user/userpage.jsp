<%@ taglib prefix="s" uri="/struts-tags"%>
<h1><a href="doUserAction.action?actionName=addUserView">Add User</a></h1>
<table class="data-grid">
	<tr>
		<th width="40%">Name</th>
		<th width="20%">School</th>
		<th width="20%">Class</th>
		<th width="20%">Role</th>
	</tr>
	<s:iterator value="userDto.userList" id="user" status="rowStatus">
	<tr>
		<td><s:property value="#user.userFullName" /></td>
		<td><s:property value="#user.school.name" /></td>
		<td><s:property value="#user.userClass.name" /></td>
		<td><s:property value="#user.role" /></td>
	</tr>
	</s:iterator>
</table>