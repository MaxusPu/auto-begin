package testdata;

public class User {

    private String profileId;
    private String qrUuid;

    public User(String profileId, String qrUuid) {
        this.profileId = profileId;
        this.qrUuid = qrUuid;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getQrUuid() {
        return qrUuid;
    }

    public void setQrUuid(String qrUuid) {
        this.qrUuid = qrUuid;
    }
}
