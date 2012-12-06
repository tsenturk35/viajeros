<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="menu">
	<div class="container">
		<ul>
		
			<li class="menu-allround"><a href="/">Home</a></li>
			<li class="menu-allround"><a href="Report">Reports</a></li>
			<li class="menu-topround"><a href="#">Test Service</a>
				
				<div class="dropdown" id="java-menu">
					<div class="tut-title">Test Following Services</div>
					<div class="dropdown-item">
						<a href="/tag/java/"><div class="images img-border img-java img-holder"></div> </a>
						<div>1. <s:a action="getTags" >Users By Tag</s:a></div>
						<div></div>
						<div>2. <a href="#">FBEntities by Tags</a></div>
						<div></div>
						<div>3. <a href="#">Tags By Tag</a></div>
						

					</div>
				</div>
			</li>
			<li class="menu-allround"><a href="Services.do">Services Setting</a></li>
		</ul>
	</div>
</div>