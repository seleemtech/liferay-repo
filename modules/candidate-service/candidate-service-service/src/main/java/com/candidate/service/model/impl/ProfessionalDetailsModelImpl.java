/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.candidate.service.model.impl;

import com.candidate.service.model.ProfessionalDetails;
import com.candidate.service.model.ProfessionalDetailsModel;
import com.candidate.service.model.ProfessionalDetailsSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the ProfessionalDetails service. Represents a row in the &quot;RMS_ProfessionalDetails&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ProfessionalDetailsModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProfessionalDetailsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProfessionalDetailsImpl
 * @generated
 */
@JSON(strict = true)
public class ProfessionalDetailsModelImpl
	extends BaseModelImpl<ProfessionalDetails>
	implements ProfessionalDetailsModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a professional details model instance should use the <code>ProfessionalDetails</code> interface instead.
	 */
	public static final String TABLE_NAME = "RMS_ProfessionalDetails";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"professionalDetailsId", Types.BIGINT},
		{"candidateId", Types.BIGINT}, {"expectedSalary", Types.DOUBLE},
		{"currentSalary", Types.DOUBLE}, {"skillSet", Types.VARCHAR},
		{"additionalInfo", Types.VARCHAR}, {"currentEmployer", Types.VARCHAR},
		{"workType", Types.VARCHAR}, {"experience ", Types.VARCHAR},
		{"qualification", Types.VARCHAR}, {"jobTitle", Types.VARCHAR},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("professionalDetailsId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("candidateId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("expectedSalary", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("currentSalary", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("skillSet", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("additionalInfo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("currentEmployer", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("workType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("experience ", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("qualification", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("jobTitle", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table RMS_ProfessionalDetails (uuid_ VARCHAR(75) null,professionalDetailsId LONG not null primary key,candidateId LONG,expectedSalary DOUBLE,currentSalary DOUBLE,skillSet VARCHAR(75) null,additionalInfo VARCHAR(75) null,currentEmployer VARCHAR(75) null,workType VARCHAR(75) null,experience  VARCHAR(75) null,qualification VARCHAR(75) null,jobTitle VARCHAR(75) null,companyId LONG,userId LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table RMS_ProfessionalDetails";

	public static final String ORDER_BY_JPQL =
		" ORDER BY professionalDetails.professionalDetailsId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY RMS_ProfessionalDetails.professionalDetailsId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CANDIDATEID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PROFESSIONALDETAILSID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static ProfessionalDetails toModel(
		ProfessionalDetailsSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		ProfessionalDetails model = new ProfessionalDetailsImpl();

		model.setUuid(soapModel.getUuid());
		model.setProfessionalDetailsId(soapModel.getProfessionalDetailsId());
		model.setCandidateId(soapModel.getCandidateId());
		model.setExpectedSalary(soapModel.getExpectedSalary());
		model.setCurrentSalary(soapModel.getCurrentSalary());
		model.setSkillSet(soapModel.getSkillSet());
		model.setAdditionalInfo(soapModel.getAdditionalInfo());
		model.setCurrentEmployer(soapModel.getCurrentEmployer());
		model.setWorkType(soapModel.getWorkType());
		model.setExperience(soapModel.getExperience());
		model.setQualification(soapModel.getQualification());
		model.setJobTitle(soapModel.getJobTitle());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<ProfessionalDetails> toModels(
		ProfessionalDetailsSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<ProfessionalDetails> models = new ArrayList<ProfessionalDetails>(
			soapModels.length);

		for (ProfessionalDetailsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public ProfessionalDetailsModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _professionalDetailsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProfessionalDetailsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _professionalDetailsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ProfessionalDetails.class;
	}

	@Override
	public String getModelClassName() {
		return ProfessionalDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ProfessionalDetails, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ProfessionalDetails, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProfessionalDetails, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((ProfessionalDetails)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ProfessionalDetails, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ProfessionalDetails, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ProfessionalDetails)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ProfessionalDetails, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ProfessionalDetails, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, ProfessionalDetails>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			ProfessionalDetails.class.getClassLoader(),
			ProfessionalDetails.class, ModelWrapper.class);

		try {
			Constructor<ProfessionalDetails> constructor =
				(Constructor<ProfessionalDetails>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<ProfessionalDetails, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<ProfessionalDetails, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<ProfessionalDetails, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<ProfessionalDetails, Object>>();
		Map<String, BiConsumer<ProfessionalDetails, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<ProfessionalDetails, ?>>();

		attributeGetterFunctions.put("uuid", ProfessionalDetails::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<ProfessionalDetails, String>)
				ProfessionalDetails::setUuid);
		attributeGetterFunctions.put(
			"professionalDetailsId",
			ProfessionalDetails::getProfessionalDetailsId);
		attributeSetterBiConsumers.put(
			"professionalDetailsId",
			(BiConsumer<ProfessionalDetails, Long>)
				ProfessionalDetails::setProfessionalDetailsId);
		attributeGetterFunctions.put(
			"candidateId", ProfessionalDetails::getCandidateId);
		attributeSetterBiConsumers.put(
			"candidateId",
			(BiConsumer<ProfessionalDetails, Long>)
				ProfessionalDetails::setCandidateId);
		attributeGetterFunctions.put(
			"expectedSalary", ProfessionalDetails::getExpectedSalary);
		attributeSetterBiConsumers.put(
			"expectedSalary",
			(BiConsumer<ProfessionalDetails, Double>)
				ProfessionalDetails::setExpectedSalary);
		attributeGetterFunctions.put(
			"currentSalary", ProfessionalDetails::getCurrentSalary);
		attributeSetterBiConsumers.put(
			"currentSalary",
			(BiConsumer<ProfessionalDetails, Double>)
				ProfessionalDetails::setCurrentSalary);
		attributeGetterFunctions.put(
			"skillSet", ProfessionalDetails::getSkillSet);
		attributeSetterBiConsumers.put(
			"skillSet",
			(BiConsumer<ProfessionalDetails, String>)
				ProfessionalDetails::setSkillSet);
		attributeGetterFunctions.put(
			"additionalInfo", ProfessionalDetails::getAdditionalInfo);
		attributeSetterBiConsumers.put(
			"additionalInfo",
			(BiConsumer<ProfessionalDetails, String>)
				ProfessionalDetails::setAdditionalInfo);
		attributeGetterFunctions.put(
			"currentEmployer", ProfessionalDetails::getCurrentEmployer);
		attributeSetterBiConsumers.put(
			"currentEmployer",
			(BiConsumer<ProfessionalDetails, String>)
				ProfessionalDetails::setCurrentEmployer);
		attributeGetterFunctions.put(
			"workType", ProfessionalDetails::getWorkType);
		attributeSetterBiConsumers.put(
			"workType",
			(BiConsumer<ProfessionalDetails, String>)
				ProfessionalDetails::setWorkType);
		attributeGetterFunctions.put(
			"experience ", ProfessionalDetails::getExperience);
		attributeSetterBiConsumers.put(
			"experience ",
			(BiConsumer<ProfessionalDetails, String>)
				ProfessionalDetails::setExperience);
		attributeGetterFunctions.put(
			"qualification", ProfessionalDetails::getQualification);
		attributeSetterBiConsumers.put(
			"qualification",
			(BiConsumer<ProfessionalDetails, String>)
				ProfessionalDetails::setQualification);
		attributeGetterFunctions.put(
			"jobTitle", ProfessionalDetails::getJobTitle);
		attributeSetterBiConsumers.put(
			"jobTitle",
			(BiConsumer<ProfessionalDetails, String>)
				ProfessionalDetails::setJobTitle);
		attributeGetterFunctions.put(
			"companyId", ProfessionalDetails::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<ProfessionalDetails, Long>)
				ProfessionalDetails::setCompanyId);
		attributeGetterFunctions.put("userId", ProfessionalDetails::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<ProfessionalDetails, Long>)
				ProfessionalDetails::setUserId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getProfessionalDetailsId() {
		return _professionalDetailsId;
	}

	@Override
	public void setProfessionalDetailsId(long professionalDetailsId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_professionalDetailsId = professionalDetailsId;
	}

	@JSON
	@Override
	public long getCandidateId() {
		return _candidateId;
	}

	@Override
	public void setCandidateId(long candidateId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_candidateId = candidateId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCandidateId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("candidateId"));
	}

	@JSON
	@Override
	public double getExpectedSalary() {
		return _expectedSalary;
	}

	@Override
	public void setExpectedSalary(double expectedSalary) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_expectedSalary = expectedSalary;
	}

	@JSON
	@Override
	public double getCurrentSalary() {
		return _currentSalary;
	}

	@Override
	public void setCurrentSalary(double currentSalary) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_currentSalary = currentSalary;
	}

	@JSON
	@Override
	public String getSkillSet() {
		if (_skillSet == null) {
			return "";
		}
		else {
			return _skillSet;
		}
	}

	@Override
	public void setSkillSet(String skillSet) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_skillSet = skillSet;
	}

	@JSON
	@Override
	public String getAdditionalInfo() {
		if (_additionalInfo == null) {
			return "";
		}
		else {
			return _additionalInfo;
		}
	}

	@Override
	public void setAdditionalInfo(String additionalInfo) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_additionalInfo = additionalInfo;
	}

	@JSON
	@Override
	public String getCurrentEmployer() {
		if (_currentEmployer == null) {
			return "";
		}
		else {
			return _currentEmployer;
		}
	}

	@Override
	public void setCurrentEmployer(String currentEmployer) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_currentEmployer = currentEmployer;
	}

	@JSON
	@Override
	public String getWorkType() {
		if (_workType == null) {
			return "";
		}
		else {
			return _workType;
		}
	}

	@Override
	public void setWorkType(String workType) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_workType = workType;
	}

	@JSON
	@Override
	public String getExperience() {
		if (_experience == null) {
			return "";
		}
		else {
			return _experience;
		}
	}

	@Override
	public void setExperience(String experience) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_experience = experience;
	}

	@JSON
	@Override
	public String getQualification() {
		if (_qualification == null) {
			return "";
		}
		else {
			return _qualification;
		}
	}

	@Override
	public void setQualification(String qualification) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_qualification = qualification;
	}

	@JSON
	@Override
	public String getJobTitle() {
		if (_jobTitle == null) {
			return "";
		}
		else {
			return _jobTitle;
		}
	}

	@Override
	public void setJobTitle(String jobTitle) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_jobTitle = jobTitle;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), ProfessionalDetails.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ProfessionalDetails toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, ProfessionalDetails>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ProfessionalDetailsImpl professionalDetailsImpl =
			new ProfessionalDetailsImpl();

		professionalDetailsImpl.setUuid(getUuid());
		professionalDetailsImpl.setProfessionalDetailsId(
			getProfessionalDetailsId());
		professionalDetailsImpl.setCandidateId(getCandidateId());
		professionalDetailsImpl.setExpectedSalary(getExpectedSalary());
		professionalDetailsImpl.setCurrentSalary(getCurrentSalary());
		professionalDetailsImpl.setSkillSet(getSkillSet());
		professionalDetailsImpl.setAdditionalInfo(getAdditionalInfo());
		professionalDetailsImpl.setCurrentEmployer(getCurrentEmployer());
		professionalDetailsImpl.setWorkType(getWorkType());
		professionalDetailsImpl.setExperience(getExperience());
		professionalDetailsImpl.setQualification(getQualification());
		professionalDetailsImpl.setJobTitle(getJobTitle());
		professionalDetailsImpl.setCompanyId(getCompanyId());
		professionalDetailsImpl.setUserId(getUserId());

		professionalDetailsImpl.resetOriginalValues();

		return professionalDetailsImpl;
	}

	@Override
	public ProfessionalDetails cloneWithOriginalValues() {
		ProfessionalDetailsImpl professionalDetailsImpl =
			new ProfessionalDetailsImpl();

		professionalDetailsImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		professionalDetailsImpl.setProfessionalDetailsId(
			this.<Long>getColumnOriginalValue("professionalDetailsId"));
		professionalDetailsImpl.setCandidateId(
			this.<Long>getColumnOriginalValue("candidateId"));
		professionalDetailsImpl.setExpectedSalary(
			this.<Double>getColumnOriginalValue("expectedSalary"));
		professionalDetailsImpl.setCurrentSalary(
			this.<Double>getColumnOriginalValue("currentSalary"));
		professionalDetailsImpl.setSkillSet(
			this.<String>getColumnOriginalValue("skillSet"));
		professionalDetailsImpl.setAdditionalInfo(
			this.<String>getColumnOriginalValue("additionalInfo"));
		professionalDetailsImpl.setCurrentEmployer(
			this.<String>getColumnOriginalValue("currentEmployer"));
		professionalDetailsImpl.setWorkType(
			this.<String>getColumnOriginalValue("workType"));
		professionalDetailsImpl.setExperience(
			this.<String>getColumnOriginalValue("experience "));
		professionalDetailsImpl.setQualification(
			this.<String>getColumnOriginalValue("qualification"));
		professionalDetailsImpl.setJobTitle(
			this.<String>getColumnOriginalValue("jobTitle"));
		professionalDetailsImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		professionalDetailsImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));

		return professionalDetailsImpl;
	}

	@Override
	public int compareTo(ProfessionalDetails professionalDetails) {
		long primaryKey = professionalDetails.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProfessionalDetails)) {
			return false;
		}

		ProfessionalDetails professionalDetails = (ProfessionalDetails)object;

		long primaryKey = professionalDetails.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<ProfessionalDetails> toCacheModel() {
		ProfessionalDetailsCacheModel professionalDetailsCacheModel =
			new ProfessionalDetailsCacheModel();

		professionalDetailsCacheModel.uuid = getUuid();

		String uuid = professionalDetailsCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			professionalDetailsCacheModel.uuid = null;
		}

		professionalDetailsCacheModel.professionalDetailsId =
			getProfessionalDetailsId();

		professionalDetailsCacheModel.candidateId = getCandidateId();

		professionalDetailsCacheModel.expectedSalary = getExpectedSalary();

		professionalDetailsCacheModel.currentSalary = getCurrentSalary();

		professionalDetailsCacheModel.skillSet = getSkillSet();

		String skillSet = professionalDetailsCacheModel.skillSet;

		if ((skillSet != null) && (skillSet.length() == 0)) {
			professionalDetailsCacheModel.skillSet = null;
		}

		professionalDetailsCacheModel.additionalInfo = getAdditionalInfo();

		String additionalInfo = professionalDetailsCacheModel.additionalInfo;

		if ((additionalInfo != null) && (additionalInfo.length() == 0)) {
			professionalDetailsCacheModel.additionalInfo = null;
		}

		professionalDetailsCacheModel.currentEmployer = getCurrentEmployer();

		String currentEmployer = professionalDetailsCacheModel.currentEmployer;

		if ((currentEmployer != null) && (currentEmployer.length() == 0)) {
			professionalDetailsCacheModel.currentEmployer = null;
		}

		professionalDetailsCacheModel.workType = getWorkType();

		String workType = professionalDetailsCacheModel.workType;

		if ((workType != null) && (workType.length() == 0)) {
			professionalDetailsCacheModel.workType = null;
		}

		professionalDetailsCacheModel.experience = getExperience();

		String experience = professionalDetailsCacheModel.experience;

		if ((experience != null) && (experience.length() == 0)) {
			professionalDetailsCacheModel.experience = null;
		}

		professionalDetailsCacheModel.qualification = getQualification();

		String qualification = professionalDetailsCacheModel.qualification;

		if ((qualification != null) && (qualification.length() == 0)) {
			professionalDetailsCacheModel.qualification = null;
		}

		professionalDetailsCacheModel.jobTitle = getJobTitle();

		String jobTitle = professionalDetailsCacheModel.jobTitle;

		if ((jobTitle != null) && (jobTitle.length() == 0)) {
			professionalDetailsCacheModel.jobTitle = null;
		}

		professionalDetailsCacheModel.companyId = getCompanyId();

		professionalDetailsCacheModel.userId = getUserId();

		return professionalDetailsCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ProfessionalDetails, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ProfessionalDetails, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProfessionalDetails, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(ProfessionalDetails)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<ProfessionalDetails, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<ProfessionalDetails, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProfessionalDetails, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((ProfessionalDetails)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, ProfessionalDetails>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private long _professionalDetailsId;
	private long _candidateId;
	private double _expectedSalary;
	private double _currentSalary;
	private String _skillSet;
	private String _additionalInfo;
	private String _currentEmployer;
	private String _workType;
	private String _experience;
	private String _qualification;
	private String _jobTitle;
	private long _companyId;
	private long _userId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<ProfessionalDetails, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((ProfessionalDetails)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put(
			"professionalDetailsId", _professionalDetailsId);
		_columnOriginalValues.put("candidateId", _candidateId);
		_columnOriginalValues.put("expectedSalary", _expectedSalary);
		_columnOriginalValues.put("currentSalary", _currentSalary);
		_columnOriginalValues.put("skillSet", _skillSet);
		_columnOriginalValues.put("additionalInfo", _additionalInfo);
		_columnOriginalValues.put("currentEmployer", _currentEmployer);
		_columnOriginalValues.put("workType", _workType);
		_columnOriginalValues.put("experience ", _experience);
		_columnOriginalValues.put("qualification", _qualification);
		_columnOriginalValues.put("jobTitle", _jobTitle);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("professionalDetailsId", 2L);

		columnBitmasks.put("candidateId", 4L);

		columnBitmasks.put("expectedSalary", 8L);

		columnBitmasks.put("currentSalary", 16L);

		columnBitmasks.put("skillSet", 32L);

		columnBitmasks.put("additionalInfo", 64L);

		columnBitmasks.put("currentEmployer", 128L);

		columnBitmasks.put("workType", 256L);

		columnBitmasks.put("experience ", 512L);

		columnBitmasks.put("qualification", 1024L);

		columnBitmasks.put("jobTitle", 2048L);

		columnBitmasks.put("companyId", 4096L);

		columnBitmasks.put("userId", 8192L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private ProfessionalDetails _escapedModel;

}