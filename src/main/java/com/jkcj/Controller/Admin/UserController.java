package com.jkcj.Controller.Admin;

import com.jkcj.Controller.BaseController;
import com.jkcj.DO.UserDO;
import com.jkcj.Error.BusinessException;
import com.jkcj.Response.CommonReturnType;
import com.jkcj.Response.RTStr;
import com.jkcj.Service.RoleService;
import com.jkcj.Service.UserService;
import com.jkcj.VO.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * @Auther:Xhy
 * @Date:2020/2/17 20:13
 * @Description:管理端控制接口
 **/
@RestController
@RequestMapping("/admin")
@Api(value = "管理员管理接口控制器")
public class UserController extends BaseController {

    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService,RoleService roleService){
        this.userService = userService;
        this.roleService = roleService;
    }

    @ApiOperation("登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名"),
            @ApiImplicitParam(name = "password", value = "密码")
    })
    @GetMapping("/userLogin")
    public CommonReturnType userLogin(@RequestParam String userName,
                                  @RequestParam String password)throws BusinessException{
        String result = userService.userLogin(userName,password);
        return CommonReturnType.create(result);
    }

    @ApiOperation("注册接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名"),
            @ApiImplicitParam(name = "password", value = "密码"),
            @ApiImplicitParam(name = "tel", value = "联系电话")
    })
    @PostMapping("/userAdd")
    public CommonReturnType userAdd(@RequestParam String username,
                                    @RequestParam String password,
                                    @RequestParam String tel)throws BusinessException{

        String result = userService.userAdd(username,password,tel);
        return CommonReturnType.create(result);
    }


    @ApiOperation("获取个人信息")
    @GetMapping("/getUserInfo")
    public CommonReturnType getUserInfo()throws BusinessException{
        UserVO userVO = userService.getUserInfo();
        return CommonReturnType.create(userVO);
    }

    @ApiOperation("获取管理员列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页码"),
            @ApiImplicitParam(name = "pageSize", value = "页长")
    })
    @GetMapping("/getUserList")
    public CommonReturnType getUserList(@RequestParam(defaultValue = "1") Integer pageNo,
                                        @RequestParam(defaultValue = "10") Integer pageSize)throws BusinessException{
        Map userList = userService.getUserList(pageNo,pageSize);
        return CommonReturnType.create(userList);
    }

    @ApiOperation("删除管理员")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uId", value = "管理员ID"),
    })
    @GetMapping("/adminDelete")
    public CommonReturnType adminDelete(@RequestParam Integer uId)throws BusinessException{
        String result = userService.deleteAdmin(uId);
        return CommonReturnType.create(result);
    }

    @ApiOperation("获取角色列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页码"),
            @ApiImplicitParam(name = "pageSize", value = "页长")
    })
    @GetMapping("/getRoleList")
    public CommonReturnType getRoleList(@RequestParam(defaultValue = "1") Integer pageNo,
                                        @RequestParam(defaultValue = "10") Integer pageSize)throws BusinessException{
        Map result = roleService.getRoleList(pageNo,pageSize);
        return CommonReturnType.create(result);
    }

    @ApiOperation("删除角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "role_id", value = "角色ID"),
    })
    @GetMapping("/roleDelete")
    public CommonReturnType roleDelete(@RequestParam Integer role_id)throws BusinessException{
        String result = roleService.deleteRole(role_id);
        return CommonReturnType.create(result);
    }

    @ApiOperation("停用管理员")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "status",value = "将要改变的状态(0/1)"),
            @ApiImplicitParam(name = "uid",value = "管理员ID")
    })
    @GetMapping("/banAdmin")
    public CommonReturnType banAdmin(@RequestParam Integer status,@RequestParam Integer uid)throws BusinessException{
        String result = userService.banAdmin(status,uid);
        return CommonReturnType.create(result);
    }

    @ApiOperation("停用角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "status",value = "将要改变的状态(0/1)"),
            @ApiImplicitParam(name = "rid",value = "角色ID")
    })
    @GetMapping("/banRole")
    public CommonReturnType banRole(@RequestParam Integer status,@RequestParam Integer rid)throws BusinessException{
        String result = roleService.banRole(status,rid);
        return CommonReturnType.create(result);
    }

    @ApiOperation("编辑角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "角色名"),
            @ApiImplicitParam(name = "detail",value = "权限"),
            @ApiImplicitParam(name = "title",value = "权限描述"),
            @ApiImplicitParam(name = "rid",value = "角色ID")
    })
    @PostMapping("/updateRole")
    public CommonReturnType updateRole(@RequestParam(required = false) String name,@RequestParam(required = false) String detail,@RequestParam(required = false) String title ,@RequestParam @NotNull Integer rid) throws BusinessException{
        String result = roleService.updateRole(name,detail,title,rid);
        return CommonReturnType.create(result);
    }

    @ApiOperation("编辑管理员")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "登录名"),
            @ApiImplicitParam(name = "tel",value = "电话"),
            @ApiImplicitParam(name = "uid",value = "管理员ID")
    })
    @PostMapping("/updateAdmin")
    public CommonReturnType updateAdmin(@RequestParam(required = false) String username,@RequestParam(required = false) String tel,@RequestParam @NotNull Integer uid) throws BusinessException{
        String result = userService.updateUser(username,tel,uid);
        return CommonReturnType.create(result);
    }
}
