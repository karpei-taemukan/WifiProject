<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="com.google.gson.stream.JsonReader"%>
<%@page import="sqlite.DB_Insert_openApi"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.google.gson.reflect.TypeToken"%>
<%@page import="java.util.Arrays"%>
<%@page import="Wifi.Wifi_Info"%>
<%@page import="com.fasterxml.jackson.core.type.TypeReference"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.List"%>
<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.JsonParser"%>
<%@page import="java.text.ParseException"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="Api.GetOpenApi" %>
<%@page import="Wifi.Wifi_Info" %>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>와이파이 정보 구하기</title>
</head>
<body>
<%
Wifi_Info wi = new Wifi_Info();				   
int cnt = 0;
Gson gson = new Gson();
DB_Insert_openApi db_insert = new DB_Insert_openApi();


List<Map<String,String>> list = null;
//System.out.println(jsonStr);
for(int i=0; i<24; i++){

	int startIdx = 1 + i*1000;
	int endIdx = 1000 + i*1000;
	cnt=endIdx;
String jsonStr = GetOpenApi.getApi(String.valueOf(startIdx), String.valueOf(endIdx));

	 JsonParser parser = new JsonParser();
	 JsonElement element = parser.parse(jsonStr);
	 JsonObject obj = element
			 .getAsJsonObject()
			 .get("TbPublicWifiInfo")
			 .getAsJsonObject()
			 ;
	 
	JsonArray jsonArray = obj.getAsJsonObject().get("row").getAsJsonArray();

	//System.out.println(jsonArray);
	
	list = gson.fromJson(jsonArray.toString(), new TypeToken<ArrayList<HashMap<String,String>>>(){}.getType());
	  				   
  	db_insert.insert(list);
}
   /*  for(int i=0; i<list.size(); i++){
    cnt++;
    } */

  cnt += list.size();
%>
<h1 style="text-align: center">데이터베이스에 <%= cnt %>개 업데이트 완료</h1>
<div style="text-align: center"><a href="/wifi-project/index.jsp">홈으로 이동</a></div>
</body>
</html>