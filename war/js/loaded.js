(function() {
	$(function() {
		
		$("div.candidate-table table tr").click(function() {
			var candidateId = $(this).find(".candidate-id").html();
			openCandidateInfo(candidateId);
		});
		
		$("div.candidate-table button.new-candidate").click(function() {
			
		});
		
	});
	
	var openCandidateInfo = function(id) {
		console.log("candidate id", id);
		$("#newCandidateModal").modal().show();
	};
})();