/**
 * 
 */

$(document).ready(function() {
	$('.delete-ringSimpleReady').on('click', function() {
		/* <![CDATA[ */
		var path = /* [[@{/}]] */'removeRingSimpleReady';
		/* ]]> */

		var id = $(this).attr('id');

		bootbox.confirm({
			message : "Voulez - vous supprimer ?",
			buttons : {
				cancel : {
					label : '<i class="fa fa-times"></i> Annuler'
				},
				confirm : {
					label : '<i class="fa fa-check"></i> Confirmer'
				}
			},
			callback : function(confirmed) {
				if (confirmed) {
					$.post(path, {
						'id' : id
					}, function(res) {
						location.reload();
					});
				}
			}
		});
	});

	$('#deleteSelectedRingSimpleReady').click(function() {
		var idList = $('.checkboxRingSimpleReady');
		var ringSimpleReadyIdList = [];
		for (var i = 0; i < idList.length; i++) {
			if (idList[i].checked == true) {
				ringSimpleReadyIdList.push(idList[i]['id'])
			}
		}

		console.log(ringSimpleReadyIdList);

		/* <![CDATA[ */
		var path = /* [[@{/}]] */'removeRingSimpleReadyList';
		/* ]]> */

		bootbox.confirm({
			message : "Voulez - vous supprimer ?",
			buttons : {
				cancel : {
					label : '<i class="fa fa-times"></i> Cancel'
				},
				confirm : {
					label : '<i class="fa fa-check"></i> Confirm'
				}
			},
			callback : function(confirmed) {
				if (confirmed) {
					$.ajax({
						type : 'POST',
						url : path,
						data : JSON.stringify(ringSimpleReadyIdList),
						contentType : "application/json",
						success : function(res) {
							console.log(res);
							location.reload()
						},
						error : function(res) {
							console.log(res);
							location.reload();
						}
					});
				}
			}
		});
	});

	$("#selectAllRingSimpleReady").click(function() {
		if ($(this).prop("checked") == true) {
			$(".checkboxRingSimpleReady").prop("checked", true);
		} else if ($(this).prop("checked") == false) {
			$(".checkboxRingSimpleReady").prop("checked", false);
		}
	})
});

$(document).ready(function() {
	$('.delete-allianceReady').on('click', function() {
		/* <![CDATA[ */
		var path = /* [[@{/}]] */'removeAllianceReady';
		/* ]]> */

		var id = $(this).attr('id');

		bootbox.confirm({
			message : "Voulez - vous supprimer ?",
			buttons : {
				cancel : {
					label : '<i class="fa fa-times"></i> Annuler'
				},
				confirm : {
					label : '<i class="fa fa-check"></i> Confirmer'
				}
			},
			callback : function(confirmed) {
				if (confirmed) {
					$.post(path, {
						'id' : id
					}, function(res) {
						location.reload();
					});
				}
			}
		});
	});

	$('#deleteSelectedAllianceReady').click(function() {
		var idList = $('.checkboxAllianceReady');
		var allianceReadyIdList = [];
		for (var i = 0; i < idList.length; i++) {
			if (idList[i].checked == true) {
				allianceReadyIdList.push(idList[i]['id'])
			}
		}

		console.log(allianceReadyIdList);

		/* <![CDATA[ */
		var path = /* [[@{/}]] */'removeAllianceReadyList';
		/* ]]> */

		bootbox.confirm({
			message : "Voulez - vous supprimer ?",
			buttons : {
				cancel : {
					label : '<i class="fa fa-times"></i> Cancel'
				},
				confirm : {
					label : '<i class="fa fa-check"></i> Confirm'
				}
			},
			callback : function(confirmed) {
				if (confirmed) {
					$.ajax({
						type : 'POST',
						url : path,
						data : JSON.stringify(allianceReadyIdList),
						contentType : "application/json",
						success : function(res) {
							console.log(res);
							location.reload()
						},
						error : function(res) {
							console.log(res);
							location.reload();
						}
					});
				}
			}
		});
	});

	$("#selectAllAllianceReady").click(function() {
		if ($(this).prop("checked") == true) {
			$(".checkboxAllianceReady").prop("checked", true);
		} else if ($(this).prop("checked") == false) {
			$(".checkboxAllianceReady").prop("checked", false);
		}
	})
});

