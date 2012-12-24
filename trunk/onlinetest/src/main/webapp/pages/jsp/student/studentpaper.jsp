<%@ taglib prefix="s" uri="/struts-tags"%>
<s:form action="doSudentAction" method="POST" theme="simple">
	<s:hidden name="questionDto.actionName" id="questionDto.actionName" value="submitPaper"></s:hidden>
	<s:hidden name="questionDto.testId" id="questionDto.testId"></s:hidden>
	<div id="examTimer" style="width: 100%;" ></div>
	<s:iterator value="questionDto.questionList" id="quetion"  status="rowStatus">
		<div id="quetionID<s:property value="#rowStatus.index" />" style="display: <s:if test="#rowStatus.first"></s:if><s:else>none</s:else>; ">
				Question No <s:property value="#rowStatus.index + 1" /> : <s:property value="#quetion.name" />
				<br/>
				A : <s:property value="#quetion.optA" />
				<br/>
				B : <s:property value="#quetion.optB" />
				<br/>
				C : <s:property value="#quetion.optC" />
				<br/>
				D : <s:property value="#quetion.optD" />
				<br/>
				E : <s:property value="#quetion.optE" />
				<br/>
				Select Answer : 
				<select id="studentChoice<s:property value="#rowStatus.index" />" name="questionDto.studentChoice">
					<option value="-1">Select</option>
					<option value="<s:property value="#quetion.id" />-a">A</option>
					<option value="<s:property value="#quetion.id" />-b">B</option>
					<option value="<s:property value="#quetion.id" />-c">C</option>
					<option value="<s:property value="#quetion.id" />-d">D</option>
					<option value="<s:property value="#quetion.id" />-e">E</option>
				</select>
				
				<br/>
				<s:if test="!#rowStatus.first"><a href="javascript:previousPage('<s:property value="#rowStatus.index" />')">Previous</a>&nbsp;</s:if><s:if test="!#rowStatus.last"><a href="javascript:nextPage('<s:property value="#rowStatus.index" />')">next</a></s:if>
		</div>
	</s:iterator>
	<div><s:submit label="Save" theme="simple"></s:submit></div>
</s:form>
<script>

window.onload=initAllMethod;

function previousPage(currentPage) {
	document.getElementById('quetionID' + currentPage).style.display="none";
	var questionNo = parseInt(currentPage);
	questionNo = questionNo - 1;
	document.getElementById('quetionID' + questionNo).style.display="";
}

function nextPage(currentPage) {
	document.getElementById('quetionID' + currentPage).style.display="none";
	var questionNo = parseInt(currentPage);
	questionNo = questionNo + 1;
	document.getElementById('quetionID' + questionNo).style.display="";
}

function Tick(TotalSeconds) {

	if (TotalSeconds == 0) {
		//document.doSudentAction.submit();
	}
	if (TotalSeconds == 300) {
		alert("You have only 5 minute time remain.")
	}
	if (TotalSeconds == 60) {
		alert("You have only 1 minute time remain. Please submit your questions.")
	}
    TotalSeconds -= 1;
    UpdateTimer(TotalSeconds)
    window.setTimeout("Tick('"+TotalSeconds +"')", 1000);
}

function UpdateTimer(TotalSeconds) {
	var hrs = Math.floor(TotalSeconds / 3600);
	var totalSecond = TotalSeconds % 3600;
	var minute = Math.floor(totalSecond / 60);
	var totalSecond = TotalSeconds % 60;
	document.getElementById('examTimer').innerHTML = hrs + " : " + minute + " : " + totalSecond;
}
function initAllMethod() {
	Tick(2 * 60);
}
</script>