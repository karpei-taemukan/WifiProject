<%@page import="java.util.List"%>
<%@page import="sqlite.DB_Select_openApi"%>
<%@page import="Wifi.Wifi_History"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�������� ���� ���ϱ�</title>
<style>
.table-list {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

.table-list td, .table-list th {
	border: 1px solid #ddd;
	padding: 8px;
}

.table-list tr:nth-child(even) {
	background-color: #f2f2f2;
}


.table-list th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: center;
	background-color: #04AA6D;
	color: white;
}

.table-list tr:hover {
	background-color: #ddd;
}

</style>
</head>
<body>
<h1>��ġ �����丮 ���</h1>
		<div>
		<a href="/wifi-project/index.jsp">Ȩ</a>
		|
		<a href="/wifi-project/wifi-history.jsp">��ġ �����丮 ���</a>
		|
		<a href="/wifi-project/load-wifi.jsp">open api �������� ���� ��������</a>
		</div>
<%
	DB_Select_openApi dbsel = new DB_Select_openApi();
	List<Wifi_History> wifiList = dbsel.select_history();
%>

<table class="table-list">

<thead>
<tr>
			<th>ID</th>
			<th>X��ǥ</th>
			<th>Y��ǥ</th>
			<th>��ȸ����</th>
			<th>���</th>
	</tr>

</thead>


<tbody>
	<%
	for(Wifi_History wh : wifiList)
	{
	%>	
	
	<tr>
	<td id="idx"><%=wh.getX_SWIFI_ID() %></td>
	<td><%=wh.getLAT() %></td>
	<td><%=wh.getLNT() %></td>
	<td><%=wh.getWORK_DTTM() %></td>
	<td>
	<form action="/wifi-project/wifi-history.jsp" method="post">
	<input id="del" type="submit" value="����">
	</form>
	</td>
	</tr>
	<%} %>
</tbody>

</table>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>

<script>

function delRequest(idx){
	$.ajax({
		type: "post",
		url: "deleteHistory",
		data:{
			"idx": idx
		},
		dataType: "json",
		success:function(data){
			console.log(data)
		},
			error:function(request, status, error){
	console.log("code:"+request.status
	+"\n"+"message:"+request.responseText+
	"\n"+"error:"+error);
	}
	}) 
}
$(document).on("click","#del",function(e){ 
	//console.log(e)
	console.log(e.target.parentElement.parentElement.children[0].innerText)

	let idx = e.target.parentElement.parentElement
	
	.parentElement.children[0].innerText;

	delRequest(idx);
}
)
</script>
</html>