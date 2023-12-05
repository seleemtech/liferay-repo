/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.esqure.intranet.project.management.web.headless.frontent.filter;


import com.esquare.intranet.project.management.constants.ProjectConstant;
import com.liferay.frontend.data.set.constants.FDSEntityFieldTypes;
import com.liferay.frontend.data.set.filter.BaseSelectionFDSFilter;
import com.liferay.frontend.data.set.filter.FDSFilter;
import com.liferay.frontend.data.set.filter.SelectionFDSFilterItem;
import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mahammed Seleem
 * @Descriptions: This class is used for listing the project status column for filters.
 */
@Component(
	property = "frontend.data.set.name=" + ProjectConstant.PTOJECT_TABLE,
	service = FDSFilter.class
)
public class ProjectStatusSelectionFDSFilter extends BaseSelectionFDSFilter {

	@Override
	public String getId() {
		return "status";
	}

	@Override
	public String getEntityFieldType() {
		return FDSEntityFieldTypes.COLLECTION;
	}


	@Override
	public String getLabel() {
		return "Project Status";
	}

	@Override
	public List<SelectionFDSFilterItem> getSelectionFDSFilterItems(
		Locale locale) {

		List<SelectionFDSFilterItem> selectionFDSFilterItems =
			new ArrayList<>();

		List<ListTypeDefinition> listTypeDefinition = ListTypeDefinitionLocalServiceUtil.getListTypeDefinitions(-1,-1);
		Map<Long,String> listTypeName = listTypeDefinition.stream().collect(Collectors.toMap(ListTypeDefinition::getListTypeDefinitionId, listType->extractNameFromXML(listType.getName())));
		List<String> listEntryNames = new ArrayList<>();
		listTypeName.forEach((id, name) -> {
			if(Validator.isNotNull(name) && ProjectConstant.PROJECT_STATUS.equalsIgnoreCase(name)){
				List<ListTypeEntry> listTypeEntry = ListTypeEntryLocalServiceUtil.getListTypeEntries(id);
				listTypeEntry.stream().map(entry -> entry.getName(Locale.ENGLISH)).forEach(listEntryNames::add);
			}
		});

		for(String listEntryName:listEntryNames){
			selectionFDSFilterItems.add(
					new SelectionFDSFilterItem(
							listEntryName,listEntryName));
		}

		return selectionFDSFilterItems;
	}

	private static String extractNameFromXML(String xmlContent) {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			InputSource inputSource = new InputSource(new StringReader(xmlContent));
			Document doc = dBuilder.parse(inputSource);

			doc.getDocumentElement().normalize();
			NodeList nameList = doc.getElementsByTagName("Name");
			if (nameList.getLength() > 0) {
				Node nameNode = nameList.item(0);
				return nameNode.getTextContent();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StringPool.BLANK;
	}



	@Override
	public boolean isMultiple() {
		return false;
	}


}