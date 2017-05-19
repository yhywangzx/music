$(function() {
	$(".page").click(pageClick);
});

function pageClick() {
	var id = $(this).attr("id");
	var pageIndex = parseInt($("#pageIndex").val());
	var totalPage = parseInt($("#totalPage").val());

	if (id == "first") {
		$("#pageIndex").val(1);
		$("form").submit();
	} else if (id == "previou") {
		if (pageIndex > 1) {
			$("#pageIndex").val(pageIndex - 1);
			$("form").submit();
		}
	} else if (id == "next") {
		if (pageIndex < totalPage) {
			$("#pageIndex").val(pageIndex + 1);
			$("form").submit();
		}
	} else if (id == "last") {
		$("#pageIndex").val(totalPage);
		$("form").submit();
	}
	return false;
}