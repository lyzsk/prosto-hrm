package cn.sichu.common.api;

import java.util.List;

/**
 * 通用分页返回
 * <p>
 * {
 * "success": "成功",
 * "code": 200,
 * "message": "ok",
 * "data": {
 * total: [总条数]
 * rows: 数据列表
 * }
 * }
 *
 * @author sichu
 * @date 2023/01/03
 **/
public class PageResult<T> {
    private Long total;

    private List<T> rows;

    public PageResult() {
    }

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageResult{" + "total=" + total + ", rows=" + rows + '}';
    }
}
