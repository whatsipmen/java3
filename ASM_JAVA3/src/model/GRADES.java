
package model;


public class GRADES {
    private int ID;
    private String maSV;
    private int tiengAnh;
    private int tinHoc;
    private int gdTC;

    public GRADES() {
    }

    public GRADES(int ID, String maSV, int tiengAnh, int tinHoc, int gdTC) {
        this.ID = ID;
        this.maSV = maSV;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.gdTC = gdTC;
    }
    
    public GRADES ( String maSV, int tiengAnh, int tinHoc, int gdTC) {
        this.maSV = maSV;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.gdTC = gdTC;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public int getTiengAnh() {
        return tiengAnh;
    }

    public void setTiengAnh(int tiengAnh) {
        this.tiengAnh = tiengAnh;
    }

    public int getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(int tinHoc) {
        this.tinHoc = tinHoc;
    }

    public int getGdTC() {
        return gdTC;
    }

    public void setGdTC(int gdTC) {
        this.gdTC = gdTC;
    }

    
    
    
}
