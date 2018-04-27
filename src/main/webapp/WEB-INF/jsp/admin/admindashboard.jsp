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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/table.css">
<link rel="stylesheet" href="/css/main.css">
</head>
<jsp:include page="../common/headermenu.jsp"></jsp:include>
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
					<c:forEach items="${campaign }" var="tlc">
						<tr>
							<td class="td-data" id="tlcId${tlc.id}">${tlc.tlcId }</td>
							<td class="td-data" contenteditable="true" id="address${tlc.id}">${tlc.address }</td>
							<td class="td-data" contenteditable="true" id="customerName${tlc.id}">${tlc.customerName }</td>
							<td class="td-data" contenteditable="true" id="contactNumber${tlc.id}">${tlc.contactNumber }</td>
							<td class="td-data" contenteditable="true" id="siteAccessInfo${tlc.id}">${tlc.siteAccessInfo }</td>
							<td class="td-data" contenteditable="true" id="installationDate${tlc.id}">${tlc.formattedInstallationDate }</td>
							<td class="td-data" contenteditable="true" id="installationTime${tlc.id}">${tlc.time }</td>
							<td class="td-data" contenteditable="true" id="scopeDocSent${tlc.id}">${tlc.scopeDocSent }</td>
							<td class="td-data" contenteditable="true" id="tlcProject${tlc.id}">${tlc.campaign.projectName }</td>
							<td class="td-data" contenteditable="true" id="chorusPortalOrder${tlc.id}">${tlc.chorusPortalOrder }</td>
							<td class="td-data" contenteditable="true" id="icmsServiceOrder${tlc.id}">${tlc.icmsServiceOrder }</td>
							<td class="td-data" contenteditable="true" id="team${tlc.id}">${tlc.team.teamName }</td>
							<td class="td-data" contenteditable="true" id="status${tlc.id}">${tlc.status.statusName }</td>
							<td class="td-data" contenteditable="true" id="siteVisitOutcome${tlc.id}">${tlc.siteVisitOutcome }</td>
							<td class="td-data" contenteditable="true" id="comments${tlc.id}">${tlc.comments }</td>
							<td class="td-data" contenteditable="true" id="scheduleOnce${tlc.id}">${tlc.scheduleOnce }</td>
							<td class="td-data" contenteditable="true" id="scopingDocCount${tlc.id}">${tlc.scopingDocCount }</td>
							<td class="td-data" contenteditable="true" id="appointmentDate${tlc.id}">${tlc.formattedAppointmentDate }</td>
							
							<td><a href="#" id="updateId" onclick="update('${tlc.id}')">Update</a></td>
						</tr>
					</c:forEach>
	
					</tbody>
				</table>
			
			</form:form>
		</div>
		<button value="LEFT" id="left" ><i class="fa fa-angle-left" style="font-size:60px;"></i></button>
		<button value="RIGHT" id="right" ><i class="fa fa-angle-right" style="font-size:60px;"></i></button>
		<input type="file" id="fileUploadId" style="display:none;">
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
	            "dom": '<"top"<"marg-left col-sm-8"><"col-sm-2 text-right"B>f>rt<"bottom"ilp><"clear">',
            	"buttons": [
            		
                    {
                   	 text:'Import',
                   	 className: 'btn btn-info',
                   	 action:  function ( e) {
                   		e.preventDefault();
                        $("#fileUploadId").trigger('click');
                     }
                    },
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
		
		$('#left').hover(function () {
			scrollLeft();
		});

		$('#right').hover(function () {
			scrollRight();
		});
		
		$('#left').click(function () {
			scrollLeft();
		});

		$('#right').click(function () {
			scrollRight();
		});
		
		function scrollRight(){
			var leftPos = $('div.dataTables_scrollBody').scrollLeft();
		    var rightX = $('div.dataTables_scrollBody').width();
		    $("div.dataTables_scrollBody").animate({
		        scrollLeft: rightX
		    }, 1000,hide($('#right'),$('#left')));
		}
		
		function scrollLeft(){
			var leftPos = $('div.dataTables_scrollBody').scrollLeft();
		    $("div.dataTables_scrollBody").animate({
		        scrollLeft: 0
		    }, 1000,hide($('#left'),$('#right')));
		}
		
		function hide(x,y){
			
			x.fadeOut(2000);
			y.fadeIn(2000);
		}
		
		jQuery("input#fileUploadId").change(function () {
		    if(jQuery(this).val() != null){
		    	
		    	
		    }
		    
		});
		

	</script>
</body>
</html>
