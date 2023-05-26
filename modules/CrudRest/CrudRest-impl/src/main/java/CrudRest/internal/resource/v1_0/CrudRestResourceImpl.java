package CrudRest.internal.resource.v1_0;

import CrudRest.dto.v1_0.CrudRest;
import CrudRest.resource.v1_0.CrudRestResource;

import com.crud.service.service.CrudLocalServiceUtil;
import com.liferay.portal.events.CryptoStartupAction;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author DELL
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0/crud-rest.properties", scope = ServiceScope.PROTOTYPE, service = CrudRestResource.class)
public class CrudRestResourceImpl extends BaseCrudRestResourceImpl {
	

	@Override
	public Page<CrudRest> getCrudPage(@NotNull Long crudId) throws Exception {
		// TODO Auto-generated method stub
		List<CrudRest> crudRestList = new ArrayList<CrudRest>();
		com.crud.service.model.Crud crudMo = null;

		try {
			crudMo = CrudLocalServiceUtil.fetchCrud(crudId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (Validator.isNotNull(crudMo)) {
			CrudRest crudRests = new CrudRest();
			crudRests.setCrudId(crudMo.getCrudId());
			crudRests.setCrudName(crudMo.getCrudName());
			crudRests.setCrudNo(crudMo.getCrudNo());
			crudRestList.add(crudRests);
		}

		return Page.of(crudRestList);
	}

	@Override
	public CrudRest updateCrudPage(@NotNull Long crudId, CrudRest crudRest) throws Exception {
		// TODO Auto-generated method stub
		return super.updateCrudPage(crudId, crudRest);
	}

	@Override
	public CrudRest postCrudAdd(CrudRest crudRest) throws Exception {
		// TODO Auto-generated method stub
		return super.postCrudAdd(crudRest);
	}

	/*
	 * @Override public Page<CrudRest> updateCrudPage(@NotNull Long crudId, CrudRest
	 * crudRest) throws Exception { // TODO Auto-generated method stub
	 * 
	 * List<CrudRest> crudRestListupdate=new ArrayList<CrudRest>();
	 * com.crud.service.model.Crud crudMo = null; try {
	 * crudMo=CrudLocalServiceUtil.getCrud(crudId); }catch (Exception e) { // TODO:
	 * handle exception } if(Validator.isNotNull(crudMo)) { CrudRest cruds=new
	 * CrudRest(); cruds.setCrudId(crudMo.getCrudId());
	 * cruds.setCrudName(crudMo.getCrudName()); cruds.setCrudNo(crudMo.getCrudNo());
	 * crudRestListupdate.add(cruds); } return Page.of(crudRestListupdate); }
	 * 
	 * @Override public Page<CrudRest> postCrudAddPage( CrudRest crudRest) throws
	 * Exception { // TODO Auto-generated method stub List<CrudRest> crudRestList =
	 * new ArrayList<CrudRest>(); com.crud.service.model.Crud crudMo = null; try {
	 * crudMo = CrudLocalServiceUtil.createCrud(crudRest.getCrudId()); } catch
	 * (Exception e) { // TODO: handle exception } if (Validator.isNotNull(crudMo))
	 * { CrudRest crudRests = new CrudRest();
	 * crudRests.setCrudId(crudMo.getCrudId());
	 * crudRests.setCrudName(crudMo.getCrudName());
	 * crudRests.setCrudNo(crudMo.getCrudNo()); crudRestList.add(crudRests); }
	 * return Page.of(crudRestList); }
	 */



}