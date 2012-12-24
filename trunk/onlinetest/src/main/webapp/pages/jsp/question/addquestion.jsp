<%@ taglib prefix="s" uri="/struts-tags"%>
<s:form action="doUserQuestion" method="POST" theme="simple">
<s:hidden id="questionDto.actionName" name="questionDto.actionName" value="saveQuestion"></s:hidden>
<s:hidden id="questionDto.testId" name="questionDto.testId"></s:hidden>
<s:fielderror />
<table>
	<tr><td>Question:</td><td><s:textarea id="questionDto.questionName" name="questionDto.questionName" theme="simple" required="true"></s:textarea></td></tr>
	<tr><td colspan="2">Answer Option</td></tr>
	<tr><td>A:</td><td><s:textfield id="questionDto.optA" name="questionDto.optA" theme="simple" required="true"></s:textfield></td></tr>
	<tr><td>B:</td><td><s:textfield id="questionDto.optB" name="questionDto.optB" theme="simple" required="true"></s:textfield></td></tr>
	<tr><td>C:</td><td><s:textfield id="questionDto.optC" name="questionDto.optC" theme="simple" required="true"></s:textfield></td></tr>
	<tr><td>D:</td><td><s:textfield id="questionDto.optD" name="questionDto.optD" theme="simple" required="true"></s:textfield></td></tr>
	<tr><td>E:</td><td><s:textfield id="questionDto.optE" name="questionDto.optE" theme="simple"></s:textfield></td></tr>
	
	<tr><td colspan="2">Answer</td></tr>
	<tr><td>Option</td><td>
		<s:select id="questionDto.optAns" name="questionDto.optAns" theme="simple" headerKey="-1" headerValue="Select" list="#{'a':'A', 'b':'B', 'c':'C', 'd':'D', 'e':'E'}" />
	</td></tr>
	<tr><td colspan="2"><s:submit label="Save" theme="simple"></s:submit></td></tr>
</table>
</s:form>