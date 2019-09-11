package com.jade.bean;

import com.jade.sql.sqlTool;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

//public class PageObject {
//}
public class PageObject<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 当前页的页码值 */
    private Integer currentPage = 1;
    /** 页面大小 */
    private Integer limit = 10;
    /** 总行数(通过查询获得) */
    private Integer totalCount = 0;
    /** 总页数(通过计算获得) */
    private Integer pageCount = 0;
    /** 当前页记录 */
    private List<T> records;
    /**当前页数据**/
    private Vector<HashMap<String,String>> data;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }


    public Integer getPageCount() {
        pageCount = totalCount / limit;
        if (totalCount % limit != 0) {
            pageCount++;
        }
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public Vector<HashMap<String,String>> getData() {
        return data;
    }

    public void setData(Vector<HashMap<String,String>> data) {
        this.data = data;
    }

    //自行设置
    public PageObject(int currentPage,int limit,Vector<HashMap<String,String>> data){
        this.setLimit(limit);
        this.setCurrentPage(currentPage);
        this.setData(data);
    }

    //分页
    public Vector<HashMap<String,String>> queryPage(){
        Vector<HashMap<String,String>> vector = this.getData();
        int start, end;
        this.setTotalCount(vector.size());
        start = (this.getCurrentPage() - 1) * this.getLimit() ;
        //判断当前显示的数据是否足以显示一整页，也就是是不是最后一页
        if(start + this.getLimit() > this.getTotalCount()) {
            end = this.getTotalCount();
        } else {
            end = start + this.getLimit();
        }
        Vector<HashMap<String,String>> currentVector = new Vector<>();
        //循环得到每一页的数据
        System.out.println("start"+end);
        for(int i = start; i < end; i++) {
            currentVector.add(vector.get(i));
        }


        return currentVector;
    }
    @Override
    public String toString() {
        return "PageObject [pageCurrent=" + currentPage + ", pageSize=" + limit + ", rowCount=" + totalCount
                + ", pageCount=" + pageCount + ", records=" + records + "]";
    }




    public static void main(String[] args){

    Vector<HashMap<String,String>> vector = new Vector<>();
        sqlTool.getTripArticle(vector);

        @SuppressWarnings("unchecked")

        //输入当前页6，返回第6页面内容的一个子表表，subList 传到前端JSP进行显示
         Vector<HashMap<String,String>> currentVector = new Vector<>();
//        PageObject page = new PageObject();
//        page.setCurrentPage(1);
//        page.setLimit(10);
//        currentVector = page.queryPage(vector);

        for (int j = 0; j < currentVector.size(); j++) {
            System.out.println(currentVector.get(j).get("id"));
        }
    }

}
