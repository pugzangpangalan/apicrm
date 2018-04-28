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
	            "dom": '<"top"<"marg-left col-sm-7"><"col-sm-3 text-right"B>f>rt<"bottom"ilp><"clear">',
            	"buttons": [
            		
                    {
                   	 text:'Import Campaign',
                   	 className: 'btn btn-info',
                   	 action:  function ( e) {
                   		e.preventDefault();
        		        $('#importModalId').modal('show');
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
		
		
		function  doUpload(){
			alert($('#fileUpload').val());
			alert('do upload code here');
			$('#importModalId').modal('hide');
		}
		
		$('#fileUpload').change(function(){
			var pieces = $('#fileUpload').val().split(/[/\\/]+/);

			$('#fileDivId').empty();
			$('#fileDivId').append('<span id="fileNameId">'+pieces[pieces.length-1]+'</span>');
			$('#fileDivId').append('<a id="removeFileId" href="javascript:clearFileDiv();"> <span class="glyphicon glyphicon-trash"></span></a>');
		});
		
		function clearFileDiv(){
			$('#fileUpload').val('');
			$('#fileDivId').empty();
		}
		

