
		function success(pos){
			
		var crd = pos.coords;
	 
			document.getElementById("lat").setAttribute("value",crd.latitude);
			document.getElementById("lnt").setAttribute("value",crd.longitude);
		}
		function error(){
		alert("ERROR");
		}
		
	
		document.getElementById("loc").addEventListener("click", ()=>{
			 navigator.geolocation.getCurrentPosition(success, error);
		});
	
	//-----------------------------------------------------------------------------	
	
		function getposition(){
			
		let lat = document.getElementById("lat").value;
		let lnt = document.getElementById("lnt").value;
			
		console.log(lat)
		
			$.ajax({
				type: "post",
				url: "Get_Position",
				data:{
					"myLat": lat,
					"myLnt": lnt
				},
				async: false
			}) 
			
		}
		
	
		document.getElementById("near").addEventListener("submit",()=>{
			getposition()
		});
		
		


function getPositionSelect(){
setTimeout(()=>{console.log("db update가 웹에 바로 안되서 0.1초 기다림")},100)
}


document.getElementById("nearSelect").addEventListener("click",()=>{
	getPositionSelect();
});	
