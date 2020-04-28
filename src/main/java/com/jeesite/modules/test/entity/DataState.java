package com.jeesite.modules.test.entity;

/**
 * @author fulunyong
 * @email fulunyong@126.com
 * @time 2018/10/11 13:53
 * @package com.changbei.v3.types
 * @Description: [描述信息 ]
 * @Version: [3.0]
 * @Copy: [com.changbei]
 */
public enum DataState {
    /**
     * 正常
     */
    NORMAL(0),
    /**
     * 审核中
     */
    AUDIT(1),
    /**
     * 显示
     */
    SHOW(2),
    /**
     * 隐藏
     */
    HIDE(3),
    /**
     * 已删除
     */
    DELETE(4);

    private int code;

    DataState(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
