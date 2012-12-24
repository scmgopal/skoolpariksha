<%@ taglib prefix="s" uri="/struts-tags"%>
	<s:form action="doUserTest" method="POST" theme="simple">
		<s:hidden name="userTestDto.testId" id="userTestDto.testId"></s:hidden>
		<s:hidden name="userTestDto.actionName" id="userTestDto.actionName"></s:hidden>
		<h1> <a href="doUserTest.action?actionName=addTestView">Add Test</a></h1>
 		 <table class="data-grid">
			<tr>
				<th width="10%">Test Name</th>
				<th width="10%">Class</th>
				<th width="10%">No Of Question</th>
				<th width="20%">Marks For Each Question</th>
				<th width="30%">Negative Marks</th>
				<th width="10%">Is Active</th>
				<th width="10%">Action</th>
			</tr>
			<s:iterator value="userTestDto.tests" id="test" status="rowStatus">
				<tr>
					<td><a href="javascript:getQutionView('<s:property value="#test.id" />')" ><s:property value="#test.name" /></a></td>
					<td><s:property value="#test.testClass.name" /></td>
					<td><s:property value="#test.noOfQuestion" /></td>
					<td><s:property value="#test.questionMarks" /></td>
					<td><s:property value="#test.negativeMarks" /></td>
					<td><s:property value="#test.isActive" /></td>
					<td><a href="javascript:editTest('<s:property value="#test.id" />')">Edit</a></td>
				</tr>
			</s:iterator>
		</table>
	</s:form>

<script>
function getQutionView(testId) {
	document.getElementById('userTestDto.testId').value=testId;
	document.doUserTest.action="/onlinetest/prabhat/doUserQuestion.action";
	document.doUserTest.submit();
}

function editTest(testId) {
	document.getElementById('userTestDto.testId').value=testId;
	document.getElementById('userTestDto.actionName').value="editTestView";
	document.doUserTest.submit();
}
</script>