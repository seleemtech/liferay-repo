package com.Authenticate;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "Platform")
@Meta.OCD(
    id = "com.Authenticate.StudentRestAuthKey",
    localization = "content/Language",
    name = "student-rest-auth-key"
)
public interface StudentRestAuthKey {

    @Meta.AD(deflt = "", name = "Auth Key", required = false)
    public String getAuthenticationKey();
}