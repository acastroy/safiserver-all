#! /bin/bash
#
#  SafiServer Install Script
#  Safi Systems LLC 2009
#

# First time run configuration script
runfirstsetup="true"
CONFIG="./resources/environment.properties"
CONFIGBAK="./resources/environment.properties.bak"
SETUPFILE="./resources/setup.properties"
APPDEPLOYDIR="./deploy/linux32/"

while read line; do
   # skip comments
   [[ ${line:0:1} == "#" ]] && continue
 
   # skip empty lines
   [[ -z "$line" ]] && continue

   if [ "${line#${line%?}}" == "=" ]; then
     eval ${line//./__}" "
   else
     eval ${line//./__}
   fi

done < "$CONFIG"

touch $SETUPFILE
while read line; do
   # skip comments
   [[ ${line:0:1} == "#" ]] && continue
 
   # skip empty lines
   [[ -z "$line" ]] && continue

   if [ "${line#${line%?}}" == "=" ]; then
     eval ${line//./__}" "
   else
     eval ${line//./__}
   fi

done < "$SETUPFILE"

clear
TITLE='\E[37;44m'
BLUE='\e[1;34m'
WHITE='\033[1m'
NC='\e[0m' # No Color

# If SafiServer install script has not yet been ran
if [ "$runfirstsetup" == "true" ];
   then
   {
   echo ""
   echo -e "  ${TITLE}                                                                    ${NC}"
   echo -e "  ${TITLE}                                                                    ${NC}"
   echo -e "  ${TITLE}                          ${WHITE}Safi Systems LLC${NC}${TITLE}                          ${NC}"
   echo -e "  ${TITLE}                     SafiServer First Run Setup                     ${NC}"
   echo -e "  ${TITLE}                                                                    ${NC}"
   echo -e "  ${TITLE}      press enter to accept the current value (in parenthesis)      ${NC}"
   echo -e "  ${TITLE}                                                                    ${NC}"
   echo -e "  ${TITLE}                                                                    ${NC}"
   echo ""
   
   # Get IP Address
   OS=`uname`
   IP="" # store IP
   if [ "${#bind__addr}" -eq 0 ]; then
     case $OS in
      Linux) IP=`ifconfig  | grep 'inet addr:'| grep -v '127.0.0.1' | cut -d: -f2 | awk '{ print $1}'`;;
      FreeBSD|OpenBSD) IP=`ifconfig  | grep -E 'inet.[0-9]' | grep -v '127.0.0.1' | awk '{ print $2}'` ;;
      SunOS) IP=`ifconfig -a | grep inet | grep -v '127.0.0.1' | awk '{ print $2} '` ;;
      *) IP="Unknown";;
     esac
   else
     BINDIP=${bind__addr//__/.}  #IP=${bind__addr//__/.}
   fi
   
   #echo "  Enter the IP address you want the SafiServer to bind to."
   #echo -n "  SafiServer bind IP (${IP}): "
   #read -e BINDIP
   #if [ "${#BINDIP}" -eq 0 ]; 
   #  then BINDIP=${IP}
   #fi
   
   echo ""
   echo "  Enter the TCP port that the SafiServer FastAGI server will run on."
   echo -n "  FastAGI port (${fastagi__port//__/.}): "
   read -e FastAGIPORT
   if [ "${#FastAGIPORT}" -eq 0 ]; 
    then FastAGIPORT=${fastagi__port//__/.}
   fi

   
   echo ""
   echo "  Enter the sa password for the SafiServer database"
   echo -n "  sa password (${user__password//__/.}): "
   read -e SAPASS
   if [ "${#SAPASS}" -eq 0 ]; 
    then SAPASS=${user__password//__/.}
   fi
   
   # Get path
   safiserverPath=`pwd`
   echo ""
   echo "  Path to SafiServer install"
   echo -n "  Path (${safiserverPath}): "
   read -e SSPATH
   if [ "${#SSPATH}" -eq 0 ]; 
    then SSPATH=${safiserverPath}
   fi

   echo ""
   echo ""
   echo "  Creating backup of environment.properties file:" 
   echo "  $CONFIGBAK"
   cp $CONFIG $CONFIGBAK

   rm -f $CONFIG
   touch $CONFIG

   echo ""
   echo ""
   echo "  Updating settings..." 
   while read line; do
      eqPos=`expr index "$line" "="`
      let eqPos=$eqPos-1
      if [ "$eqPos" -gt 0 ]; then
      tempName=${line:0:$eqPos}
         if [ "$tempName" == "bind.addr" ]; then
            echo "bind.addr=$BINDIP" >> $CONFIG
         elif [ "$tempName" == "fastagi.port" ]; then
            echo "fastagi.port=$FastAGIPORT" >> $CONFIG
         elif [ "$tempName" == "user.password" ]; then
            echo "user.password=$SAPASS" >> $CONFIG
         elif [ "$tempName" == "runfirstsetup" ]; then
            echo "runfirstsetup=false" >> $CONFIG
         else 
            echo ${line} >> $CONFIG
         fi
      else
        echo ${line} >> $CONFIG
      fi
     
   done < "$CONFIGBAK"

   echo ""
   echo ""
   echo -e  "  Creating ${BLUE}safiserverd${NC} service..."
   cd $SSPATH
   cd $APPDEPLOYDIR
   sed -e 's:SAFISERVER_DIR=:SAFISERVER_DIR='$SSPATH':g' safiserverd.org > safiserverd
   cp -f safiserverd /etc/init.d/safiserverd
   chmod +x /etc/init.d/safiserverd
   
   if [ -x /sbin/chkconfig ] ; then
		echo ""
		echo "  Adding SafiServer service to auto-start (with chkconfig)"
		echo ""
   else
		echo ""
		echo "  ***  Unable to install SafiServer as an auto-start service  ***"
		echo "  ***  Enter the following command to start SafiServer:       ***"
		echo "  ***  sudo /etc/init.d/safiserverd start                     ***"
		echo ""
	fi
   
   
   cd $SSPATH
   echo "runfirstsetup=false" > $SETUPFILE
   echo ""
   echo ""
   echo -e  "  Running ${BLUE}/etc/init.d/safiserverd start${NC} ..."
   echo ""
   echo ""
   /etc/init.d/safiserverd start
   
   exit 0
   }
else 
   {
   echo ""
   echo -e "  ${TITLE}                                                                    ${NC}"
   echo -e "  ${TITLE}                                                                    ${NC}"
   echo -e "  ${TITLE}                          ${WHITE}Safi Systems LLC${NC}${TITLE}                          ${NC}"
   echo -e "  ${TITLE}                    SafiServer Already Installed                    ${NC}"
   echo -e "  ${TITLE}                                                                    ${NC}"
   echo -e "  ${TITLE}                                                                    ${NC}"
   echo ""
   }
fi