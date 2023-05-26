<%@ include file="../init.jsp"%>
<h1>Liferay Form Validation using AUI Form Validator</h1>
<aui:form name="fm2" id="fm2" action="" method="post">
	<aui:input name="userName" value='' label="User Name"></aui:input>
	<aui:input name="firstName" value='' label="First Name"></aui:input>
	<aui:input name="lastName" value='' label="Last Name"></aui:input>
	<aui:input name="email" value='' label="Email"></aui:input>
	<aui:input name="date" value='' label="Date of Birth"></aui:input>
	<aui:input name="phoneNumber" value='' label="Phone Number"></aui:input>
	<aui:input name="price" value='' label="Price Range"></aui:input>
	<aui:input name="password1" id="password1" value='' label="Password"
		type="password"></aui:input>
	<aui:input name="password2" value='' label="Re Type Password"
		type="password"></aui:input>
	<aui:input name="webSite" value='' label="Website Address"></aui:input>
	<aui:input name="age" value='' label="Age"></aui:input>
	<aui:button type="submit" name="numberSearch" value="Save" />
</aui:form>

<aui:script>

AUI().use('aui-base','aui-form-validator',function(A){

var DEFAULT_VALIDATOR=A.config.FormValidator;
A.mix(

DEFAULT_VALIDATOR.RULES,{
customRuleForAge:function(val,fieldNode,ruleValue){
var result=false;

if(val>18){
result=true;
}
return result;
},

},
true
);

A.mix(
DEFAULT_VALIDATOR.STRINGS,{
customRuleForAge:"Age should be more than 18",
},
true
);

var rules={
<portlet:namespace />userName:{
required:true,
alphanum:true
},
<portlet:namespace />firstName:{
required:true,
alpha:true

},
<portlet:namespace />lastName:{
alpha:true
},
<portlet:namespace />email:{
required:true,
email:true
},
<portlet:namespace />date:{
required:true,
date:true
},
<portlet:namespace />phoneNumber:{
required:true,
digits:true,
rangeLength:[8,10]
},
<portlet:namespace />price:{
required:true,
digits:true,
min:100,
max:500
},
<portlet:namespace />password1:{
required:true
},
<portlet:namespace />password2:{
equalTo:'#<portlet:namespace />password1',
required:true
},
<portlet:namespace />webSite:{
url:true
},
<portlet:namespace />age:{
customRuleForAge:true
}
};
  var fieldStrings = {
  <portlet:namespace />userName:{
  required:'Type Alpha numaric text	'
  }
  };
new A.FormValidator({
boundingBox:'#<portlet:namespace />fm2',
fieldStrings:fieldStrings,
rules:rules,
showAllMessages:true

});

});
</aui:script>