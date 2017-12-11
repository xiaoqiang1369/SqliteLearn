package com.xiaoqiang.sqlitelearn.sqlite.bean;

/**
 * Description: 单次训练
 * Created by crx on 2017/12/8.
 */

public class TrainBean {
    private String id;      //用户id
    private long time;     //训练时间，用时间戳表示
    private int duration;  //训练时长，用秒表示
    private int jumps;     //跳绳个数

    public TrainBean(String id, long time, int duration, int jumps) {
        this.id = id;
        this.time = time;
        this.duration = duration;
        this.jumps = jumps;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getJumps() {
        return jumps;
    }

    public void setJumps(int jumps) {
        this.jumps = jumps;
    }

    @Override
    public String toString() {
        return "TrainBean{" +
                "id='" + id + '\'' +
                ", time=" + time +
                ", duration=" + duration +
                ", jumps=" + jumps +
                '}';
    }
}
