@echo off

rem 指定启动文件
set AppName=fly-next-admin.exe

ECHO.
	ECHO.  [1] install and start
	ECHO.  [2] stop and uninstall
	ECHO.  [3] install
	ECHO.  [4] start
	ECHO.  [5] restart
	ECHO.  [6] stop
	ECHO.  [7] uninstall
	ECHO.  [8] status
	ECHO.  [9] EXIT
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

rem install app
:install
%AppName%  install
echo  install……
echo  %AppName% install success...
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