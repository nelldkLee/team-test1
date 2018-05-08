<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../includes/header.jsp"%>
<!-- Table -->

	<div class="row uniform">
	<form method="post">
		<div class="8u 12u$(xsmall)">
			<h3>Title</h3>
			<input type="text" name="title" id="demo-name" value=""
				placeholder="Title" />
		</div>
		<div class="4u 12u$(xsmall)">
			<h3>Writer</h3>
			<input type="text" name="writer" id="demo-email" placeholder="Writer" />
		</div>
		<div class="12u$">
			<h3>Content</h3>
			<textarea name="content" id="demo-message"
				placeholder="Enter your message" rows="10"></textarea>
		</div>
		<!-- Break -->
		<div class="12u$">
			<ul class="actions">
				<li><input type="submit" value="Register" class="special" /></li>
				<li><a class="button" href="/board/list">List</a></li>
			</ul>
		</div>
	</div>
</form>
</div>
<%@ include file="../includes/footer.jsp"%>
