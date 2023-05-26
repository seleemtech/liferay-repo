package appointments.internal.resource.v1_0;


import appointments.dto.v1_0.Appoinment;
import appointments.resource.v1_0.AppoinmentResource;

import com.liferay.portal.vulcan.pagination.Page;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author DELL
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/appoinment.properties",
	scope = ServiceScope.PROTOTYPE, service = AppoinmentResource.class
)
public class AppoinmentResourceImpl extends BaseAppoinmentResourceImpl {

	@Override
	public Page<Appoinment> getSiteAppointmentsPage(@NotNull Long siteId) throws Exception {
		// TODO Auto-generated method stub
		List<Appoinment> appointmentList= new ArrayList<>(10);
		for(int i=0;i<10;i++) {
			Appoinment appointment=new Appoinment();
			appointment.setId((long)i );
			appointment.setTitle("Title"+i);
			appointment.setDate(new Date());
			appointmentList.add(appointment);
			
		}
		return Page.of(appointmentList);
	}
}