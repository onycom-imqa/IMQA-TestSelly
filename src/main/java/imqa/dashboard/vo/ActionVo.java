package imqa.dashboard.vo;

public class ActionVo {

    String ActionName;
    String ActionCode;
    String Desc;


    public String getActionName() {
        return ActionName;
    }

    public void setActionName(String actionName) {
        ActionName = actionName;
    }

    public String getActionCode() {
        return ActionCode;
    }

    public void setActionCode(String actionCode) {
        ActionCode = actionCode;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    @Override
    public String toString() {
        return "ActionVo{" +
                "ActionName='" + ActionName + '\'' +
                ", ActionCode='" + ActionCode + '\'' +
                ", Desc='" + Desc + '\'' +
                '}';
    }
}
