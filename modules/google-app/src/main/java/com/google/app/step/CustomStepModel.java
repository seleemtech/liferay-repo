package com.google.app.step;

public class CustomStepModel {

    public String getIndex() {
        return _index;
    }

    public String getPageName() {
        return _pageName;
    }

    public String getAppName() {
        return _appName;
    }

    public void setIndex(String index) {
        _index = index;
    }

    public void setPageName(String pageName) {
        _pageName = pageName;
    }

    public void setAppName(String appName) {
        _appName = appName;
    }

    private String _index;
    private String _pageName;
    private String _appName;

}