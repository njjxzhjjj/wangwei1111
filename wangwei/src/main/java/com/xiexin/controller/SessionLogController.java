package com.xiexin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiexin.bean.SessionLog;
import com.xiexin.respcode.Result;
import com.xiexin.service.SessionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sessionLog")
public class SessionLogController {
    @Autowired
    private SessionLogService sessionLogService;

    @RequestMapping("/selectAll") // /sessionLog/selectAll
    public Result selectAll(){
        List<SessionLog> sessionLogs = sessionLogService.selectByExample(null);// select * from student
        Result  result =new Result(sessionLogs);
        return result;
    }
    //  （带参数的）分页查询
    @RequestMapping("/selectPageAll") // /student/selectPageAll
    public Result selectPageAll(@RequestParam(value = "page",defaultValue = "1",required = true) Integer page,
                                @RequestParam(value = "limit",defaultValue = "10",required = true)Integer pageSize){
        //使用的是 pagehelper 分页
        PageHelper.startPage(page,pageSize);
        List<SessionLog> sessionLogs = sessionLogService.selectByExample(null);
        PageInfo pageInfo = new PageInfo(sessionLogs);
        Result result = new Result(pageInfo);
        return result;
    }

}
