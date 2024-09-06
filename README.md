# 简单的分页查询操作
### 代码实现
- `MybatisPlusConfig`
  - 配置Mybatis Plus插件

  ```java
  @Configuration
  public class MybatisPlusConfig {
      
      @Bean
      public MybatisPlusInterceptor mybatisPlusInterceptor() {
          MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
          interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
          return interceptor;
      }
  }
  ```
  
- `UserInfoController`
  - 提供用户信息分页查询的接口。
  - `/userInfo/page`：接收POST请求，根据用户名进行模糊查询，并返回分页结果。

  ```java
  @RestController
  @RequestMapping("/userInfo")
  public class UserInfoController {
      
      private final UserInfoService userInfoService;
      
      @Autowired
      public UserInfoController(UserInfoService userInfoService) {
          this.userInfoService = userInfoService;
      }
      
      @PostMapping("/page")
      public Resp<?> page(@RequestBody UserQuery userQuery) {
          
          LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
          queryWrapper.orderByDesc(UserInfo::getUserId);
          
          if(!"".equals(userQuery.getUserName()) && (userQuery.getUserName() != null)){
              queryWrapper.like(UserInfo::getUserName, userQuery.getUserName());
          }
          
          Page<UserInfo> page = userInfoService.page(
                  new Page<>(
                          userQuery.getPageNum(),
                          userQuery.getPageSize()
                  ),
                  queryWrapper
          );
          return Resp.success(page);
      }
      
  
  }
  ```
  
- `UserQuery`
  - 请求参数DTO，包含用户名、页码和每页大小。

  ```java
  @Data
  public class UserQuery extends PageInfo {
      
      private String userName;
      
  }
  ```
  
- `PageInfo`
  
  - 分页信息DTO，包含页码和每页大小。
  
  ```java
  @Data
  public class PageInfo {
      private int PageNum;
      private int PageSize;
  }
  ```

### 效果展示

可以到swagger界面进行测试

![image-20240906225657451](https://gitee.com/zzy2401/picbed/raw/master/images/image-20240906225657451.png)
