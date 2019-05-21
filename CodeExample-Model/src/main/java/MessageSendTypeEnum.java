
import java.util.HashMap;
import java.util.Map;

/**
 * Created by FMC on 2017/11/4.
 */
public enum MessageSendTypeEnum {
    //发送类型  1 立即发送  2 定时发送
    SEND_TYPE_NOW(1, "立即发送"),
    SEND_TYPE_SCHEDULE(2, "定时发送");

    public static Map<Integer, String> enumMap = new HashMap();

    static {
        MessageSendTypeEnum[] items = MessageSendTypeEnum.values();
        for (MessageSendTypeEnum item : items) {
            enumMap.put(item.getKey(), item.getValue());
        }
    }

    public static Integer getKeyByValue(String value) {
        MessageSendTypeEnum[] channels = MessageSendTypeEnum.values();
        for (MessageSendTypeEnum channel : channels) {
            if (channel.getValue().equalsIgnoreCase(value)) {
                return channel.getKey();
            }
        }
        return null;
    }

    public static String getValueByKey(Integer key) {
        MessageSendTypeEnum[] channels = MessageSendTypeEnum.values();
        for (MessageSendTypeEnum channel : channels) {
            if (channel.getKey() == key) {
                return channel.getValue();
            }
        }
        return null;
    }

    private MessageSendTypeEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    private Integer key;
    private String value;

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
