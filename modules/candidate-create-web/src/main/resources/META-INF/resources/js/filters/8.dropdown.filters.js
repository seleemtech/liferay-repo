$(document).ready(function() {
	  var filters = []; // Declare and initialize the filters array globally
	// Last Name filter
    initializeFilter('#checkCandidateStage', '#dropCandidateStage', '#filterCandidateStage', '.candidateStage');
	  // Last Name filter
	initializeFilter('#checkLastName', '#dropLastName', '#filterLastName', '.lastName');
	  
	// Candidate Status filter
	initializeFilter('#checkCandidateStatus', '#dropCandidateStatus', '#filterCandidateStatus', '.candidateStatus'); 
	// Email filter
	initializeFilter('#checkEmail', '#dropEmail', '#filterEmail', '.candidateEmail');
	// Skill filter
	initializeFilter('#checkSkill', '#dropSkill', '#filterSkill', '.candidateSkill');
	// Secondary Email filter
	initializeFilter('#checkSecEmail', '#dropSecEmail', '#filterSecEmail', '.candidateSecEmail');
	// Secondary Email filter
	initializeFilter('#checkCandidateOwner', '#dropCandidateOwner', '#filterCandidateOwner', '.candidateOwner');
	// City filter
	initializeFilter('#checkCity', '#dropCity', '#filterCity', '.city');
	// Country filter
	initializeFilter('#checkCountry', '#dropCountry', '#filterCountry', '.country');
	
	// Current Employer filter
	initializeFilter('#checkCurrentEmployer', '#dropCurrentEmployer', '#filterCurrentEmployer', '.currentEmployer');
	
	// Current Job Title filter
	initializeFilter('#checkCandidateJobTitle', '#dropCandidateJobTitle', '#filterCandidateJobTitle', '.currentJobTitle');
	
	
	  //Candidate ID filter
	initializeFilter('#checkCandidateId', '#dropCandidateId', '#filterCandidateId', '.candidateId');
	  // First Name filter
	initializeFilter('#checkFirstName', '#dropFirstName', '#filterFirstName', '.firstName');
	// Highest Qualification Held filter
	initializeFilter('#checkQualification', '#dropQualification', '#filterQualification', '.highQualification');

	// Mobile filter
	initializeFilter('#checkMobile', '#dropMobile', '#filterMobile', '.mobile'); 
	
	// Source filter
	initializeFilter('#checkSource', '#dropSource', '#filterSource', '.source'); 
	// State filter
	initializeFilter('#checkState', '#dropState', '#filterState', '.State'); 
	// Street filter
	initializeFilter('#checkStreet', '#dropStreet', '#filterStreet', '.Street'); 
	// WebSite filter
	initializeFilter('#checkWebsite', '#dropWebSite', '#filterWebsite', '.website'); 
	// ZipCode filter
	initializeFilter('#checkZipCode', '#dropZipCode', '#filterZipCode', '.zipCode'); 

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
	        	console.log("inside the if");
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
	    $('.table tbody tr').each(function() {
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
	        } else{
	        	hideRow = false;
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
	  
	  //Search bar code
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
