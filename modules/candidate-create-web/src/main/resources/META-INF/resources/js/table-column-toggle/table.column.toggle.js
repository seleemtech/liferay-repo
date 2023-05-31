
  // Your jQuery code using the $ symbol
$(document).ready(function() {

    $(".showHeaderBtn").click(function() {
        $(this).siblings(".columnEdit").toggle();
        console.log("Clicked");
    });
    $('.closeColumnsBtn').click(function() {
    	 $(".columnEdit").hide();
    });

    $('.toggleColumnsBtn').on('click', function() {
        var tableContainer = $(this).closest('.tableContainer');
        var table = tableContainer.find('.myTable');

        tableContainer.find('.header-checkbox').each(
            function() {
                var columnValue = $(
                    this).data('column');
                var checked = $(this).is(':checked');

                // Show/hide the corresponding table cells based on checkbox state
                table.find('tr').each(function() {
                    var $td = $(this).find('td').eq(table.find('th').filter(function() {
                        return $(this).text() === columnValue;
                    }).index());
                    if (checked) {
                        $td
                            .show();
                    } else {
                        $td
                            .hide();
                    }
                });

                // Show/hide the corresponding table header based on checkbox state
                var $th = table.find('th').filter(function() {
                    return $(this).text() === columnValue;
                });
                if (checked) {
                    $th.show();
                } else {
                    $th.hide();
                }
            });

        // Hide the columnEdit section
        tableContainer.find('.columnEdit')
            .hide();
    });
    
    $('#setupsearch').on('input', function() {
    	var searchTerm = $(this).val().toLowerCase();
    	$('label.toggle-checkbox').each(function() {
    	var labelText = $(this).text().toLowerCase();
    	if (labelText.indexOf(searchTerm) !== -1) {
    	  $(this).show();
    	} else {
    	  $(this).hide();
    	}
    	});
    	});
});
