<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div id="menu">
	<div class="container">
		<ul>
		
			<li class="menu-allround"><a href="/">Home</a></li>
			<li class="menu-allround"><a href="#">Invoice</a></li>
			<li class="menu-topround"><a href="#">Administration</a>
				
				<div class="dropdown" id="java-menu">
					<div class="tut-title">Administration</div>
					<div class="dropdown-item">
						<a href="#"><div class="images img-border img-java img-holder"></div> </a>
						<div>1.<s:action name="getTransportationRateList">Transportation Rates</s:action></div>
						<div></div>
						<div>2. <a href="#">Holding Rates</a></div>
						<div></div>
						<div>3. <a href="#">Vehicle Types</a></div>
						<div></div>
						<div>3. <s:a action="destinationList" >Destinations</s:a></div>
					</div>
				</div>
			</li>
			<li class="menu-allround"><a href="#">My Profile</a></li>
		</ul>
	</div>
</div>