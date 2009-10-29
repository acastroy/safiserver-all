@echo off
setlocal

rem Copyright (c) 1999, 2006 Tanuki Software Inc.
rem
rem Java Service Wrapper general startup script
rem

rem
rem Resolve the real path of the wrapper.exe
rem  For non NT systems, the _REALPATH and _WRAPPER_CONF values
rem  can be hard-coded below and the following test removed.
rem
rem echo %OS%
if "%OS%"=="Windows_NT" goto nt
echo This script only works with NT-based versions of Windows.
goto :eof

:nt
rem
rem Find the application home.
rem
rem %~dp0 is location of current script under NT
set _REALPATH=%~dp0
rem echo %_REALPATH%

rem Decide on the wrapper binary.
set _WRAPPER_BASE=wrapper
rem set _WRAPPER_EXE=%_REALPATH%%_WRAPPER_BASE%-windows-x86-32.exe
set _WRAPPER_EXE=%_REALPATH%%_WRAPPER_BASE%.exe
rem echo %_WRAPPER_EXE%
if exist "%_WRAPPER_EXE%" goto conf
set _WRAPPER_EXE=%_REALPATH%%_WRAPPER_BASE%-windows-x86-64.exe
if exist "%_WRAPPER_EXE%" goto conf
set _WRAPPER_EXE=%_REALPATH%%_WRAPPER_BASE%.exe
if exist "%_WRAPPER_EXE%" goto conf
echo Unable to locate a Wrapper executable using any of the following names:
echo %_REALPATH%%_WRAPPER_BASE%-windows-x86-32.exe
echo %_REALPATH%%_WRAPPER_BASE%-windows-x86-64.exe
echo %_REALPATH%%_WRAPPER_BASE%.exe
pause
goto :eof

rem
rem Find the wrapper.conf
rem
:conf
set _WRAPPER_CONF="%~f1"
rem echo %_WRAPPER_CONF%
if not %_WRAPPER_CONF%=="" goto startup
rem echo past startup

rem Uncomment and use for Local
set _WRAPPER_CONF="wrapper.conf"

rem Use for Dev,IT,UAT,PROD
rem set _WRAPPER_CONF="%_REALPATH%..\properties\wrapper.conf"
echo %_WRAPPER_CONF% after startup
rem
rem Start the Wrapper
rem
:startup
echo startup
echo %_WRAPPER_CONF%
"%_WRAPPER_EXE%" --stop %_WRAPPER_CONF%
if not errorlevel 1 goto :eof
pause

