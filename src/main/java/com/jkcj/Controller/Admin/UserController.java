package com.jkcj.Controller.Admin;

import com.jkcj.Controller.BaseController;
import com.jkcj.DO.UserDO;
import com.jkcj.Error.BusinessException;
import com.jkcj.Response.CommonReturnType;
import com.jkcj.Service.UserService;
import com.jkcj.VO.UserVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther:Xhy
 * @Date:2020/2/17 20:13
 * @Description:管理端控制接口
 **/
@RestController
@RequestMapping("/admin")
public class UserController extends BaseController {

    private final UserService userService;

    public UserController(UserService userService){this.userService = userService;}

    @ApiOperation("获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户id"),
    })
    @GetMapping("/getUserInfo")
    public CommonReturnType getUserInfo(@RequestParam Integer uid)throws BusinessException{
        UserVO userVO = userService.getUserInfo(uid);
        return CommonReturnType.create(userVO);
    }
}
