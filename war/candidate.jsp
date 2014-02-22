<!DOCTYPE html>
<html>
<head>

<%@ page import="com.teambingo.recruting_platform.database.Person"%>
<%@ page import="com.teambingo.recruting_platform.database.PersonManager"%>
<%@ page import="java.util.Set" %>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Recruiting Platform</title>

<link rel="stylesheet" href="/css/bootstrap.css">
<link rel="stylesheet" href="/css/bootstrap-theme.css">
<link rel="stylesheet" href="/css/styles.css">

</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Recruiting Platform</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#candidates">Candidates</a></li>
					<li><a href="#events">Events</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>

	<div class="container"></div>
	<!-- /.container -->
	<div class="table-content candidate-table">
		<p>
			<button class="btn btn-large btn-primary new-candidate"
				data-toggle="modal" data-target="#newCandidateModal" type="button">New
				Candidate</button>
		</p>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>University</th>
					<th>Major</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody>
				<%
					Set<Person> candidatePeople = Person.createPeople(PersonManager
							.getPeople());
					for (Person p : candidatePeople) {
				%>
				<tr>
					<td><span class="candidate-id"><%=p.getKey().getId()%></span></td>
					<td>John Doe</td>
					<td>Purdue University</td>
					<td>Computer Science</td>
					<td>offer pending</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="newCandidateModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Add New Candidate</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<label for="inputName" class="col-sm-2 control-label">Name</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" id="inputName"
									placeholder="">
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail" class="col-sm-2 control-label">Email</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" id="inputEmail"
									placeholder="">
							</div>
						</div>
						<div class="form-group">
							<label for="inputUniversity" class="col-sm-2 control-label">University</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" id="inputUniversity"
									placeholder="">
							</div>
						</div>
						<div class="form-group">
							<label for="inputMajor" class="col-sm-2 control-label">Major</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" id="inputMajor"
									placeholder="">
							</div>
						</div>
						<div class="form-group">
							<label for="inputGPA" class="col-sm-2 control-label">GPA</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" id="inputGPA"
									placeholder="">
							</div>
						</div>
						<div class="form-group">
							<label for="inputBackground" class="col-sm-2 control-label">Background</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" id="inputBackground"
									placeholder="">
							</div>
						</div>
						<div class="form-group">
							<label for="inputInterests" class="col-sm-2 control-label">Interests</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" id="inputInterests"
									placeholder="">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Add</button>
				</div>
			</div>
		</div>
	</div>

	<script src="/js/jquery-1.11.0.js"></script>
	<script src="/js/bootstrap.js"></script>
	<script src="/js/loaded.js"></script>
</body>
</html>