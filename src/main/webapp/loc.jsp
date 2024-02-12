<%@page import="Wifi.Wifi_History"%>
<%@page import="Wifi.Wifi_Info"%>
<%@page import="java.util.List"%>
<%@page import="sqlite.DB_Select_openApi"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>와이파이 정보 구하기</title>
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


<%
DB_Select_openApi dbsel = new DB_Select_openApi();

%>

		<h1>와이파이 정보 구하기</h1>
		<div>
		<a href="/wifi-project/index.jsp">홈</a>
		|
		<a href="/wifi-project/wifi-history.jsp">위치 히스토리 목록</a>
		|
		<a href="/wifi-project/load-wifi.jsp">open api 와이파이 정보 가져오기</a>
		</div>

		
		<form action="/wifi-project/loc.jsp" method="get" id="near">
		LAT: <input type="text" id="lat" name="lat"/>
		LNT: <input type="text" id="lnt"  name="lnt"/>
		<input type="button" id="loc" value="내 위치 가져오기" />
		<input type="submit" value="근처의 wifi 정보 보기" id="nearSelect" />
		</form>
		
	<table class="table-list">
		<thead>
		<tr>
			<th>거리(KM)</th>
			<th>관리번호</th>
			<th>자치구</th>
			<th>와아피이명</th>
			<th>도로명주소</th>
			<th>상세주소</th>
			<th>상세위치(층)</th>
			<th>설치유형</th>
			<th>설치기관</th>
			<th>서비스구분</th>
			<th>설치년도</th>
			<th>실내외구분</th>
			<th>와이파이접속환경</th>
			<th>위도</th>
			<th>경도</th>
			<th>작업일자</th>
		</tr>
		</thead>
				

		<tbody>
		
		<%

List<Wifi_Info> wifiList = dbsel.select_near();
		for(Wifi_Info wi : wifiList)
		{
		%> 
		<tr>
		
			<td><%=wi.getDistance() %></td>
		
			<td><%=wi.getX_SWIFI_MGR_NO() %></td>
		
			<td><%=wi.getX_SWIFI_WRDOFC() %></td>
		
			<td><%=wi.getX_SWIFI_MAIN_NM() %></td>
			
			<td><%=wi.getX_SWIFI_ADRES1() %></td>
		
			<td><%=wi.getX_SWIFI_ADRES2() %></td>
		
			<td><%=wi.getX_SWIFI_INSTL_FLOOR() %></td>
		
			<td><%=wi.getX_SWIFI_INSTL_TY() %></td>
		
			<td><%=wi.getX_SWIFI_INSTL_MBY() %></td>
	
			<td><%=wi.getX_SWIFI_SVC_SE() %></td>
			
			<td><%=wi.getX_SWIFI_CNSTC_YEAR() %></td>
		
			<td><%=wi.getX_SWIFI_INOUT_DOOR() %></td>
		
			<td><%=wi.getX_SWIFI_CMCWR() %></td>
		
	
			<!-- <td> %=wi.getX_SWIFI_REMARS3() %></td>  -->
		
			<td><%=wi.getLAT() %></td>
		
			<td><%=wi.getLNT() %></td>
		
			<td><%=wi.getWORK_DTTM() %></td>
		</tr>
		<%}%>
		</tbody>
	</table>		
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>

<script src="js/position.js"></script>
</html>