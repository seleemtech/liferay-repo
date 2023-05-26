
<div>
  <input type="text" id="labelSearchBar" placeholder="Search Labels">
</div>
<div> 
  <label class="checkbox-label">
    <input type="checkbox" name="filterName" id="checkFirstName" />
    First Name
  </label> 
</div>
<div>
  <select id="dropFirstName" style="display:none" class="filter-dropdown" data-columnClass="firstName">
    <option value=""></option>
    <option value="contains">contains</option>
    <option value="doesn't contains">doesn't contain</option>
    <option value="is">is</option>
    <option value="is not">is not</option>
    <option value="starts with">starts with</option> 
    <option value="ends with">ends with</option> 
    <option value="is empty">is empty</option>
    <option value="is not empty">is not empty</option>
  </select>
  <input type="text" id="filterFirstName" class="filter-input" placeholder="Enter First Name" style="display: none;">
</div>

<div>
  <label class="checkbox-label">
    <input type="checkbox" id="checkLastName" />
    Last Name
  </label>
</div>
<div>
 <select id="dropLastName" style="display:none" class="filter-dropdown" data-columnClass="firstName">
    <option value=""></option>
    <option value="contains">contains</option>
    <option value="doesn't contains">doesn't contain</option>
    <option value="is">is</option>
    <option value="is not">is not</option>
    <option value="starts with">starts with</option> 
    <option value="ends with">ends with</option> 
    <option value="is empty">is empty</option>
    <option value="is not empty">is not empty</option>
  </select>
  <input type="text" id="filterLastName" class="filter-input" placeholder="Enter Last Name" style="display: none;">
</div>

<div style="gap: 1rem; display:none;" id="FilterButtonID">
  <button type="submit" id="applyFilterBtn">Apply Filter</button>
  <button type="button" id="clearFilterBtn">Clear Filter</button>
</div>

<table id="table-column-toggle" class="display">
  <thead>
    <tr>
      <th class="firstName">Name</th>
      <th>Position</th>
      <th>Office</th>
      <th>Age</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td class="firstName">Tiger Nixon</td>
      <td class="lastName">System Architect</td>
      <td>Edinburgh</td>
      <td>61</td>
    </tr> 
    <tr> 
      <td class="firstName">Garrett  Winters</td>
      <td class="lastName">Accountant</td>
      <td>Tokyo</td>
      <td>63</td>
    </tr>
    <tr>
      <td class="firstName"></td>
      <td class="lastName">aunior Technical Author</td>
      <td>San Francisco</td>
      <td>66</td>
    </tr>
  </tbody>
</table>  

<script>


$(document).ready(function() {
	  var filters = []; // Declare and initialize the filters array globally

	  // First Name filter
	  initializeFilter('#checkFirstName', '#dropFirstName', '#filterFirstName', '.firstName');

	  // Last Name filter
	  initializeFilter('#checkLastName', '#dropLastName', '#filterLastName', '.lastName');

	  // Apply Filter button
	  $('#applyFilterBtn').click(function() {
	    applyFilters();
	  });

	  // Clear Filter button
	  $('#clearFilterBtn').click(function() {
	    clearFilters();
	  });

	  function initializeFilter(checkboxId, dropdownId, filterId, columnClass) {
	    $(checkboxId).change(function() {
	      if (this.checked) {
	       
	        if (dropdownId) {
	          $(dropdownId).slideDown();
	          showFilterInput(dropdownId, filterId);
	        }
	      } else {
	        if (dropdownId) {
	          $(dropdownId).slideUp();
	        }
	        $(filterId).val('').hide();
      $(dropdownId).val('');
	        
	        applyFilters();
	      }
       toggleFilterButton();
	    });

	    if (dropdownId) {
	      $(dropdownId).change(function() {
	        showFilterInput(dropdownId, filterId);
	      });
	    }

	    filters.push({
	      dropdownId: dropdownId,
	      filterId: filterId,
	      columnClass: columnClass
	    });
	  }

function toggleFilterButton() {
var anyCheckboxChecked = false;
$('.checkbox-label input[type="checkbox"]').each(function() {
if ($(this).is(':checked')) {
  anyCheckboxChecked = true;
  return false; // exit the loop if any checkbox is checked
}
});

if (anyCheckboxChecked) {
$('#FilterButtonID').show();
} else {
$('#FilterButtonID').hide();
}
}
	  function showFilterInput(dropdownId, filterId) {
	    var selectedValue = $(dropdownId).val();
	    if (selectedValue === 'contains' || selectedValue === 'starts with' || selectedValue === 'ends with' || selectedValue === "doesn't contains" || selectedValue ==='is' || selectedValue === 'is not') {
	      $(filterId).show();
	    } else {
	      $(filterId).val('').hide();
	    }
	  }

	  function applyFilters() {
	    $('#table-column-toggle tbody tr').each(function() {
	      var row = $(this);
	      var hideRow = false;

	      for (var i = 0; i < filters.length; i++) {
	        var filter = filters[i];
	        var filterValue = $(filter.filterId).val().toLowerCase();
	        var columnValue = row.find(filter.columnClass).text().toLowerCase();
	        if ($(filter.dropdownId).is(':visible')) {
	          var dropdownValue = $(filter.dropdownId).val();
	          if (dropdownValue === 'contains' && columnValue.indexOf(filterValue) === -1) {
	            hideRow = true;
	            break;
	          } else if (dropdownValue === 'starts with' && !columnValue.startsWith(filterValue)) {
	            hideRow = true;
	            break;
	          } else if (dropdownValue === 'ends with' && !columnValue.endsWith(filterValue)) {
	            hideRow = true;
	            break;
	          } else if (dropdownValue === "doesn't contains" && columnValue.includes(filterValue)) {
	            hideRow = true;
	            break;
	          }else if (dropdownValue === 'is empty' && columnValue !== '') {
	          hideRow = true;
	          break;
	        } else if (dropdownValue === 'is not empty' && columnValue === '') {
	          hideRow = true;
	          break;
	        }else if (dropdownValue === 'is' && columnValue !== filterValue) {
	          hideRow = true;
	          break;
	        } else if (dropdownValue === 'is not' && columnValue === filterValue) {
	          hideRow = true;
	          break;
	        }
	        }
	      }

	      if (hideRow) {
	        row.hide();
	      } else {
	        row.show();
	      }
	    });
	  }
$('#labelSearchBar').on('input', function() {
var searchTerm = $(this).val().toLowerCase();
$('label.checkbox-label').each(function() {
var labelText = $(this).text().toLowerCase();
if (labelText.indexOf(searchTerm) !== -1) {
  $(this).show();
} else {
  $(this).hide();
}
});
});
	  function clearFilters() {
	    $('.filter-dropdown').val('').slideUp();
	    $('.filter-input').val('').hide();
	    $('.checkbox-label input[type="checkbox"]').prop('checked', false);
	    $('#FilterButtonID').hide();
	    applyFilters();
	  }
	});

</script>