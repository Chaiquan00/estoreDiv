package cn.estore.entity;

public class ProductEntity {
    private int id;     //自增编号
    private int categoryMainId;   //大类编号category_main_id
    private int categoryBranchId; //小类编号category_branch_id
    private String Name;            //商品名称
    private String producingArea;     //商品产地producing_area
    private String description;    //商品描述
    private String createTime;   //商品创建时间
    private float marketPrice;   //原价 market_price
    private float sellPrice;     //商品实际促销价格
    private int productCount;    //商品销售数量，不是商品库存，需要在后期数据库中增加库存字段
    private String picture;     //商品图片
    private int discount;      //是否有折扣 1有折扣，0无折扣

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryMainId() {
        return categoryMainId;
    }

    public void setCategoryMainId(int categoryMainId) {
        this.categoryMainId = categoryMainId;
    }

    public int getCategoryBranchId() {
        return categoryBranchId;
    }

    public void setCategoryBranchId(int categoryBranchId) {
        this.categoryBranchId = categoryBranchId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getProducingArea() {
        return producingArea;
    }

    public void setProducingArea(String producingArea) {
        this.producingArea = producingArea;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public float getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(float marketPrice) {
        this.marketPrice = marketPrice;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
