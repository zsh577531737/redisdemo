package com.example.redisdemo.redis;

public enum RedisConstants {
    DB_1(1),
    DB_2(2),
    DB_3(3),
    DB_4(4),
    DB_5(5),
    DB_6(6),
    DB_7(7),
    DB_8(8),
    DB_9(9),
    DB_10(10);

    private int dbId;

    RedisConstants(int dbId) {
        this.dbId = dbId;
    }

    public int getDbId() {
        return dbId;
    }

    public void setDbId(int dbId) {
        this.dbId = dbId;
    }
}
