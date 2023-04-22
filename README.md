<div align="center">
<br/>
<br/>
  <h1 align="center">
    fly-next-platform
  </h1>
  <h4 align="center">
    开 箱 即 用 的 前 后 端 脚 手 架 框 架
  </h4>
</div>

<p align="center">
    <a href="#">
        <img src="https://img.shields.io/badge/SpringBoot-2.7.10+-green.svg" alt="Pear Admin Layui Version">
    </a>
    <a href="#">
        <img src="https://img.shields.io/badge/JQuery-3.6.4+-green.svg" alt="Jquery Version">
    </a>
    <a href="#">
        <img src="https://img.shields.io/badge/Layui-2.7.6+-green.svg" alt="Layui Version">
    </a>
    <a href="#">
        <img src="https://img.shields.io/badge/node-16.12.0+-green.svg" alt="Layui Version">
    </a>
    <a href="#">
        <img src="https://img.shields.io/badge/vue-3.2.0+-green.svg" alt="Layui Version">
    </a>
</p>

<br>

### 🌈 介绍

### ⛱️ 核心依赖

| 依赖          | 版本     |
|-------------|--------|
| Spring Boot | 2.7.10 |
| Mybatis     | 3.5.11 |
| pagehelper  | 5.3.2  |
| fastjson    | 2.0.21 |
| hutool      | 5.8.11 |

### ⛱️ 预览界面

| 界面                                 | 界面                                 |
|------------------------------------|------------------------------------|
| ![](docs/resources/images/001.png) | ![](docs/resources/images/002.png) |
| ![](docs/resources/images/003.png) | ![](docs/resources/images/004.png) |
| ![](docs/resources/images/005.png) | ![](docs/resources/images/006.png) ||

### 💒 代码依赖仓库

* [码云](https://gitee.com/itdachen/fly-framework)
* [Github](https://github.com/itdachen/fly-framework)

### 🚧 安装方式

* 基础依赖项目:

```lua 
fly-framework
```

* IDEA 打开 fly-framework

```lua 
cd /fly-dependencies
mvn clean 
mvn install
```

* 返回根目录安装基础依赖(fly-framework)

```lua 
cd ..
mvn clean 
mvn install
```

### 🏭 模块说明

```lua
fly-next-platform
├── fly-app -- 微信小程序
├── fly-next-admin -- 后台管理系统
├── fly-next-api -- 前后端分离接口模块
├── fly-next-server -- 项目开发模块
├── fly-ui -- 前后端分离VUE前端
└── end
```