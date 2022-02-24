package entity;

/**
 * @author mo7984130
 * @Classname Book
 * @Description TODO
 * @Date 2022/2/12 11:14 下午
 */
public class Book {

    private static final String DATABASE = "book";

    private int id;

    private String bookName;

    private String owner;

    private String addTime;

    private String type;

    private String borrower;

    private String lendTime;

    private String returnTime;

    private String remark;

    private int isAvailable;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getLendTime() {
        return lendTime;
    }

    public void setLendTime(String lendTime) {
        this.lendTime = lendTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public boolean isAvailable() {
        return isAvailable == 0;
    }

    public void setAvailable(int available) {
        isAvailable = available;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        if (remark == null){
            remark = "无";
        }
        this.remark = remark;
    }
}
