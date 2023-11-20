package org.lanqiao.pojo;

public class Ordersdetail {
    private long did;
    private int num;
    private double price;
    private Orders oid;
    private Books bid;

    @Override
    public String toString() {
        return "Ordersdetail{" +
                "did=" + did +
                ", num=" + num +
                ", price=" + price +
                ", oid=" + oid +
                ", bid=" + bid +
                '}';
    }

    public long getDid() {
        return did;
    }

    public void setDid(long did) {
        this.did = did;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Orders getOid() {
        return oid;
    }

    public void setOid(Orders oid) {
        this.oid = oid;
    }

    public Books getBid() {
        return bid;
    }

    public void setBid(Books bid) {
        this.bid = bid;
    }

    public Ordersdetail() {
    }

    public Ordersdetail(long did, int num, double price, Orders oid, Books bid) {
        this.did = did;
        this.num = num;
        this.price = price;
        this.oid = oid;
        this.bid = bid;
    }
}
