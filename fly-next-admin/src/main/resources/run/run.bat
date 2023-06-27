chcp 65001
@echo off

rem 指定启动文件
set AppName=fly-run.exe

ECHO.
	ECHO.  [1] install and start
	ECHO.  [2] stop and uninstall
	ECHO.  [3] status
	ECHO.  [4] EXIT
ECHO.

ECHO.请输入选择项目的序号:
set /p ID=
	IF "%id%"=="1" GOTO installandstart
	IF "%id%"=="2" GOTO stopanduninstall
	IF "%id%"=="3" GOTO status
	IF "%id%"=="4" EXIT
PAUSE

rem install
:install
echo install %AppName% ...
%AppName%  install
echo install %AppName% success...
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
echo -------------------------------------------
%AppName% restart
pause
goto:eof

:stopanduninstall
%AppName% stop
echo -------------------------------------------
%AppName% uninstall
pause
goto:eof

:status
echo querying %AppName% status ...
tasklist | find /i "%AppName%"
pause
goto:eof