# 基础增删改查的springboot系统(目前只有后端代码)
面向初学者的简单的小项目
---
## 主要功能
用户注册信息，添加银行卡号，模拟网上银行，目前只有存款取款，查看历史记录的功能
## 技术要点
- springSecurity登陆拦截
- 异常抛出的形式
- restful返回的json形式
- mybatis查询

## 运行过程
想要让它动起来，需要三步
- 找到resources下面的sql文件，在自己的mysql里面建立一个数据库叫spring，然后在spring里面把表建立了
- 修改application.yml配置文件
- 右键点击run运行
## 计划下一步
- 添加前端
- 增加转账功能
- 增加管理员