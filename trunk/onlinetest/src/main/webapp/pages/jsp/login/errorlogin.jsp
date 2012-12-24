<%@ taglib prefix="s" uri="/struts-tags"%>
<s:form action="doLogin" method="POST" validate="true">
	<table width="40%" cellspacing="1" cellpadding="2" border="0"
		align="center" class="tableBorder">
		<tbody>
			<tr>
				<td bgcolor="#ffffff">

				<table width="100%" cellspacing="0" cellpadding="0" border="0"
					align="center">
					<tbody>
						<tr>
							<td class="header_portlet">
							<table width="100%" cellspacing="0" cellpadding="0" border="0">
								<tbody>
									<tr class="Gadget_head">
										<td height="20" width="99%"><font class="beta style6"><b><span
											style="font-size: 8.5pt; font-family: Tahoma;"> Login
										</span></b></font></td>
									</tr>
								</tbody>
							</table>
							</td>
						</tr>
						<tr>
							<td bgcolor="#ffffff">
							<table width="100%" cellspacing="1" cellpadding="3" border="0"
								class="bodytext back_color">
								<tbody>
									<tr>
										<td colspan="2"><s:actionerror /> <s:fielderror /></td>
									</tr>
									<s:textfield name="username" label="Login name" />
									<s:password name="password" label="Password" />
									<s:submit theme="ajax" targets="loginDiv" value="Login" align="right" />
								</tbody>
							</table>
							</td>
						</tr>
					</tbody>
				</table>
				</td>
			</tr>
		</tbody>
	</table>

</s:form>

