package com.jeesite.modules.deng.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @author deng
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @date 2020/4/24 16:58
 */
public class SchoolVO {
    @Excel(name="名称")
    private String schedName;
    @Excel(name="校长名")
    private String triggerName;
    @Excel(name="地址")
    private String triggerGroup;
    @Excel(name="类型",replace = { "男_1", "女_2" })
    private String sType;
    @Excel(name="日期",databaseFormat = "yyyy-MM-dd HH:mm:ss",format = "yyyy-MM-dd")
    private String date;

    public SchoolVO() {
    }

    public String getSchedName() {
        return schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    public String getsType() {
        return sType;
    }

    public void setsType(String sType) {
        this.sType = sType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
