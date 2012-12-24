<%@ taglib prefix="s" uri="/struts-tags"%>
<s:form action="doUserTest" method="POST" theme="simple">
<s:hidden id="userTestDto.actionName" name="userTestDto.actionName" value="addTest"></s:hidden>
<s:hidden name="userTestDto.testId" id="userTestDto.testId"></s:hidden>
<s:fielderror />
<table>
	<tr><td>Test Name</td><td><s:textfield id="userTestDto.testName" name="userTestDto.testName" theme="simple" required="true"></s:textfield></td></tr>
	<tr><td>Class</td><td><s:select id="userTestDto.classId" name="userTestDto.classId" headerKey="-1" headerValue="Select" listKey="id" listValue="name" list="userTestDto.userClasses" theme="simple"/></td></tr>
	<tr><td>No of question</td><td><s:textfield id="userTestDto.noOfQuestion" name="userTestDto.noOfQuestion" theme="simple" required="true"></s:textfield></td></tr>
	
	<tr><td>Mark for Each question</td><td><s:textfield id="userTestDto.questionMarks" name="userTestDto.questionMarks" theme="simple" required="true"></s:textfield></td></tr>
	<tr><td>Negative Marks</td><td><s:textfield id="userTestDto.negativeMarks" name="userTestDto.negativeMarks" theme="simple" required="true"></s:textfield></td></tr>
	<tr><td>Is Active</td><td><s:select id="userTestDto.isActive" name="userTestDto.isActive" theme="simple" headerKey="-1" headerValue="Select" list="#{'true':'Active', 'false':'In-Active'}" /></td></tr>
	
	<tr><td colspan="2"><s:submit label="Save" theme="simple"></s:submit></td></tr>
</table>
</s:form>