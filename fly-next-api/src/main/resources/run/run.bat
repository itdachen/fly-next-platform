chcp 65001
@echo off

rem 指定启动文件
set AppName=fly-next-api.exe

ECHO.
	ECHO.  [1] 安装并启动应用
	ECHO.  [2] 停止并卸载应用
	ECHO.  [3] 安装应用
	ECHO.  [4] 启用应用
	ECHO.  [5] 重启应用
	ECHO.  [6] 停止应用
	ECHO.  [7] 卸载应用
	ECHO.  [8] 查看应用状态
	ECHO.  [9] 退出
ECHO.

ECHO.请输入选择项目的序号:
set /p ID=
	IF "%id%"=="1" GOTO installandstart
	IF "%id%"=="2" GOTO stopanduninstall
	IF "%id%"=="3" GOTO install
	IF "%id%"=="4" GOTO start
	IF "%id%"=="5" GOTO restart
	IF "%id%"=="6" GOTO stop
	IF "%id%"=="7" GOTO uninstall
	IF "%id%"=="8" GOTO status
	IF "%id%"=="9" EXIT
PAUSE

rem install
:install
%AppName%  install
pause
goto:eof

rem start
:start
%AppName%  start
goto:eof

:restart
%AppName% restart
pause
goto:eof

:stop
%AppName% stop
pause
goto:eof

:uninstall
%AppName% uninstall
pause
goto:eof

:installandstart
%AppName%  install

%AppName% restart
pause
goto:eof

:stopanduninstall
%AppName% stop

%AppName% uninstall
pause
goto:eof

:status
tasklist | find /i "%AppName%"
pause
goto:eof