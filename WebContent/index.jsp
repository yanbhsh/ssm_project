<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<script src="js/jquery.min.js"></script>
		<style type="text/css">
			body {
				font: 12px "宋体", Arial, Helvetica, sans-serif;
				color: #756F71;
				font-family: Tahoma, Geneva, '\5fae\8f6f\96c5\9ed1', '\2B8B\4F53';
				background-image: url(http://yanbhsh.com/image/indexbg.gif);
			}
		</style>
	</head>
	<body>
		<!--[if !IE]><!-->  
  			<canvas id="canvas" style="position: fixed; left: 0px; top: 0px; pointer-events: none; " width="1920" height="940">
				Canvas is not supported in your browser.
			</canvas>
	
			<script src="js/firework.js"></script>
		<!--<![endif]-->

		<form action="/ssm_project/a/stuinfo.htm" method="post">
	
			<p>
				<label for="stuId">stuId</label> <input id="stuId" name="stuId"
					type="text" />
			</p>
	
			<input type="submit" value="根据ID查询实体" />
	
		</form>

		<script type="text/javascript" src="js/jquery.min.js" ></script>
		<script type="text/javascript" src="js/jquery.cookie.js" ></script>
		<script>
			
			function saveCookie() {
				var expiresDate = new Date();
				expiresDate.setTime(expiresDate.getTime() + (30 * 60 * 1000));// cookie超时时间设为30分钟
				var name = 'useName';
				var value='zhangsan';
				$.cookie(name, value, {
					expires : expiresDate.toGMTString()
				});
			}
			saveCookie();
			var useName = $.cookie("useName");
			alert(useName);
			
		</script>
</body>
</html>
