package BLL;

import java.io.IOException;

public interface bll_ConNguoi {
    public void them(Object object) throws IOException;
    public void sua(Object object, int i) throws IOException;
    public void xoa( int i) throws IOException;
    public void TroLai();
}
