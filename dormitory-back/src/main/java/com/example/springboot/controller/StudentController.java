package com.example.springboot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.common.Result;
import com.example.springboot.entity.DormRoom;
import com.example.springboot.entity.Student;
import com.example.springboot.entity.User;
import com.example.springboot.service.DormRoomService;
import com.example.springboot.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@RestController
@RequestMapping("/stu")
public class StudentController {
    @Resource
    private DormRoomService dormRoomService;
    @Resource
    private StudentService studentService;
    int RoomId = -1, bedId = -1;

    /**
     * 添加学生信息
     */
    @PostMapping("/add")
    public Result<?> add(@RequestBody Student student) {
        //添加学生
        int i = 0, j = 0;
        //让学生入住空床位
        //获取一个空的床位
        //判断性别
        if (Objects.equals(student.getGender(), "男")) {
            //遍历男寝，找出空房
            result:
            for (int dormRoomId = 1100; dormRoomId < 1306; dormRoomId++) {
                if ((dormRoomService.checkRoomExist(dormRoomId) != null) && dormRoomService.checkRoomExist(dormRoomId).getCurrentCapacity() != 4) {
                    System.out.println("存在空房间" + dormRoomId);
                    RoomId = dormRoomId;
                    for (int bedNum = 1; bedNum <= 4; bedNum++) {
                        if (dormRoomService.checkBedState(dormRoomId, bedNum) != null) {
                            System.out.println("存在床位" + bedNum);
                            bedId = bedNum;
                            break result;
                        }
                    }
                }
            }
        } else {
            //遍历女寝，找出空床
            result:
            for (int dormRoomId = 2100; dormRoomId < 2306; dormRoomId++) {
                if ((dormRoomService.checkRoomExist(dormRoomId) != null) && dormRoomService.checkRoomExist(dormRoomId).getCurrentCapacity() != 4) {
                    System.out.println("存在空房间" + dormRoomId);
                    RoomId = dormRoomId;
                    for (int bedNum = 1; bedNum <= 4; bedNum++) {
                        if (dormRoomService.checkBedState(dormRoomId, bedNum) != null) {
                            System.out.println("存在床位" + bedNum);
                            bedId = bedNum;
                            break result;
                        }
                    }
                }
            }
        }
        //更新调宿表信息
        i = dormRoomService.NewAddStudent(student, RoomId, bedId);
        j = studentService.addNewStudent(student);
        if (i == 1&&j==1) {
            return Result.success();
        } else {
            return Result.error("-1", "学生添加失败");
        }
    }


    /**
     * 更新学生信息
     */
    @PutMapping("/update")
    public Result<?> update(@RequestBody Student student) {
        int i = studentService.updateNewStudent(student);
        if (i == 1) {
            return Result.success();
        } else {
            return Result.error("-1", "更新失败");
        }
    }

    /**
     * 删除学生信息
     */
    @DeleteMapping("/delete/{username}")
    public Result<?> delete(@PathVariable String username) {
        int i = studentService.deleteStudent(username);
        if (i == 1) {
            return Result.success();
        } else {
            return Result.error("-1", "删除失败");
        }
    }

    /**
     * 查找学生信息
     */
    @GetMapping("/find")
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search) {
        Page page = studentService.find(pageNum, pageSize, search);
        if (page != null) {
            return Result.success(page);
        } else {
            return Result.error("-1", "查询失败");
        }
    }

    /**
     * 学生登录
     */
    @PostMapping("/login")
    public Result<?> login(@RequestBody User user, HttpSession session) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        Object o = studentService.stuLogin(user.getUsername(), user.getPassword());
        if (o != null) {
            System.out.println(o);
            //存入session
            session.setAttribute("Identity", "stu");
            session.setAttribute("User", o);
            return Result.success(o);
        } else {
            return Result.error("-1", "用户名或密码错误");
        }
    }

    /**
     * 主页顶部：学生统计
     */
    @GetMapping("/stuNum")
    public Result<?> stuNum() {
        int num = studentService.stuNum();
        if (num > 0) {
            return Result.success(num);
        } else {
            return Result.error("-1", "查询失败");
        }
    }


    /**
     * 床位信息，查询是否存在该学生
     * 床位信息，查询床位上的学生信息
     */
    @GetMapping("/exist/{value}")
    public Result<?> exist(@PathVariable String value) {
        Student student = studentService.stuInfo(value);
        if (student != null) {
            return Result.success(student);
        } else {
            return Result.error("-1", "不存在该学生");
        }
    }
}
