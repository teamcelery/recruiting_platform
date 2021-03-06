(function() {
	$(function() {

		$("div.candidate-table table tr").click(function() {
			var candidateId = $(this).find(".candidate-id").html();

			if (candidateId) {
				openCandidateInfo(candidateId);
			}
		});

		$("div.candidate-table button.new-candidate").click(function() {

		});

		$("#add-candidate-button").click(function() {
			var name = $("#inputName").val();
			var email = $("#inputEmail").val();
			var address = $("#inputAddress").val();
			var u = $("#inputUniversity").val();
			var major = $("#inputMajor").val();
			var gpa = $("#inputGPA").val();
			var back = $("#inputBackground").val();
			var interests = $("#inputInterests").val();

			var data = {
				"action": "setcandidate",
				"name" : name,
				"address": address,
				"email" : email,
				"university" : u,
				"major" : major,
				"gpa" : gpa,
				"background" : back,
				"interests" : interests,
				"status" : ""
			};

			$.ajax({
				type : "POST",
				url : "/rp",
				data : data,
				success : function(data) {
				},
				dataType : "json"
			});
			
			$("#newCandidateModal").modal('hide');
			
			location.reload();

			// console.log(name);
		});
		
		$("#add-event-button").click(function() {
			var name = $("#inputName").val();

			console.log("event name", name);
			var data = {
				"action": "setevent",
				"name" : name
			};

			$.ajax({
				type : "POST",
				url : "/rp",
				data : data,
				success : function(data) {
				},
				dataType : "json"
			});
			
			$("#newEventModal").modal('hide');
			
			location.reload();

			// console.log(name);
		});

	});

	var openCandidateInfo = function(id) {
		console.log("candidate id", id);
		
		$.ajax({
			type: "GET",
			url: "/rp",
			data: "action=getcandidate&id=" + id,
//			data: "action=getcandidate&id=-1",
			success: function(data) {
				console.log(data);
			}
		});

//		$.getJSON("/rp?action=getcandidate&id=" + id, function(data) {
//			function() {
//				var name = $("#inputName").val();
//				var email = $("#inputEmail").val();
//				var address = $("#inputAddress").val();
//				var u = $("#inputUniversity").val();
//				var major = $("#inputMajor").val();
//				var gpa = $("#inputGPA").val();
//				var back = $("#inputBackground").val();
//				var interests = $("#inputInterests").val();
//
//				var data = {
//					"action": "setcandidate",
//					"name" : name,
//					"address": address,
//					"email" : email,
//					"university" : u,
//					"major" : major,
//					"gpa" : gpa,
//					"background" : back,
//					"interests" : interests,
//					"status" : ""
//				};
//
//				$.ajax({
//					type : "POST",
//					url : "/rp",
//					data : data,
//					success : function(data) {
//					},
//					dataType : "json"
//				});
//				
//				$("#newCandidateModal").modal('hide');
//				
//				location.reload();
//
//				// console.log(name);
//			}
//		});

		$("#newCandidateModal").modal().show();
	};
})();