package cn.sichu.common.api;

import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 通用分页返回
 *
 * @author sichu
 * @date 2023/01/03
 **/
public class PageResult<T> {
    /**
     * 当前页码
     */
    private Integer pageNumber;

    /**
     * 每页数量
     */
    private Integer pageSize;

    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 总条数
     */
    private Long total;

    /**
     * 分页数据
     */
    private List<T> list;

    /**
     * 将 PageHelper 分页后的 List 转成分页信息
     * @param list PageHelper 分页后的 List
     * @param <T> 类型
     * @return 分页信息
     */
    public static <T> PageResult<T> resultPage(List<T> list) {
        PageResult<T> result = new PageResult<>();
        PageInfo<T> pageInfo = new PageInfo<>(list);
        result.setTotalPage(pageInfo.getPages());
        result.setPageNumber(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getList());
        return result;
    }

    /**
     * 将 SpringData 分页后的 Page 转成分页信息
     * @param pageInfo SpringData 分页后的 Page
     * @param <T> 类型
     * @return 分页信息
     */
    public static <T> PageResult<T> resultPage(Page<T> pageInfo) {
        PageResult<T> result = new PageResult<>();
        result.setTotalPage(pageInfo.getTotalPages());
        result.setPageNumber(pageInfo.getNumber());
        result.setPageSize(pageInfo.getSize());
        result.setTotal(pageInfo.getTotalElements());
        result.setList(pageInfo.getContent());
        return result;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
