

<%@ include file="/init.jsp"%>



<portlet:renderURL var="returnsURL">
	<portlet:param name="mvcPath" value="/rma/returns.jsp" />
	<portlet:param name="command" value="returnsRMACMD" />
</portlet:renderURL>

<portlet:renderURL var="CreateRMAURL">
	<portlet:param name="mvcPath" value="/rma/createrma.jsp" />
	<portlet:param name="command" value="createRMACMD" />
</portlet:renderURL>


<portlet:renderURL var="UpdateRMAURL">
	<portlet:param name="mvcPath" value="/rma/updaterma.jsp" />
	<portlet:param name="command" value="updateRMACMD" />
</portlet:renderURL>

<portlet:actionURL name="testRMA" var="testRMAURL" />


<aui:form action="<%=testRMAURL%>" method="post" name="fm">
	<aui:input name="shipTo" value="" type="hidden"></aui:input>
	<aui:input name="rowCount" value="0" id="rowCount" type="hidden"></aui:input>
		<div id="rowIndexes" style="display: block; white-space: nowrap; overflow-x: scroll;">
			<div class="mainLife" >
				<div class="row" >
					    
	                <div class="col-md-3">
						<aui:input name="itemNumber0" prefix="" value="0020" label=""
							disabled="true" />
				
	    </div>
	                <div class="col-md-3">
				
						<aui:input name="hpPartNumber0" prefix="" label="" />
				    </div>
	                <div class="col-md-3">
						<aui:input name="partDescription0" prefix="" label="" />
				    </div>
	                <div class="col-md-3">
						<aui:input name="requestQuantity0" prefix="" label="" />
							<p id="Quantity-Error" name="Quantity-Error0"
									style="display: none; color: red; font-size: 18px;">User
									already exists!</p>
				    </div>
	                <div class="col-md-3">
						<aui:input name="request4Quantity0" prefix="" label="" />
				
					    </div>
	                <div class="col-md-3">
						<aui:input name="request4Quantity0" prefix="" label="" />
			
					    </div>
	                <div class="col-md-3">
						<aui:input name="requestQ2uantity0" prefix="" label="" />
					
					    </div>
	                <div class="col-md-3">
						<aui:input name="request1Quantity0" prefix="" label="" />
					
	    </div>
	    
				</div>
			</div>
	
		</div>
	<div class="row">
		<div class="col-md-8">
			<aui:button type="button" id="resetForm" value="Reset" onclick="resetscreen();" />
			<aui:button type="submit" id="submitForm" value="Save" />
		</div>
		<div class="col-md-4">
			<aui:button type="button" value="Delete all data"
				name="delete-all-rows" />
			<aui:button type="button" value="+" name="add-rows" />
			<aui:button type="button" value="-" name="remove-rows" />
		</div>

	</div>
</aui:form>


<portlet:resourceURL var="resourceURL" />
<script>
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
</script>
