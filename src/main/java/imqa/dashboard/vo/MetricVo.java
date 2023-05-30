package imqa.dashboard.vo;

public class MetricVo {

    String metricId;
    String bigScreen;
    String smallScreen;
    String testTarget;
    String testSummary;
    String cssSelect;


    public String getMetricId() {
        return metricId;
    }

    public void setMetricId(String metricId) {
        this.metricId = metricId;
    }

    public String getBigScreen() {
        return bigScreen;
    }

    public void setBigScreen(String bigScreen) {
        this.bigScreen = bigScreen;
    }

    public String getSmallScreen() {
        return smallScreen;
    }

    public void setSmallScreen(String smallScreen) {
        this.smallScreen = smallScreen;
    }

    public String getTestTarget() {
        return testTarget;
    }

    public void setTestTarget(String testTarget) {
        this.testTarget = testTarget;
    }

    public String getTestSummary() {
        return testSummary;
    }

    public void setTestSummary(String testSummary) {
        this.testSummary = testSummary;
    }

    public String getCssSelect() {
        return cssSelect;
    }

    public void setCssSelect(String cssSelect) {
        this.cssSelect = cssSelect;
    }

    @Override
    public String toString() {
        return "MetricVo{" +
                "metricId='" + metricId + '\'' +
                ", bigScreen='" + bigScreen + '\'' +
                ", smallScreen='" + smallScreen + '\'' +
                ", testTarget='" + testTarget + '\'' +
                ", testSummary='" + testSummary + '\'' +
                ", cssSelect='" + cssSelect + '\'' +
                '}';
    }
}
