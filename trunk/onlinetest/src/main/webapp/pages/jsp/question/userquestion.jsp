<%@ taglib prefix="s" uri="/struts-tags"%>
<s:form action="doUserQuestion" method="POST" theme="simple">
	<s:hidden name="questionDto.testId" id="questionDto.testId"></s:hidden>
	<s:hidden name="questionDto.actionName" id="questionDto.actionName"></s:hidden>
	<h1><a href="javascript:submitAddQuestionView()">Add Question</a></h1>
	<table class="data-grid">
		<tr>
		    <th width="29%">Question</th>
		    <th width="12%">Choice A</th>
		    <th width="12%">Choice B</th>
		    <th width="12%">Choice C</th>
		    <th width="12%">Choice D</th>
		    <th width="13%">Correct Answer</th>
		    <th width="10%">Action</th>
		</tr>
		<s:iterator value="questionDto.questionList" id="question" status="rowStatus">
			<tr>
				<td><s:property value="#question.name" /></td>
				<td><s:property value="#question.optA" /></td>
				<td><s:property value="#question.optB" /></td>
				<td><s:property value="#question.optC" /></td>
				<td><s:property value="#question.optD" /></td>
				<td><s:property value="#question.optAns" /></td>
			<td><a href="" onclick="editQuestion('<s:property value="#question.id" />')">Edit</a></td>
			</tr>
		</s:iterator>
	</table>
</s:form>
<script>
	function submitAddQuestionView() {
		document.getElementById('questionDto.actionName').value="addQuestionView";
		document.doUserQuestion.submit();
	}
</script>
