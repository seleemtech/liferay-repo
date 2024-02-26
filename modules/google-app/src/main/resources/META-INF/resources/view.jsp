<%@ include file="/init.jsp"%>

<%
	GoogleAppDisplayContext formIntegrationDisplayContext = new GoogleAppDisplayContext(renderRequest, renderResponse);
%>
<portlet:renderURL var="viewRenderUrl">
	<portlet:param name="mvcRenderCommandName" value="get/Api/Data" />
</portlet:renderURL>

<div class="card">
	<input type="text" class="search-bar" placeholder="Search...">
	<div class="icons-container">
		<div class="icon" onclick="selectIcon(this)">
			<img src="http://localhost:8080/documents/d/guest/1" alt="Google Sheet">
			<span class="icon-name">Google Sheet</span>
		</div>
		<div class="icon" onclick="selectIcon(this)">
			<img src="http://localhost:8080/documents/d/guest/2" alt="Gmail">
			<span class="icon-name">Gmail</span>
		</div>
	</div>
</div>

<div class="select-container">

	<div class="select-icons">
	</div>

	<div class="appStyle new pulse">
		<svg width="36" viewBox="0 0 48 48">
			<path fill="#FFFFFF" d="M37.9,26.2h-12v12h-4v-12h-12v-4h12v-12h4v12h12V26.2z"></path>
		</svg>
		<div class="appHelpTxt">
			Select App 2
		</div>
	</div>
</div>

<div class="mx-auto d-flex justify-content-center mt-4">

	<button type="submit" class="btn btn-primary"  onclick='<%= liferayPortletResponse.getNamespace() + "integrate();" %>'>Integrate</button>
</div>


<script>
	const selectedIcons = [];

	function selectIcon(iconElement) {
		const iconImg = iconElement.querySelector('img').cloneNode(true);
		const iconName = iconElement.querySelector('.icon-name').innerText;
		selectedIcons.push({ img: iconImg, name: iconName });
		updateSelectedIcons();
	}

	function updateSelectedIcons() {
		const selectedIconContainer = document.querySelector('.select-icons');
		selectedIconContainer.innerHTML = '';

		selectedIcons.forEach(function (icon, index) {
			const div = document.createElement('div');
			div.classList.add('select-icon');
			div.id = 'selected-icon' + (index + 1);
			div.innerHTML = '<img src="' + icon.img.src + '" alt="">' +
					'<span class="close-icon" onclick="removeSelectedIcon(' + index + ')">X</span>';

			selectedIconContainer.appendChild(div);

			if (index < selectedIcons.length) {
				const line = document.createElement('div');
				line.classList.add('line');
				selectedIconContainer.appendChild(line);
			}
		});
	}

	function removeSelectedIcon(index) {
		selectedIcons.splice(index, 1);
		updateSelectedIcons();
	}

</script>

<aui:script>
	Liferay.provide(
	window,
	'<portlet:namespace />integrate',
	() => {
	const iconNames = [];
	selectedIcons.forEach(function (icon) {
	iconNames.push(icon.name);
	});
	var firstAppName = "";
	var secondAppName = "";
	if (iconNames.length === 2) {
	firstAppName = iconNames[0].trim();
	secondAppName = iconNames[1].trim();
	}
	var portletURL = Liferay.PortletURL.createURL(Liferay.currentURL);

	portletURL.setLifecycle(0);
	portletURL.setParameter('firstAppName', firstAppName);
	portletURL.setParameter('secondAppName', secondAppName);
	portletURL.setParameter('mvcRenderCommandName', 'firstConnectionName');
	portletURL.setPortletId('com_google_app_GoogleAppPortlet');
	window.location.replace(portletURL.toString());
	},
	['liferay-portlet-url']
	);
	$(document).ready(function () {
	sessionStorage.removeItem('firstAppRefreshToken');
	sessionStorage.removeItem('firstAppUserEmailAddress');
	sessionStorage.removeItem('firstAppSpreadSheetId');
	sessionStorage.removeItem('firstAppWorkSheetName');

	sessionStorage.removeItem('secondAppRefreshToken');
	sessionStorage.removeItem('secondAppUserEmailAddress');
	sessionStorage.removeItem('secondAppSpreadSheetId');
	sessionStorage.removeItem('secondAppWorkSheetName');
	});
</aui:script>