$(document).ready(function() {
	$('.delete-earringsReady').on('click', function() {
		/* <![CDATA[ */
		var path = /* [[@{/}]] */'removeEarringsReady';
		/* ]]> */

		var id = $(this).attr('id');

		bootbox.confirm({
			message : "Voulez - vous supprimer ?",
			buttons : {
				cancel : {
					label : '<i class="fa fa-times"></i> Annuler'
				},
				confirm : {
					label : '<i class="fa fa-check"></i> Confirmer'
				}
			},
			callback : function(confirmed) {
				if (confirmed) {
					$.post(path, {
						'id' : id
					}, function(res) {
						location.reload();
					});
				}
			}
		});
	});

	$('#deleteSelectedEarringsReady').click(function() {
		var idList = $('.checkboxEarringsReady');
		var earringsReadyIdList = [];
		for (var i = 0; i < idList.length; i++) {
			if (idList[i].checked == true) {
				earringsReadyIdList.push(idList[i]['id'])
			}
		}

		console.log(earringsReadyIdList);

		/* <![CDATA[ */
		var path = /* [[@{/}]] */'removeEarringsReadyList';
		/* ]]> */

		bootbox.confirm({
			message : "Voulez - vous supprimer ?",
			buttons : {
				cancel : {
					label : '<i class="fa fa-times"></i> Cancel'
				},
				confirm : {
					label : '<i class="fa fa-check"></i> Confirm'
				}
			},
			callback : function(confirmed) {
				if (confirmed) {
					$.ajax({
						type : 'POST',
						url : path,
						data : JSON.stringify(earringsReadyIdList),
						contentType : "application/json",
						success : function(res) {
							console.log(res);
							location.reload()
						},
						error : function(res) {
							console.log(res);
							location.reload();
						}
					});
				}
			}
		});
	});

	$("#selectAllEarringsReady").click(function() {
		if ($(this).prop("checked") == true) {
			$(".checkboxEarringsReady").prop("checked", true);
		} else if ($(this).prop("checked") == false) {
			$(".checkboxEarringsReady").prop("checked", false);
		}
	})
});

$(document).ready(function() {
	$('.delete-necklaceReady').on('click', function() {
		/* <![CDATA[ */
		var path = /* [[@{/}]] */'removeNecklaceReady';
		/* ]]> */

		var id = $(this).attr('id');

		bootbox.confirm({
			message : "Voulez - vous supprimer ?",
			buttons : {
				cancel : {
					label : '<i class="fa fa-times"></i> Annuler'
				},
				confirm : {
					label : '<i class="fa fa-check"></i> Confirmer'
				}
			},
			callback : function(confirmed) {
				if (confirmed) {
					$.post(path, {
						'id' : id
					}, function(res) {
						location.reload();
					});
				}
			}
		});
	});

	$('#deleteSelectedNecklaceReady').click(function() {
		var idList = $('.checkboxNecklaceReady');
		var necklaceReadyIdList = [];
		for (var i = 0; i < idList.length; i++) {
			if (idList[i].checked == true) {
				necklaceReadyIdList.push(idList[i]['id'])
			}
		}

		console.log(necklaceReadyIdList);

		/* <![CDATA[ */
		var path = /* [[@{/}]] */'removeNecklaceReadyList';
		/* ]]> */

		bootbox.confirm({
			message : "Voulez - vous supprimer ?",
			buttons : {
				cancel : {
					label : '<i class="fa fa-times"></i> Cancel'
				},
				confirm : {
					label : '<i class="fa fa-check"></i> Confirm'
				}
			},
			callback : function(confirmed) {
				if (confirmed) {
					$.ajax({
						type : 'POST',
						url : path,
						data : JSON.stringify(necklaceReadyIdList),
						contentType : "application/json",
						success : function(res) {
							console.log(res);
							location.reload()
						},
						error : function(res) {
							console.log(res);
							location.reload();
						}
					});
				}
			}
		});
	});

	$("#selectAllNecklaceReady").click(function() {
		if ($(this).prop("checked") == true) {
			$(".checkboxNecklaceReady").prop("checked", true);
		} else if ($(this).prop("checked") == false) {
			$(".checkboxNecklaceReady").prop("checked", false);
		}
	})
});
