package com.sys.config.file;


import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import java.util.List;

import aQute.bnd.annotation.metatype.Meta;

/**
 * @author Habeeb Shaik
 */

@ExtendedObjectClassDefinition(category = "users-admin")
@Meta.OCD(
    id = "com.sys.config.file.UsersKeyContactEmailConfiguration",
    localization = "content/Language",
    name = "key-contact-Email-configuration"
)

public interface UsersKeyContactEmailConfiguration {
    
    @Meta.AD(
        deflt = "upp-emea",
        //cardinality = Integer.MAX_VALUE,
        description = "key-contact-mail-description",
        name = "upp-emea-key-email", required = false
    )
    public List<String> getUppEmeaKeyContactEmails();
    
    @Meta.AD(
        deflt = "upp-apj",
        //cardinality = Integer.MAX_VALUE,
        description = "key-contact-mail-description",
        name = "upp-apj-key-email", required = false
    )
    public List<String> getUppApjKeyContactEmails();
    
    @Meta.AD(
        deflt = "upp-na",
        //cardinality = Integer.MAX_VALUE,
        description = "key-contact-mail-description",
        name = "upp-na-key-email", required = false
    )
    public List<String> getUppNaKeyContactEmails();
    
    @Meta.AD(
        deflt = "upp-lar",
        //cardinality = Integer.MAX_VALUE,
        description = "key-contact-email-description",
        name = "upp-lar-key-email", required = false
    )
    public List<String> getUppLarKeyContactEmails();
    
}
