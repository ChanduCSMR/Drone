function initiateDelivery(id) {
	$.post("http://10.80.106.67:8093/DemoDroneServer/service/initiateShipment", {
		productID : id
	}, function(data, status) {
		$("#myModal").modal("show");
		if(data==""){
			$("#modaldata").html("<p>Currently there is no Drones available for shipping, please try again </p>");
			$("#modalbutton").html('<button type="button" class="btn btn-default" data-dismiss="modal">OK</button>')
		}if (status == "success") {
			$("#button" + id).text("Out For Delivery");
			$("#productstatus"+ id).text("Out For Delivery");
			$("#droneId"+data.id).text("Shipping");
			$("#modaldata").html("<p>Product Taken by <b>Drone</b> </p><br/><b>Drone Name: </b>"
							+ data.droneName + "<br/><b>Drone Version: </b>"
							+ data.versionNumber + "<br/></b>");
			$("#modalbutton").html('<button type="button" class="btn btn-default" onclick="proceedDelivery('
							+ id + ',' + data.id
							+ ')" >Proceed</button>');
		}
	});
}

function proceedDelivery(productId, droneId) {
	$.post("http://10.80.106.67:8093/DemoDroneServer/service/proceedDelivery",{
		droneID : droneId
	},function(data, status) {
		if (status == "success") {
			$("#modaldata").html("<p>Drone reached the delivery location ready for unload </p><br/>");
			$("#modalbutton").html('<button type="button" class="btn btn-default" onclick="unloadProduct('
							  + productId+ ','
							  + droneId	+ ')" >Unload</button>');
		}
	});
}
function unloadProduct(productId, droneId) {
	$.post("http://10.80.106.67:8093/DemoDroneServer/service/unloadProduct",
	{
		droneID : droneId,
		productID : productId
	},
	function(data, status) {
		if (status == "success") {
			$("#button" + productId).text("Delivered");
			$("#modaldata").html("<p>Product deliver Successfully and Drone back to parking spot.. and Ready for next shipment </p><br/>");
			$("#modalbutton").html('<button type="button" class="btn btn-default" onclick="unloadProduct('
							  + productId+ ','
							  + droneId+ ')" data-dismiss="modal">Done</button>')
		}
	});
}

$("#myModal").on("hidden.bs.modal", function () {
	location.reload();
});