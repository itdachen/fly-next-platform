chcp 65001
@echo off

rem 指定启动文件
set AppName=fly-run.exe

ECHO.
	ECHO.  [1] startup
	ECHO.  [2] shutdown
	ECHO.  [3] status
	ECHO.  [4] EXIT
ECHO.

ECHO.请输入选择项目的序号:
set /p ID=
	IF "%id%"=="1" GOTO startup
	IF "%id%"=="2" GOTO shutdown
	IF "%id%"=="3" GOTO status
	IF "%id%"=="4" EXIT
PAUSE

:startup
%AppName% install
echo -------------------------------------------
%AppName% start
echo startup success...
pause
goto:eof

:shutdown
%AppName% stop
echo -------------------------------------------
%AppName% uninstall
echo shutdown success...
pause
goto:eof

:status
echo querying status ...
tasklist | find /i "%AppName%"
pause
goto:eof