package cacheProgramCreational;

public class LFUCacheItem {
    private String key;
    private Integer value;
    private int frequency;
    public LFUCacheItem() {}
    public LFUCacheItem(String key, Integer value) {
        this.key = key;
        this.value = value;
        this.frequency = 1;
    }
    // defining Prototype
    public LFUCacheItem clone() {
        LFUCacheItem clonedCacheItem = new LFUCacheItem();
        clonedCacheItem.setKey(this.key);
        clonedCacheItem.setValue(this.value);
        clonedCacheItem.setFrequency(this.frequency);

        return clonedCacheItem;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setKey(String key_) {
        this.key = key_;
    }

    public String getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }

    public int getFrequency() {
        return frequency;
    }
}
