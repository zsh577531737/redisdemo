package com.example.redisdemo.pojo;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("systemLogService")
public class SystemLogServiceImpl implements SystemLogService{
//    @Resource
//    private SystemLogMapper systemLogMapper;

    @Override
    public int deleteSystemLog(String id) {
        System.out.println("deleteSystemLog");
        return  0;
//        return systemLogMapper.deleteByPrimaryKey(id);
    }

    @Override

    public int insert(SystemLog record) {
        System.out.println("insert");
        return  0;
//        return systemLogMapper.insertSelective(record);

    }

    @Override
    public SystemLog selectSystemLog(String id) {
        System.out.println("selectSystemLog");
        return  null;
//        return systemLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateSystemLog(SystemLog record) {
        System.out.println("updateSystemLog");
        return  0;
//        return systemLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertTest(SystemLog record) {
        System.out.println("insertTest");
            return  0;
//        return systemLogMapper.insert(record);
    }
}
