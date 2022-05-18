<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<h1>tour입력폼</h1>
	<form action="<%=request.getContextPath()%>/InsertTourController"  method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td>
					도 
				</td>
				<td>
					 <select  name="province" >
 						 <option value="choongchung" >충청도</option>
 						 <option value="jeonla" > 전라도</option>
  						<option value="kyunggi" > 경기도</option>
  						<option value="kangwon"> 강원도</option>
  						 <option value="seoul" > 서울</option>
  						<option value="jeju" >제주도</option>
  						<option value="kyungsang">경상도</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					도시
				</td>
				<td>
					<input type="text" name="tourCity">
				</td>
			</tr>
			<tr>
				<td>
					관광명
				</td>
				<td>
					<input type="text" name="tourName">
				</td>
			</tr>
			<tr>
				<td>
					관광설명
				</td>
				<td>
					<textarea name="tourName" rows="2" cols="60"></textarea>
				</td>
			</tr>
			
		<!-- 	<tr>
				<td>
					이미지이름:
				</td>
				<td>
					<input type="text" name="tourImageName">
				</td>
			</tr> -->
			<tr>
				<td>이미지파일</td>
				<td><input type="file" name="tourImage" ></td>
			</tr>
		</table>
		<button type="submit">관광 등록</button>
	</form>
</body>
</html>