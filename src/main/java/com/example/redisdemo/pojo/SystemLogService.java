package com.example.redisdemo.pojo;

public interface SystemLogService {
    int deleteSystemLog(String id);

    int insert(SystemLog record);

    int insertTest(SystemLog record);

    SystemLog selectSystemLog(String id);

    int updateSystemLog(SystemLog record);
}
