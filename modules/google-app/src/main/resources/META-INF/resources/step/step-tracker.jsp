<%@ include file="../init.jsp" %>
<%
    GoogleAppDisplayContext formIntegrationDisplayContextdd = new GoogleAppDisplayContext(renderRequest, renderResponse);
    String pageName = (String) request.getAttribute("pageName");
    String firstAppName = ParamUtil.getString(renderRequest,"firstAppName");
    String secondAppName = ParamUtil.getString(renderRequest,"secondAppName");

%>

<div class="step-tracker-root lfr-tooltip-scope" id="lveh___step-tracker-id">
    <div class="rounded step-tracker">
        <%
            boolean complete = true;
            List<CustomStepModel> multiSteps = formIntegrationDisplayContextdd.getMultiSteps(firstAppName,secondAppName);
            Iterator<CustomStepModel> commerceCheckoutStepIterator = multiSteps.iterator();
            while (commerceCheckoutStepIterator.hasNext()) {
                CustomStepModel multiStep = commerceCheckoutStepIterator.next();
                String name = multiStep.getPageName();
                String cssClass = "step";
                if (pageName.equals(name)) {
                    cssClass += " active";
                    complete = false;
                }
                if (complete) {
                    cssClass += " completed";
                }
        %>

        <div class="<%= cssClass %>"><span class="step-label"> <liferay-ui:message
                key="<%= HtmlUtil.escape(multiStep.getAppName()) %>"/>
            <c:if test="<%=cssClass.contains("completed")%>">
                <svg class="lexicon-icon lexicon-icon-check ml-3" role="presentation">
                <use href="http://localhost:8080/o/classic-theme/images/clay/icons.svg#check"></use></svg>
            </c:if>
        </span></div>
        <%
            }
        %>
    </div>
</div>
