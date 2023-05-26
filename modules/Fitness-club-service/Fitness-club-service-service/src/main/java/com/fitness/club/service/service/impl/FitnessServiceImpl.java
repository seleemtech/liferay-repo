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

package com.fitness.club.service.service.impl;

import com.fitness.club.service.model.Fitness;
import com.fitness.club.service.service.base.FitnessServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.net.URLDecoder;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=foo",
		"json.web.service.context.path=Fitness"
	},
	service = AopService.class
)
public class FitnessServiceImpl extends FitnessServiceBaseImpl {
	public Fitness add(String trainerName,String gender,long age,long experiance,String Type,long conNumber,long image) {
		long trainerId =counterLocalService.increment();
		Fitness fit=fitnessLocalService.createFitness(trainerId);
		fit.setTrainerName(trainerName);
		fit.setGender(gender);
		fit.setAge(age);
		fit.setExperiance(experiance);
		fit.setType(Type);
		fit.setConNumber(conNumber);
		fit.setImage(image);
		fitnessPersistence.update(fit);
		return fit;
		
	}
	
	public Fitness addFitness(String params) {
		JSONObject jobject=null;
		try {
			jobject =JSONFactoryUtil.createJSONObject(URLDecoder.decode(params));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long trainerId =counterLocalService.increment();
		Fitness fits=fitnessLocalService.createFitness(trainerId);
		fits.setTrainerName(jobject.getString("trainerName"));
		fits.setGender(jobject.getString("gender"));
		fits.setAge(jobject.getInt("age"));
		fits.setExperiance(jobject.getLong("experiance"));
		fits.setConNumber(jobject.getLong("conNumber"));
		fits.setType(jobject.getString("Type"));
		fitnessLocalService.addFitness(fits);
		return(fits);
	}
	public Fitness updateFitness(long trainerId,String params) throws PortalException {
		JSONObject jobject=null;
		try {
			jobject =JSONFactoryUtil.createJSONObject(URLDecoder.decode(params));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Fitness fitss=fitnessLocalService.getFitness(trainerId);
		fitss.setTrainerName(jobject.getString("trainerName"));
		fitss.setGender(jobject.getString("gender"));
		fitss.setAge(jobject.getInt("age"));
		fitss.setExperiance(jobject.getLong("experiance"));
		fitss.setConNumber(jobject.getLong("conNumber"));
		fitss.setType(jobject.getString("Type"));
		fitnessLocalService.updateFitness(fitss);
		return(fitss);
	}
	
	public void delteFitness(long trainerId) throws PortalException {
		fitnessLocalService.deleteFitness(trainerId);
	}
	public List<Fitness> getFitnesses(){
		return fitnessLocalService.getFitnesses(-1, -1);
	}

	
}