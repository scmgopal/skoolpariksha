<%@ taglib prefix="s" uri="/struts-tags"%>
<s:form action="doLogin" method="POST" validate="true" theme="simple">
	

	<div class="banner-section">
	<h1>Pass Your Exam!</h1>
	<h2>your success is our success, our single mission is to ensure
	you pass you exam on your first attempt</h2>
	</div>
	<div class="signin">
	<h2>Sign in</h2>
	<s:actionerror />
	<s:fielderror />
	<div><label for="email"><strong>Login name</strong></label> <s:textfield
		id="loginName" name="loginName" theme="simple" label="Login name" /></div>
	<div><label for="password"><strong>Password</strong></label> <s:password
		id="password" name="password" theme="simple" label="Password" /></div>

	<label> <s:submit name="SignIn" value="Sign in" /> </label></div>
</s:form>

