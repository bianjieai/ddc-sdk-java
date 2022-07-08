package ai.bianjie.ddc.module.nft;

import java.util.List;

public class QueryOwnerResp {
    private String address;
    private List<IDC> idcs;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<IDC> getIdcs() {
        return idcs;
    }

    public void setIdcs(List<IDC> idcs) {
        this.idcs = idcs;
    }
}
