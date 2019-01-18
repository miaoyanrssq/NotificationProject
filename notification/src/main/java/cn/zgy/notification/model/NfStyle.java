package cn.zgy.notification.model;

public enum NfStyle {
    NRONAL(0),
    DOWNLOAD(1),
    DOWNLOAD_2(2),
    BIGTEXT(3),
    INBOX(4),
    BIGPICTURE(5),
    HUNGUP(6),
    MEDIA(7),
    REMOTEVIEW(8)
    ;

    private int code;
    NfStyle(int code) {
        this.code = code;
    }

    public int getCode(){
        return code;
    }
}
