package com.stealthkart.headless.internal.resource.v1_0;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;
import com.stealthkart.headless.dto.v1_0.Instance;
import com.stealthkart.headless.resource.v1_0.InstanceResource;

import com.stealthkart.store.instance.impl.service.InstanceLocalServiceUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.ArrayList;
import java.util.List;

/**
 * @author E2Software-011
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/instance.properties",
	scope = ServiceScope.PROTOTYPE, service = InstanceResource.class
)
public class InstanceResourceImpl extends BaseInstanceResourceImpl {
	@Override
	public Page<Instance> getInstancePage(Long companyId) throws Exception {

		List<Instance> instanceList = new ArrayList<Instance>();

		com.stealthkart.store.instance.impl.model.Instance instanceModel= null;

		try{

			instanceModel = InstanceLocalServiceUtil.fetchInstance(companyId);
		}catch (Exception e){

		}
if (Validator.isNotNull(instanceModel)){
	Instance ins =new Instance();
	/*ins.setCompanyId(instanceModel.getCompanyId());*/
	ins.setInstanceName(instanceModel.getInstanceName());
	ins.setEmailAddress(instanceModel.getEmailAddress());
	instanceList.add(ins);

}

		return Page.of(instanceList);
	}

}