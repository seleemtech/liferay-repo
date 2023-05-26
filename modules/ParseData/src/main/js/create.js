  $(document).ready(function() {
    var index = 0;
    var itemIndex = 20;
    var countInput=$('#<portlet:namespace />rowCount');
    var handleAddButtonClick = function() {
      var newRow = $('#rowIndexes .mainLife').first().clone();
      var itemNumber = (itemIndex += 20).toString().padStart(4, '0');
      newRow.find('input').val('');
      newRow.find('input[name$="<portlet:namespace />itemNumber0"]').attr('name', '<portlet:namespace />itemNumber' + (++index)).val(itemNumber);
      newRow.find('input[name$="<portlet:namespace />hpPartNumber0"]').attr('name', '<portlet:namespace />hpPartNumber' + index);
      newRow.find('input[name$="<portlet:namespace />partDescription0"]').attr('name', '<portlet:namespace />partDescription' + index);
      newRow.find('input[name$="<portlet:namespace />requestQuantity0"]').attr('name', '<portlet:namespace />requestQuantity' + index);
      newRow.find('p[name=Quantity-Error0]').attr('name', 'Quantity-Error' + index);
      $('#rowIndexes').append(newRow);
      countInput.val(index);
    };
    $('button[name="<portlet:namespace />add-rows"]').click(handleAddButtonClick);
   
    $('button[name="<portlet:namespace />remove-rows"]').click(function() {
      if (index > 1) {
        $('#rowIndexes .mainLife').last().remove();
        index--;
        itemIndex -= 20;
        countInput.val(index);
      }
    });

 
   var deleletAll= function() {
	      $('#rowIndexes .mainLife:not(:first)').remove();
	      index = 0;
	      countInput.val(index);
	    };
	    $('button[name="<portlet:namespace />delete-all-rows"]').click(deleletAll);
    $('body').on('change', 'input[name^="<portlet:namespace />hpPartNumber"]', function() {
      var inputVal = $(this).val();
      var indexValue=$(this).attr('name').slice(-1).trim();
      $.ajax({
        url: '<%=resourceURL%>',
														data : {
															'<portlet:namespace />hpPartNumber' : inputVal
														},
														type : "POST",
														dataType : 'json',
														success : function(data) {
														
															 
															  $('input[name="<portlet:namespace />partDescription'+ indexValue + '"]').val(data.partDescription);
															    $('input[name="<portlet:namespace />requestQuantity' + indexValue + '"]').val(data.requestQuantity);

															
														},
														error : function(jqXHR,
																textStatus,
																errorThrown) {
															alert("Error: "
																	+ textStatus
																	+ " - "
																	+ errorThrown);
														}
													});
										});
    $('body').on('keypress', 'input[name^="<portlet:namespace />requestQuantity"]', function(event) {
    	  var keyCode = event.which;
    	  if (keyCode === 46 || keyCode === 8 || (keyCode >= 48 && keyCode <= 57)) {
              return true;
            } else {
              event.preventDefault();
              return false;
            }
      
  										});

  $('body').on('blur', 'input[name^="<portlet:namespace />requestQuantity"]', function(event) {
	  var inputValue = $(this).val();
	  var ErrorindexValue=$(this).attr('name').slice(-1).trim();
      console.log(ErrorindexValue);
      var numberValue = Number(inputValue);

      
      if (numberValue <= 0) {
    	  $('[name="Quantity-Error' + ErrorindexValue + '"]').show();
        $(this).val("");
      }else{
    	  $('[name="Quantity-Error' + ErrorindexValue + '"]').hide();
      }
    
										});
   
  $('#<portlet:namespace />resetForm').click(function() {
	    $('#<portlet:namespace />fm')[0].reset();
	    deleletAll();
	  });

					});