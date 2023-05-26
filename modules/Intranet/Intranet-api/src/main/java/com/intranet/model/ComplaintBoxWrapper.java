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

package com.intranet.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ComplaintBox}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ComplaintBox
 * @generated
 */
public class ComplaintBoxWrapper
	extends BaseModelWrapper<ComplaintBox>
	implements ComplaintBox, ModelWrapper<ComplaintBox> {

	public ComplaintBoxWrapper(ComplaintBox complaintBox) {
		super(complaintBox);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("fooId", getFooId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("userName", getUserName());
		attributes.put("posistionType", getPosistionType());
		attributes.put("submittedDate", getSubmittedDate());
		attributes.put("question1", getQuestion1());
		attributes.put("question2", getQuestion2());
		attributes.put("question3", getQuestion3());
		attributes.put("question4", getQuestion4());
		attributes.put("question5", getQuestion5());
		attributes.put("question6", getQuestion6());
		attributes.put("question7", getQuestion7());
		attributes.put("question8", getQuestion8());
		attributes.put("question9", getQuestion9());
		attributes.put("question10", getQuestion10());
		attributes.put("question11", getQuestion11());
		attributes.put("question12", getQuestion12());
		attributes.put("question13", getQuestion13());
		attributes.put("question14", getQuestion14());
		attributes.put("question15", getQuestion15());
		attributes.put("description1", getDescription1());
		attributes.put("description2", getDescription2());
		attributes.put("description3", getDescription3());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long fooId = (Long)attributes.get("fooId");

		if (fooId != null) {
			setFooId(fooId);
		}

		String employeeId = (String)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		String posistionType = (String)attributes.get("posistionType");

		if (posistionType != null) {
			setPosistionType(posistionType);
		}

		Date submittedDate = (Date)attributes.get("submittedDate");

		if (submittedDate != null) {
			setSubmittedDate(submittedDate);
		}

		Integer question1 = (Integer)attributes.get("question1");

		if (question1 != null) {
			setQuestion1(question1);
		}

		Integer question2 = (Integer)attributes.get("question2");

		if (question2 != null) {
			setQuestion2(question2);
		}

		Integer question3 = (Integer)attributes.get("question3");

		if (question3 != null) {
			setQuestion3(question3);
		}

		Integer question4 = (Integer)attributes.get("question4");

		if (question4 != null) {
			setQuestion4(question4);
		}

		Integer question5 = (Integer)attributes.get("question5");

		if (question5 != null) {
			setQuestion5(question5);
		}

		Integer question6 = (Integer)attributes.get("question6");

		if (question6 != null) {
			setQuestion6(question6);
		}

		Integer question7 = (Integer)attributes.get("question7");

		if (question7 != null) {
			setQuestion7(question7);
		}

		Integer question8 = (Integer)attributes.get("question8");

		if (question8 != null) {
			setQuestion8(question8);
		}

		Integer question9 = (Integer)attributes.get("question9");

		if (question9 != null) {
			setQuestion9(question9);
		}

		Integer question10 = (Integer)attributes.get("question10");

		if (question10 != null) {
			setQuestion10(question10);
		}

		Integer question11 = (Integer)attributes.get("question11");

		if (question11 != null) {
			setQuestion11(question11);
		}

		Integer question12 = (Integer)attributes.get("question12");

		if (question12 != null) {
			setQuestion12(question12);
		}

		Integer question13 = (Integer)attributes.get("question13");

		if (question13 != null) {
			setQuestion13(question13);
		}

		Integer question14 = (Integer)attributes.get("question14");

		if (question14 != null) {
			setQuestion14(question14);
		}

		Integer question15 = (Integer)attributes.get("question15");

		if (question15 != null) {
			setQuestion15(question15);
		}

		String description1 = (String)attributes.get("description1");

		if (description1 != null) {
			setDescription1(description1);
		}

		String description2 = (String)attributes.get("description2");

		if (description2 != null) {
			setDescription2(description2);
		}

		String description3 = (String)attributes.get("description3");

		if (description3 != null) {
			setDescription3(description3);
		}
	}

	@Override
	public ComplaintBox cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the description1 of this complaint box.
	 *
	 * @return the description1 of this complaint box
	 */
	@Override
	public String getDescription1() {
		return model.getDescription1();
	}

	/**
	 * Returns the description2 of this complaint box.
	 *
	 * @return the description2 of this complaint box
	 */
	@Override
	public String getDescription2() {
		return model.getDescription2();
	}

	/**
	 * Returns the description3 of this complaint box.
	 *
	 * @return the description3 of this complaint box
	 */
	@Override
	public String getDescription3() {
		return model.getDescription3();
	}

	/**
	 * Returns the employee ID of this complaint box.
	 *
	 * @return the employee ID of this complaint box
	 */
	@Override
	public String getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the foo ID of this complaint box.
	 *
	 * @return the foo ID of this complaint box
	 */
	@Override
	public long getFooId() {
		return model.getFooId();
	}

	/**
	 * Returns the posistion type of this complaint box.
	 *
	 * @return the posistion type of this complaint box
	 */
	@Override
	public String getPosistionType() {
		return model.getPosistionType();
	}

	/**
	 * Returns the primary key of this complaint box.
	 *
	 * @return the primary key of this complaint box
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the question1 of this complaint box.
	 *
	 * @return the question1 of this complaint box
	 */
	@Override
	public int getQuestion1() {
		return model.getQuestion1();
	}

	/**
	 * Returns the question10 of this complaint box.
	 *
	 * @return the question10 of this complaint box
	 */
	@Override
	public int getQuestion10() {
		return model.getQuestion10();
	}

	/**
	 * Returns the question11 of this complaint box.
	 *
	 * @return the question11 of this complaint box
	 */
	@Override
	public int getQuestion11() {
		return model.getQuestion11();
	}

	/**
	 * Returns the question12 of this complaint box.
	 *
	 * @return the question12 of this complaint box
	 */
	@Override
	public int getQuestion12() {
		return model.getQuestion12();
	}

	/**
	 * Returns the question13 of this complaint box.
	 *
	 * @return the question13 of this complaint box
	 */
	@Override
	public int getQuestion13() {
		return model.getQuestion13();
	}

	/**
	 * Returns the question14 of this complaint box.
	 *
	 * @return the question14 of this complaint box
	 */
	@Override
	public int getQuestion14() {
		return model.getQuestion14();
	}

	/**
	 * Returns the question15 of this complaint box.
	 *
	 * @return the question15 of this complaint box
	 */
	@Override
	public int getQuestion15() {
		return model.getQuestion15();
	}

	/**
	 * Returns the question2 of this complaint box.
	 *
	 * @return the question2 of this complaint box
	 */
	@Override
	public int getQuestion2() {
		return model.getQuestion2();
	}

	/**
	 * Returns the question3 of this complaint box.
	 *
	 * @return the question3 of this complaint box
	 */
	@Override
	public int getQuestion3() {
		return model.getQuestion3();
	}

	/**
	 * Returns the question4 of this complaint box.
	 *
	 * @return the question4 of this complaint box
	 */
	@Override
	public int getQuestion4() {
		return model.getQuestion4();
	}

	/**
	 * Returns the question5 of this complaint box.
	 *
	 * @return the question5 of this complaint box
	 */
	@Override
	public int getQuestion5() {
		return model.getQuestion5();
	}

	/**
	 * Returns the question6 of this complaint box.
	 *
	 * @return the question6 of this complaint box
	 */
	@Override
	public int getQuestion6() {
		return model.getQuestion6();
	}

	/**
	 * Returns the question7 of this complaint box.
	 *
	 * @return the question7 of this complaint box
	 */
	@Override
	public int getQuestion7() {
		return model.getQuestion7();
	}

	/**
	 * Returns the question8 of this complaint box.
	 *
	 * @return the question8 of this complaint box
	 */
	@Override
	public int getQuestion8() {
		return model.getQuestion8();
	}

	/**
	 * Returns the question9 of this complaint box.
	 *
	 * @return the question9 of this complaint box
	 */
	@Override
	public int getQuestion9() {
		return model.getQuestion9();
	}

	/**
	 * Returns the submitted date of this complaint box.
	 *
	 * @return the submitted date of this complaint box
	 */
	@Override
	public Date getSubmittedDate() {
		return model.getSubmittedDate();
	}

	/**
	 * Returns the user name of this complaint box.
	 *
	 * @return the user name of this complaint box
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the description1 of this complaint box.
	 *
	 * @param description1 the description1 of this complaint box
	 */
	@Override
	public void setDescription1(String description1) {
		model.setDescription1(description1);
	}

	/**
	 * Sets the description2 of this complaint box.
	 *
	 * @param description2 the description2 of this complaint box
	 */
	@Override
	public void setDescription2(String description2) {
		model.setDescription2(description2);
	}

	/**
	 * Sets the description3 of this complaint box.
	 *
	 * @param description3 the description3 of this complaint box
	 */
	@Override
	public void setDescription3(String description3) {
		model.setDescription3(description3);
	}

	/**
	 * Sets the employee ID of this complaint box.
	 *
	 * @param employeeId the employee ID of this complaint box
	 */
	@Override
	public void setEmployeeId(String employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the foo ID of this complaint box.
	 *
	 * @param fooId the foo ID of this complaint box
	 */
	@Override
	public void setFooId(long fooId) {
		model.setFooId(fooId);
	}

	/**
	 * Sets the posistion type of this complaint box.
	 *
	 * @param posistionType the posistion type of this complaint box
	 */
	@Override
	public void setPosistionType(String posistionType) {
		model.setPosistionType(posistionType);
	}

	/**
	 * Sets the primary key of this complaint box.
	 *
	 * @param primaryKey the primary key of this complaint box
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the question1 of this complaint box.
	 *
	 * @param question1 the question1 of this complaint box
	 */
	@Override
	public void setQuestion1(int question1) {
		model.setQuestion1(question1);
	}

	/**
	 * Sets the question10 of this complaint box.
	 *
	 * @param question10 the question10 of this complaint box
	 */
	@Override
	public void setQuestion10(int question10) {
		model.setQuestion10(question10);
	}

	/**
	 * Sets the question11 of this complaint box.
	 *
	 * @param question11 the question11 of this complaint box
	 */
	@Override
	public void setQuestion11(int question11) {
		model.setQuestion11(question11);
	}

	/**
	 * Sets the question12 of this complaint box.
	 *
	 * @param question12 the question12 of this complaint box
	 */
	@Override
	public void setQuestion12(int question12) {
		model.setQuestion12(question12);
	}

	/**
	 * Sets the question13 of this complaint box.
	 *
	 * @param question13 the question13 of this complaint box
	 */
	@Override
	public void setQuestion13(int question13) {
		model.setQuestion13(question13);
	}

	/**
	 * Sets the question14 of this complaint box.
	 *
	 * @param question14 the question14 of this complaint box
	 */
	@Override
	public void setQuestion14(int question14) {
		model.setQuestion14(question14);
	}

	/**
	 * Sets the question15 of this complaint box.
	 *
	 * @param question15 the question15 of this complaint box
	 */
	@Override
	public void setQuestion15(int question15) {
		model.setQuestion15(question15);
	}

	/**
	 * Sets the question2 of this complaint box.
	 *
	 * @param question2 the question2 of this complaint box
	 */
	@Override
	public void setQuestion2(int question2) {
		model.setQuestion2(question2);
	}

	/**
	 * Sets the question3 of this complaint box.
	 *
	 * @param question3 the question3 of this complaint box
	 */
	@Override
	public void setQuestion3(int question3) {
		model.setQuestion3(question3);
	}

	/**
	 * Sets the question4 of this complaint box.
	 *
	 * @param question4 the question4 of this complaint box
	 */
	@Override
	public void setQuestion4(int question4) {
		model.setQuestion4(question4);
	}

	/**
	 * Sets the question5 of this complaint box.
	 *
	 * @param question5 the question5 of this complaint box
	 */
	@Override
	public void setQuestion5(int question5) {
		model.setQuestion5(question5);
	}

	/**
	 * Sets the question6 of this complaint box.
	 *
	 * @param question6 the question6 of this complaint box
	 */
	@Override
	public void setQuestion6(int question6) {
		model.setQuestion6(question6);
	}

	/**
	 * Sets the question7 of this complaint box.
	 *
	 * @param question7 the question7 of this complaint box
	 */
	@Override
	public void setQuestion7(int question7) {
		model.setQuestion7(question7);
	}

	/**
	 * Sets the question8 of this complaint box.
	 *
	 * @param question8 the question8 of this complaint box
	 */
	@Override
	public void setQuestion8(int question8) {
		model.setQuestion8(question8);
	}

	/**
	 * Sets the question9 of this complaint box.
	 *
	 * @param question9 the question9 of this complaint box
	 */
	@Override
	public void setQuestion9(int question9) {
		model.setQuestion9(question9);
	}

	/**
	 * Sets the submitted date of this complaint box.
	 *
	 * @param submittedDate the submitted date of this complaint box
	 */
	@Override
	public void setSubmittedDate(Date submittedDate) {
		model.setSubmittedDate(submittedDate);
	}

	/**
	 * Sets the user name of this complaint box.
	 *
	 * @param userName the user name of this complaint box
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	@Override
	protected ComplaintBoxWrapper wrap(ComplaintBox complaintBox) {
		return new ComplaintBoxWrapper(complaintBox);
	}

}