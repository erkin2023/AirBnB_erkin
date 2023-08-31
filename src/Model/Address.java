package Model;

public class Address {
    private int idAddress;
    private String province;
    private String region;
    private String address;

    public Address(String province, String region, String address) {
        if (province == null || province.isEmpty()) {
            throw new IllegalArgumentException("Province cannot be null or empty");
        }
        if (region == null || region.isEmpty()) {
            throw new IllegalArgumentException("Region cannot be null or empty");
        }
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }

        this.province = province;
        this.region = region;
        this.address = address;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "\nAddress - " +
                "idAddress=" + idAddress +
                ", province='" + province +
                ", region='" + region + "\n" +
                "address='" + address;
    }
}
