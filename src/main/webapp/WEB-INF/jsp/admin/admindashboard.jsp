<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/gijgo@1.9.6/js/gijgo.js"
	type="text/javascript"></script>
<link href="https://cdn.jsdelivr.net/npm/gijgo@1.9.6/css/gijgo.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="/css/table.css">
</head>
<body>
	<div class="container">
		<h1>List of all Campaign</h1>

		<div id="table" class="table-editable">
			<span class="table-add glyphicon glyphicon-plus"></span>
			<form:form>
			
				<table class="table">
					<tr>
						<th>TLC Id</th>
						<th>Location / Address</th>
						<th>Customer Name</th>
						<th>Contact Number</th>
						<th>Site Access Information</th>
						<th>Installation Date</th>
						<th>Installation Time</th>
						<th>Scope Document Sent</th>
						<th>Project Name</th>
						<th>Chorus Portal Order</th>
						<th>ICMS Service Order</th>
						<th>Door-knock Team</th>
						<th>Status</th>
						<th>Site Visit Outcome</th>
						<th>Additional Comments</th>
						<th>Schedule Once</th>
						<th>Scoping Document</th>
						<th>Door-knock Appointment Date</th>
						<th></th>
						
					</tr>
					<c:forEach items="${campaignList }" var="campaign">
						<tr>
							<td contenteditable="true" id="tlcId${campaign.id}">${campaign.tlcId }</td>
							<td contenteditable="true" id="address${campaign.id}">${campaign.address }</td>
							<td contenteditable="true" id="customerName${campaign.id}">${campaign.customerName }</td>
							<td contenteditable="true" id="contactNumber${campaign.id}">${campaign.contactNumber }</td>
							<td contenteditable="true" id="siteAccessInfo${campaign.id}">${campaign.siteAccessInfo }</td>
							<td contenteditable="true" id="installationDate${campaign.id}">${campaign.date }</td>
							<td contenteditable="true" id="installationTime${campaign.id}">${campaign.time }</td>
							<td contenteditable="true" id="scopeDocSent${campaign.id}">${campaign.scopeDocSent }</td>
							<td contenteditable="true" id="chorusPortalOrder${campaign.id}">${campaign.chorusPortalOrder }</td>
							<td contenteditable="true" id="icmsServiceOrder${campaign.id}">${campaign.icmsServiceOrder }</td>
							<td contenteditable="true" id="team${campaign.id}">${campaign.team.teamName }</td>
							<td contenteditable="true" id="status${campaign.id}">${campaign.status.statusName }</td>
							<td contenteditable="true" id="siteVisitOutcome${campaign.id}">${campaign.siteVisitOutcome }</td>
							<td contenteditable="true" id="comments${campaign.id}">${campaign.comments }</td>
							<td contenteditable="true" id="scheduleOnce${campaign.id}">${campaign.scheduleOnce }</td>
							<td contenteditable="true" id="scopingDocCount${campaign.id}">${campaign.scopingDocCount }</td>
							<td contenteditable="true" id="appointmentDate${campaign.id}">${campaign.appointmentDate }</td>
							
							<td><a href="#" id="updateId" onclick="update('${campaign.id}')">Update</a></td>
						</tr>
					</c:forEach>
	
					<!-- This is our clonable table line -->
					<tr class="hide">
						<td contenteditable="true">Untitled</td>
						<td contenteditable="true">undefined</td>
					</tr>
				</table>
			
			</form:form>
		</div>

		<button id="export-btn" class="btn btn-primary">Export Data</button>
		<p id="export"></p>
	</div>
	
	<script>
		function update(id) {
			alert($('#tlcId'+id).text());
			var tlcId = $('#tlcId'+id).text();
			var address = $('#address'+id).text();
			alert("./updateCampaign?tlcId=" +tlcId + "&address=" +address);
			
			location.href = "./updateCampaign?tlcId=" +tlcId + "&address=" +address;
		}
	</script>
</body>
</html>
