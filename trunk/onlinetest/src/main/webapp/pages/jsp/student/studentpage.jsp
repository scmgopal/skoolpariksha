<%@ taglib prefix="s" uri="/struts-tags"%>
<s:form action="doSudentAction" method="POST" theme="simple">
<s:hidden name="questionDto.actionName" id="questionDto.actionName"></s:hidden>
<s:hidden name="questionDto.testId" id="questionDto.testId"></s:hidden>
	<table>
		<tr><td>Pending Test </td></tr>
		<s:iterator value="userDto.pendingTestList" id="test" status="rowStatus">
			<tr><td><a href="javascript:showStudentTest('<s:property value="#test.id" />')"><s:property value="#test.name" /></a></td></tr>
		</s:iterator>
	</table>
</s:form>

<script>
	function showStudentTest(testId) {
		document.getElementById('questionDto.actionName').value="showStudentTest";
		document.getElementById('questionDto.testId').value=testId;
		document.doSudentAction.submit();
	}
</script>