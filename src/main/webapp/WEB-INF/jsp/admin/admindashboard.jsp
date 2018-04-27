<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/buttons/1.5.1/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/buttons/1.5.1/js/buttons.flash.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/pdfmake.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/vfs_fonts.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/buttons/1.5.1/js/buttons.html5.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/buttons/1.5.1/js/buttons.print.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/table.css">
</head>
<body>
	<div class="container">
		<h1>List of all Campaign</h1>

		<c:if test="${not empty msgDetails}">
			<div class="${msgCss }">
			    ${msgDetails }
			</div>
		</c:if>
		<div id="table1" class="table-editable">
			<form:form>  
				<table class="table" id="anxtable" >
			<thead>  
					<tr>
						<th class="noaction">TLC Id</th>
						<th class="noaction">Location / Address</th>
						<th class="noaction">Customer Name</th>
						<th class="noaction">Contact Number</th>
						<th class="noaction">Site Access Information</th>
						<th class="noaction">Installation Date</th>
						<th class="noaction">Installation Time</th>
						<th class="noaction">Scope Document Sent</th>
						<th class="noaction">Project Name</th>
						<th class="noaction">Chorus Portal Order</th>
						<th class="noaction">ICMS Service Order</th>
						<th class="noaction">Door-knock Team</th>
						<th class="noaction">Status</th>
						<th class="noaction">Site Visit Outcome</th>
						<th class="noaction">Additional Comments</th>
						<th class="noaction">Schedule Once</th>
						<th class="noaction">Scoping Document</th>
						<th class="noaction">Door-knock Appointment Date</th>
						<th class="action"></th>
						
					</tr>
					</thead>
					<tbody>
					<c:forEach items="${campaignList }" var="campaign">
						<tr>
							<td class="td-data" id="tlcId${campaign.id}">${campaign.tlcId }</td>
							<td class="td-data" contenteditable="true" id="address${campaign.id}">${campaign.address }</td>
							<td class="td-data" contenteditable="true" id="customerName${campaign.id}">${campaign.customerName }</td>
							<td class="td-data" contenteditable="true" id="contactNumber${campaign.id}">${campaign.contactNumber }</td>
							<td class="td-data" contenteditable="true" id="siteAccessInfo${campaign.id}">${campaign.siteAccessInfo }</td>
							<td class="td-data" contenteditable="true" id="installationDate${campaign.id}">${campaign.formattedInstallationDate }</td>
							<td class="td-data" contenteditable="true" id="installationTime${campaign.id}">${campaign.time }</td>
							<td class="td-data" contenteditable="true" id="scopeDocSent${campaign.id}">${campaign.scopeDocSent }</td>
							<td class="td-data" contenteditable="true" id="tlcProject${campaign.id}">${campaign.tlcProject.projectName }</td>
							<td class="td-data" contenteditable="true" id="chorusPortalOrder${campaign.id}">${campaign.chorusPortalOrder }</td>
							<td class="td-data" contenteditable="true" id="icmsServiceOrder${campaign.id}">${campaign.icmsServiceOrder }</td>
							<td class="td-data" contenteditable="true" id="team${campaign.id}">${campaign.team.teamName }</td>
							<td class="td-data" contenteditable="true" id="status${campaign.id}">${campaign.status.statusName }</td>
							<td class="td-data" contenteditable="true" id="siteVisitOutcome${campaign.id}">${campaign.siteVisitOutcome }</td>
							<td class="td-data" contenteditable="true" id="comments${campaign.id}">${campaign.comments }</td>
							<td class="td-data" contenteditable="true" id="scheduleOnce${campaign.id}">${campaign.scheduleOnce }</td>
							<td class="td-data" contenteditable="true" id="scopingDocCount${campaign.id}">${campaign.scopingDocCount }</td>
							<td class="td-data" contenteditable="true" id="appointmentDate${campaign.id}">${campaign.formattedAppointmentDate }</td>
							
							<td><a href="#" id="updateId" onclick="update('${campaign.id}')">Update</a></td>
						</tr>
					</c:forEach>
	
					</tbody>
				</table>
			
			</form:form>
		</div>

	</div>
	
	<script  type="text/javascript">
		function update(id) {
			var tlcId = $('#tlcId'+id).text();
			var address = $('#address'+id).text();
			var customerName = $('#customerName'+id).text();
			var contactNumber = $('#contactNumber'+id).text();
			var siteAccessInfo = $('#siteAccessInfo'+id).text();
			var installationDate = $('#installationDate'+id).text();
			var installationTime = $('#installationTime'+id).text();
			var scopeDocSent = $('#scopeDocSent'+id).text();
			var tlcProject = $('#tlcProject'+id).text();
			var chorusPortalOrder = $('#chorusPortalOrder'+id).text();
			var icmsServiceOrder = $('#icmsServiceOrder'+id).text();
			var team = $('#team'+id).text();
			var status = $('#status'+id).text();
			var siteVisitOutcome = $('#siteVisitOutcome'+id).text();
			var comments = $('#comments'+id).text();
			var scheduleOnce = $('#scheduleOnce'+id).text();
			var scopingDocCount = $('#scopingDocCount'+id).text();
			var appointmentDate = $('#appointmentDate'+id).text();
			
			location.href = "./updateCampaign?tlcId=" +tlcId 
					+ "&address=" +address
					+ "&customerName=" +customerName
					+ "&contactNumber=" +contactNumber
					+ "&siteAccessInfo=" +siteAccessInfo
					+ "&installationDate=" +installationDate
					+ "&installationTime=" +installationTime
					+ "&scopeDocSent=" +scopeDocSent
					+ "&tlcProject=" +tlcProject
					+ "&chorusPortalOrder=" +chorusPortalOrder
					+ "&icmsServiceOrder=" +icmsServiceOrder
					+ "&team=" +team
					+ "&status=" +status
					+ "&siteVisitOutcome=" +siteVisitOutcome
					+ "&comments=" +comments
					+ "&scheduleOnce=" +scheduleOnce
					+ "&scopingDocCount=" +scopingDocCount
					+ "&appointmentDate=" +appointmentDate;
		}
		
		$(document).ready(function() {
			$('#anxtable').DataTable({
	            "iDisplayLength": 10,
	            "aLengthMenu": [[10, 20, 50, -1], [10, 20, 50, "All"]],
	            "pagingType": "simple_numbers",
	            "language": {
	                searchPlaceholder: "Search",
	                search: "",
	                info:           "Showing _START_ to _END_ of _TOTAL_ -",
	                infoEmpty:      "Showing 0 to 0 of 0 entries",
	                paginate: {
	                    previous: "Prev"
	                 }

	            },
	            "dom": '<"top"<"marg-left col-sm-9"><"col-sm-1 text-right"B>f>rt<"bottom"ilp><"clear">',
            	"buttons": [
                     {
                    	 extend: 'csv',
                    	 filename: 'Campaign',
                    	 text: "Export CSV",
                    	 className: 'btn btn-success',
                    	 exportOptions: {
                             columns: '.noaction'
                         }
                     }
                ],
	            "scrollX": true
	        });
		});
	</script>
</body>
</html>
