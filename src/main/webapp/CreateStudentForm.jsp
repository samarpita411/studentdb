<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<body>
	<div class="border">
		<form action="./create" method="post">
			<table width="800">
				<tr>
					<td>
						<fieldset>
							<legend>
								<B>Student Basic Info ...</B>
							</legend>
							<table width="500">
								<tr>
									<td>Regno</td>
									<td><input type="number" name="regno"
										placeholder="Enter regno" required="required" /></td>
								</tr>
								<tr>
									<td>First Name</td>
									<td><input type="text" name="firstname"
										placeholder="Enter first name" required="required" /></td>
								</tr>
								<tr>
									<td>Middle Name</td>
									<td><input type="text" name="middlename"
										placeholder="Enter Middle name" required="required" /></td>
								</tr>
								<tr>
									<td>Last Name</td>
									<td><input type="text" name="lastname"
										placeholder="Enter last name" required="required" /></td>
								</tr>
							</table>
						</fieldset>
					</td>
				</tr>
				<tr>
					<td>
						<fieldset>
							<legend>
								<B>Student Address Info ...</B>
							</legend>
							<table width="500">
								<tr>
									<td>Address Type</td>

									<td><select name="addtype"><option
												value="Present">present</option>
											<option value="Permanent">permanent</option></select></td>

								</tr>
								<tr>
									<td>Address1</td>
									<td><input type="text" name="address1"
										placeholder="Enter Address1" required="required" /></td>
								</tr>
								<tr>
									<td>Address2</td>
									<td><input type="text" name="address2"
										placeholder="Enter Address2" required="required" /></td>
								</tr>

								<tr>
									<td>city</td>
									<td><input type="text" name="city"
										placeholder="Enter city " required="required" /></td>
								</tr>
								<tr>
									<td>pin code</td>
									<td><input type="number" name="pincode"
										placeholder="Enter pincode " required="required" /></td>
								</tr>
							</table>
						</fieldset>
					</td>
				</tr>
				<tr>
					<td>
						<fieldset>
							<legend>
								<B>Guardian Info ...</B>
							</legend>
							<table width="500">
								<tr>
									<td>guardian First Name</td>
									<td><input type="text" name="guardian_firstname"
										placeholder="Enter first name" required="required" /></td>
								</tr>
								<tr>
									<td>Guardian Middle Name</td>
									<td><input type="text" name="guardian_middlename"
										placeholder="Enter Middle name" required="required" /></td>
								</tr>
								<tr>
									<td>Guardian Last Name</td>
									<td><input type="text" name="guardian_lastname"
										placeholder="Enter last name" required="required" /></td>
								</tr>
<!-- 								<tr> -->
<!-- 									<td><input type="radio" name="gender" value="M"></td> -->
<!-- 									<td><input type="radio" name="gender" value="F"></td> -->
<!-- 								</tr> -->
							</table>
						</fieldset>
					</td>
				</tr>
			</table>
			<BR> <BR>
			<input type="submit" value="Reset" />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit"
				value="Create Profile" />

		</form>
	</div>
</body>
</html>
