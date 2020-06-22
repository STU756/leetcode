package com.jia.leetCode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 提示：
 *
 * 总共最多有 20000 次操作。
 * 1 <= id, t <= 10^6
 * 所有的字符串包含大写字母，小写字母和数字。
 * 1 <= stationName.length <= 10
 * 与标准答案误差在 10^-5 以内的结果都视为正确结果。
 *
 */
public class Pro5370 {
    public class Info {
        public int id;
        public String inStationName;
        public int inTime;
        public int outTime;
        public String outStationName;
        public Info(int id, String name, int in) {
            this.id = id;
            this.inStationName = name;
            this.inTime = in;
        }
    }

    Set<Info> inSet;
    Set<Info> outSet;

    public Pro5370() {
        inSet = new HashSet<>();
        outSet = new HashSet<>();
    }

    public void checkIn(int id, String stationName, int t) {
        inSet.add(new Info(id, stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Iterator<Info> it = inSet.iterator();
        while (it.hasNext()) {
            Info info = it.next();
            if (info.id == id) {
                info.outStationName = stationName;
                info.outTime = t;
                outSet.add(info);
                inSet.remove(info);
                break;
            }
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        Iterator<Info> it = outSet.iterator();
        double sum = 0.0;
        int num = 0;
        while (it.hasNext()) {
            Info info = it.next();
            if (info.inStationName.equals(startStation) && info.outStationName.equals(endStation)) {
                sum += info.outTime - info.inTime;
                num ++;
            }
        }
        return sum / num;
    }
}
