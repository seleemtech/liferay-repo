package com.crud.service.service.persistence.impl;

import com.crud.service.model.Crud;
import com.crud.service.model.impl.CrudImpl;
import com.crud.service.service.persistence.CrudFinder;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = CrudFinder.class)
public class CrudFinderImpl extends CrudFinderBaseImpl implements CrudFinder {


	@Reference
	private CustomSQL _customSQL;
public List<Crud> getByCrudNameAndCrudNo(String crudName,long crudNo)
{
	Session session=null;
	try
	{
		session=openSession();
		String sql=_customSQL.get(getClass(), "getByCrudNameAndCrudNo");
		System.out.println("SQl======>"+sql);
		SQLQuery sqlQuery=session.createSQLQuery(sql);
		sqlQuery.setCacheable(false);
		sqlQuery.addEntity("Crud",CrudImpl.class);
		QueryPos queryPos=QueryPos.getInstance(sqlQuery);
		queryPos.add(crudName);
		queryPos.add(crudNo);
		return (List<Crud>)sqlQuery.list();
		
	}catch (Exception e) {
		// TODO: handle exception
	}
	finally {
		closeSession(session);
	}
	return null;
}
}
