package cn.estore.dao;

import cn.estore.entity.ProductEntity;
import cn.estore.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private Connection connection = null; // 定义连接的对象
    private PreparedStatement ps = null; // 定义预准备的对象
    private DBConnection jdbc = null; // 定义数据库连接对象

    public ProductDao() {
        jdbc = new DBConnection();
        connection = jdbc.connection;
    }

    /*
     *查询所有商品
     */
    public List selectAllProducts() {
        List list = new ArrayList();

        try {
            ps = connection.prepareStatement("select * from tb_product order by id DESC");

            ResultSet rs = ps.executeQuery();  //执行查询结果
            list = Rs2List(rs);
        } catch (SQLException ex) {
            System.out.println("数据库访问失败:查询所有商品");
        }

        //返回list
        return list;
    }

    /*
     *查询特价或新品商品
     */
    public List selectProductsDiscount(int count) {
        List list = new ArrayList();

        try {
            ps = connection
                    .prepareStatement("select * from tb_product where discount=? order by id DESC");
            ps.setInt(1, count);
            ResultSet rs = ps.executeQuery();  //执行查询结果
            list = Rs2List(rs);

        } catch (SQLException ex) {
            System.out.println("数据库访问失败:查询所有商品");
        }

        //返回list
        return list;
    }

    /*
     *按名称搜索商品
     */
    public List<ProductEntity> selectProductsByName(String name) {
        List<ProductEntity> list = new ArrayList<ProductEntity>();
        String sql = "select * from tb_product where name like ?";


        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();

            list = Rs2List(rs);

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("数据库访问失败：查询所有商品");
        }

        return list;
    }

    /*
     *查询tb_Product表所有字段的方法
     */
    public List Rs2List(ResultSet rs) {
        List list = new ArrayList();
        ProductEntity e = null;
        try {
            while (rs.next()) {

                e = new ProductEntity();//封装对象

                e.setId(rs.getInt(1));
                e.setCategoryMainId(rs.getInt(2));
                e.setCategoryBranchId(rs.getInt(3));
                e.setName(rs.getString(4));
                e.setProducingArea(rs.getString(5));
                e.setDescription(rs.getString(6));
                e.setCreateTime(rs.getString(7));
                e.setMarketPrice(rs.getFloat(8));
                e.setSellPrice(rs.getFloat(9));
                e.setProductCount(rs.getInt(10));
                e.setPicture(rs.getString(11));
                e.setDiscount(rs.getInt(12));

                //将对象保存到list中
                list.add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

}
