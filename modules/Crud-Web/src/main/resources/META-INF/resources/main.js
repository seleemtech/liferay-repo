/*AUI().ready('aui-module', 'aui-base', 'aui-form-validator', function() {
	var A = AUI();

	(function restoreJQuery() {
		var jq = $;
		while ($ && $.fn.jquery != "2.1.4") {
			console.log("jquery: " + $.fn.jquery);
			jq = $.noConflict(true);
		}
		if (!$ || !jQuery) {
			$ = jQuery = jq;
		}
	})();

	console.log("testing0");

	var tableData = [];
	var listPage = $("#onestop_news_list");

	var tableCol = [ {
		field : "brand",
		title : "data Id",
		hidden : true
	}, {
		field : "name",
		title : "Name"
	}, {
		field : "price",
		title : "price"
	}, {
		field : "product_type",
		title : "product_type"

	}, {
		field : "price_sign",
		title : "price_sign"

	} ];
	function init() {
		createTableHeader();

		// Liferay.Service(
		// '/foo.crud/get-by-crud-list',
		// {
		// crudId: 6
		// },
		// function(obj) {
		// console.log(obj);
		// loadTable(obj);
		// });
		
		
//		Fetching data from Third party api
//		$.get('http://makeup-api.herokuapp.com/api/v1/products.json', // url
//		function(obj) { // success callback
//			console.log(obj);
//			loadTable(obj);
//		});
	}

	function createTableHeader() {
		var row = $("<tr>");
		$("<thead>").append(row).appendTo(listPage.find("table"));
		tableCol.forEach(function(column) {
			if (!column.hidden) {
				var th = $("<th>").text(column.title).appendTo(row);
				column.css && th.css(column.css);
			}
		});
	}

	function loadTable(data) {
		var table = $("<tbody>").appendTo(listPage.find(".view-list"));
		tableData = data;
		data.forEach(function(record) {
			var row = $("<tr>").appendTo(table);
			tableCol.forEach(function(column) {
				if (!column.hidden) {
					var td = $("<td>").appendTo(row)
					column.css && td.css(column.css);
					td.text(record[column.field]);
				}
			});
		});
	}

	init();
});*/