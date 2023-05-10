package imqa.dashboard.vo;

public class ScenarioVo {

//    String scenarioId;
    String screen;
    String element;
    String actionName;
    String params;

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "ScenarioVo{" +
                "screen='" + screen + '\'' +
                ", element='" + element + '\'' +
                ", actionName='" + actionName + '\'' +
                ", params='" + params + '\'' +
                '}';
    }
}
